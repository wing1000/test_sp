package fengfei.web.app.init;

import fengfei.fir.queue.*;
import fengfei.fir.search.lucene.LuceneFactory;
import fengfei.fir.search.lucene.PhotoIndexCreator;
import fengfei.fir.search.lucene.Searcher;
import fengfei.fir.search.lucene.UserIndexCreator;
import fengfei.fir.utils.PausableLock;
import play.Play;
import play.PlayPlugin;

import java.util.Properties;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SearchPlugin extends PlayPlugin {


    @Override
    public void onApplicationStart() {
        Properties p = Play.configuration;
        String photoQueuePath = p.getProperty("fqueue.path.photo");
        String lucenePhotoPath = p.getProperty("lucene.index.path.photo");

        String userConsumerSizeStr = p.getProperty("queue.user.consumer.size");
        String photoConsumerSizeStr = p.getProperty("queue.photo.consumer.size");
        String keepAliveTimeStr = p.getProperty("queue.consumer.keepAliveTime");
        String incrementStr = p.getProperty("queue.consumer.max.increment");
        int userConsumerSize = Integer.parseInt(userConsumerSizeStr);
        int photoConsumerSize = Integer.parseInt(photoConsumerSizeStr);
        float increment = Float.parseFloat(incrementStr);
        int corePoolSize = userConsumerSize + photoConsumerSize;
        int maximumPoolSize = corePoolSize * new Float(1 + increment).intValue();
        long keepAliveTime = Long.parseLong(keepAliveTimeStr);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                corePoolSize,// corePoolSize
                maximumPoolSize,// maximumPoolSize
                keepAliveTime,// keepAliveTime
                TimeUnit.MILLISECONDS,// TimeUnit
                new SynchronousQueue<Runnable>());

        String photoQueueName = "queue_photo";
        QueueService photoQueueService = new QueueServiceFQueueImpl(photoQueueName, photoQueuePath);
        PausableLock photoPausableLock = new PausableLock();
        PhotoQueue.queueProducer = new QueueProducer(photoQueueService, photoPausableLock);
        //lucene
        LuceneFactory photoLuceneFactory = LuceneFactory.get(lucenePhotoPath);
        PhotoIndexCreator photoIndexCreator = new PhotoIndexCreator(photoLuceneFactory);
        PhotoQueueConsumer photoQueueConsumer = new PhotoQueueConsumer(photoQueueService, photoPausableLock, photoIndexCreator);

        for (int i = 0; i < photoConsumerSize; i++) {
            poolExecutor.execute(photoQueueConsumer);
        }
        //user queue consume and index create.
        String userQueuePath = p.getProperty("fqueue.path.user");
        String luceneUserPath = p.getProperty("lucene.index.path.user");

        String userQueueName = "queue_user";
        QueueService userQueueService = new QueueServiceFQueueImpl(userQueueName, userQueuePath);
        PausableLock userPausableLock = new PausableLock();
        UserQueue.queueProducer = new QueueProducer(userQueueService, userPausableLock);
        //lucene
        LuceneFactory userLuceneFactory = LuceneFactory.get(luceneUserPath);
        UserIndexCreator userIndexCreator = new UserIndexCreator(userLuceneFactory);
        UserQueueConsumer userQueueConsumer = new UserQueueConsumer(userQueueService, userPausableLock, userIndexCreator);
        for (int i = 0; i < userConsumerSize; i++) {
            poolExecutor.execute(userQueueConsumer);
        }

        //
        Searcher.userSearcher = new Searcher(userLuceneFactory);
        Searcher.photoSearcher = new Searcher(photoLuceneFactory);
    }


}