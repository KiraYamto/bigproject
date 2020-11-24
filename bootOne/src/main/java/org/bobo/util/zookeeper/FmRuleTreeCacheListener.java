package org.bobo.util.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: bobo
 * @Date: 2020/11/23 16:05
 */
public class FmRuleTreeCacheListener implements TreeCacheListener {
    private static final Logger logger = LoggerFactory.getLogger(FmRuleTreeCacheListener.class);
    private static int num = 1;

    @Override
    public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
        System.out.println( num++ + ".treeCache------当前发生的变化类型为："
                +  treeCacheEvent.getType() + ",发生变化的节点内容为："
                + treeCacheEvent.getData().getData() + "\n=====================\n");

    }
}
