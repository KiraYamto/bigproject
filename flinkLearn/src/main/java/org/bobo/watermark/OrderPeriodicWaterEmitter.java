package org.bobo.watermark;

import com.alibaba.fastjson.JSON;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.bobo.model.tencent.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * @Author: bobo
 * @Date: 2020/11/19 15:36
 */
public class OrderPeriodicWaterEmitter implements AssignerWithPeriodicWatermarks<Order> {
    private static final Logger logger  = LoggerFactory.getLogger(OrderPeriodicWaterEmitter.class);

    long maxOutOfOrderNess = 10000L;//10秒
    long currentMaxTimestamp = 0L;
    Watermark watermark = null;
    Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        watermark = new Watermark(currentMaxTimestamp-maxOutOfOrderNess);
        return watermark;
    }

    @Override
    public long extractTimestamp(Order order, long l) {
       long createTime = Long.parseLong(order.getCreateTime());
       currentMaxTimestamp = Math.max(createTime,currentMaxTimestamp);
       String orderInfo = JSON.toJSONString(order);
       String waterMarkStr = watermark == null?null:JSON.toJSONString(watermark);
        logger.debug("timestamp:" + orderInfo +","+ createTime + "|" +format.format(createTime) +","+  currentMaxTimestamp + "|"+ format.format(currentMaxTimestamp) + ","+waterMarkStr);
       return createTime;
    }
}
