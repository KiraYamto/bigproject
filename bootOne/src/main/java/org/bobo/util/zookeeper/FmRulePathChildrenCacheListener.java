package org.bobo.util.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: bobo
 * @Date: 2020/11/23 16:05
 */
public class FmRulePathChildrenCacheListener implements PathChildrenCacheListener {
    private static final Logger logger = LoggerFactory.getLogger(FmRulePathChildrenCacheListener.class);
    private String parentNodePath;

    private int heartBeat;

    public FmRulePathChildrenCacheListener(String parentNodePath, int heartBeat) {
        this.parentNodePath = parentNodePath;
        this.heartBeat = heartBeat;
    }

    @Override
    public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
        ChildData data = event.getData();
        switch (event.getType()) {
            case CHILD_ADDED:
                logger.info("子节点增加, path={}, data={}", data.getPath(), data.getData());
                break;
            case CHILD_UPDATED:
                logger.info("子节点更新, path={}, data={}", data.getPath(), new String(curatorFramework.getData().forPath(data.getPath())));
                judgeChildrenOnline(curatorFramework);
                break;
            case CHILD_REMOVED:
                logger.info("子节点删除, path={}, data={}", data.getPath(), data.getData());
                break;
            default:
                break;
        }
    }

    public void judgeChildrenOnline(CuratorFramework cf){
        try {
            List<String> childrenNodes = cf.getChildren().forPath(parentNodePath);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            long timestamp = System.currentTimeMillis();
            Date now = new Date(timestamp);
            for(String child:childrenNodes){
                String childTimeStamp = new String(cf.getData().forPath(parentNodePath+"/"+child));
                Date lastHeart = null;
                try {
                    lastHeart = format.parse(childTimeStamp);
                } catch (ParseException e) {
                    logger.error("child data {} not a timestamp ,illegal child drop it",childTimeStamp,e);
                    continue;
                }
                long interval = (now.getTime() - lastHeart.getTime())/(1000);
                logger.info("child {} last heart beat interval is {}",child,interval);
                if(interval > heartBeat){
                    logger.info("child {} maybe disonline ,last heart beat is {}",child,childTimeStamp);
                }
            }
        } catch (Exception e) {
            logger.error("judge children online error",e);
        }


    }
}
