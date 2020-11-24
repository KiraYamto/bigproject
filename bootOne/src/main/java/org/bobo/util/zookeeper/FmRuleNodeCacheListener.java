package org.bobo.util.zookeeper;

import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: bobo
 * @Date: 2020/11/23 15:58
 */
public class FmRuleNodeCacheListener implements NodeCacheListener {
    private static final Logger logger = LoggerFactory.getLogger(FmRuleNodeCacheListener.class);

    private NodeCache nodeCache;

    public FmRuleNodeCacheListener(NodeCache nodeCache) {
        this.nodeCache = nodeCache;
    }

    @Override
    public void nodeChanged() throws Exception {

        ChildData childData = nodeCache.getCurrentData();
        String data = new String(nodeCache.getCurrentData().getData());
        System.out.println("节点路径为："+nodeCache.getCurrentData().getPath()+" 数据: "+data);
        logger.info("ZNode节点状态改变, path={}", childData.getPath());
        logger.info("ZNode节点状态改变, data={}", childData.getData());
        logger.info("ZNode节点状态改变, stat={}", childData.getStat());

    }
}
