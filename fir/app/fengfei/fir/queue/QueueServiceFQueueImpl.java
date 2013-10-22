package fengfei.fir.queue;

import com.google.code.fqueue.FQueue;
import fengfei.fir.serializer.KryoSerializer;
import fengfei.fir.serializer.ObjectSerializer;
import fengfei.fir.utils.PausableLock;
import fengfei.ucm.entity.profile.UserPwd;

import java.io.File;

/**
 */
public class QueueServiceFQueueImpl implements QueueService {
    final static String QueueName = "q1";
    private ObjectSerializer serializer = new KryoSerializer();
    private String path = "/opt/data/fqueue/";
    private String queueName;
    private FQueue queue;
    private PausableLock pausableLock;

    public QueueServiceFQueueImpl() {
    }

    public QueueServiceFQueueImpl(String queueName, String path) {
        this.queueName = queueName;
        this.path = path;
    }

    public void setSerializer(ObjectSerializer serializer) {
        this.serializer = serializer;
    }

    public void start() throws Exception {
        File file = new File(path);
        if (!file.exists()) file.mkdirs();
        queue = new FQueue(path);
    }

    @Override
    public <T> void add(QueueMessage<T> item) {
        byte[] bytes = serializer.write(item);
        queue.add(bytes);
    }

    @Override
    public <T> QueueMessage<T> poll() {
        byte[] bytes = queue.poll();
        if (bytes == null) return null;
        return serializer.read(bytes, QueueMessage.class);
    }

    public void close() {
        queue.close();
    }

    public static void main(String[] args) throws Exception {
        QueueService qs = new QueueServiceFQueueImpl("q1", "/opt/xx/index");
        qs.start();
        for (int i = 0; i < 100; i++) {
            UserPwd userPwd = new UserPwd(
                    i + "xxx@163.com",
                    i + "_user",
                    i + "_password");
            QueueMessage<UserPwd> message = new QueueMessage<>(
                    QueueMessage.MessageType.Photo,
                    QueueMessage.OperationType.Add,
                    userPwd);
            qs.add(message);
        }
        for (int i = 0; i < 150; i++) {
            QueueMessage<UserPwd> message = qs.poll();
            if (message == null) {
                System.out.println("0");
            } else System.out.println(message);
        }
        qs.close();
    }
}