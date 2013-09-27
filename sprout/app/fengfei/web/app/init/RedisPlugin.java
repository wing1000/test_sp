package fengfei.web.app.init;

import java.util.Properties;

import org.apache.commons.pool.impl.GenericObjectPool.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.Play;
import play.PlayPlugin;
import fengfei.fir.rank.LastRank;
import fengfei.fir.rank.PopularRank;
import fengfei.fir.rank.UpcomingRank;
import fengfei.forest.slice.plotter.HashPlotter;
import fengfei.shard.Ploy;
import fengfei.shard.Selector;
import fengfei.shard.redis.ShardsRedis;

public class RedisPlugin extends PlayPlugin {

    static Logger logger = LoggerFactory.getLogger(RedisPlugin.class);
    final static String HostsKey = "redis.hosts";
    final static String TimeoutKey = "redis.timeout";
    final static String PloyKey = "redis.ploy.class";

    @Override
    public void onApplicationStart() {
        Properties p = Play.configuration;
        String hosts = p.getProperty(HostsKey, "localhost:6379");
        String timeoutStr = p.getProperty(TimeoutKey, "localhost:6379");
        int timeout = Integer.parseInt(timeoutStr);
        String ployClass = p.getProperty(PloyKey, HashPlotter.class.getCanonicalName());
        try {
            Ploy ploy = (Ploy) Class.forName(ployClass).newInstance();
            ShardsRedis redis = new ShardsRedis(hosts, timeout, ploy, readConfig());

            //
            LastRank.read = redis.createRedisCommand();
            LastRank.write = redis.createRedisCommand(Selector.Write);
            //
            //
            PopularRank.read = redis.createRedisCommand();
            PopularRank.write = redis.createRedisCommand(Selector.Write);
            //
            UpcomingRank.read = redis.createRedisCommand();
            UpcomingRank.write = redis.createRedisCommand(Selector.Write);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Config readConfig() {
        String prefix = "redis.pool.";
        Config cfg = new Config();
        Properties p = Play.configuration;
        cfg.lifo = Boolean.valueOf(p.getProperty(prefix + "lifo", "true"));
        cfg.maxActive = Integer.valueOf(p.getProperty(prefix + "maxActive", "18"));
        cfg.maxIdle = Integer.valueOf(p.getProperty(prefix + "maxIdle", "6"));
        cfg.maxWait = Integer.valueOf(p.getProperty(prefix + "maxWait", "150000"));
        cfg.minEvictableIdleTimeMillis = Integer.valueOf(p.getProperty(prefix
                + "minEvictableIdleTimeMillis", "100000"));
        cfg.minIdle = Integer.valueOf(p.getProperty(prefix + "minIdle", "0"));
        cfg.numTestsPerEvictionRun = Integer.valueOf(p.getProperty(prefix
                + "numTestsPerEvictionRun", "1"));
        cfg.testOnBorrow = Boolean.valueOf(p.getProperty(prefix + "testOnBorrow", "false"));
        cfg.testOnReturn = Boolean.valueOf(p.getProperty(prefix + "testOnReturn", "false"));
        cfg.testWhileIdle = Boolean.valueOf(p.getProperty(prefix + "testWhileIdle", "false"));
        cfg.timeBetweenEvictionRunsMillis = Integer.valueOf(p.getProperty(prefix
                + "timeBetweenEvictionRunsMillis", "120000"));
        cfg.whenExhaustedAction = Byte.valueOf(
            p.getProperty(prefix + "whenExhaustedAction", "1"),
            10);

        return cfg;

    }
}
