package org.bobo.util.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Author: bobo
 * @Date: 2020/11/24 14:28
 */
public class HeartBeatTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatTask.class);
    private CuratorFramework cf;
    private String nodePath;

    public HeartBeatTask(CuratorFramework cf, String nodePath) {
        this.cf = cf;
        this.nodePath = nodePath;
    }

    @Override
    public void run() {
        long timestamp = System.currentTimeMillis();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String heartBeatTime = format.format(timestamp);
        try {
            cf.setData().forPath(nodePath,heartBeatTime.getBytes());
        } catch (Exception e) {
            logger.error("HeartBeatTask send hear-beat error!",e);
        }
    }
}
