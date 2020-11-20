package org.bobo.Job;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple12;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.util.Collector;
import org.bobo.function.flatmap.MessageSplitter;
import org.bobo.function.flatmap.OrdersFlatFunc;
import org.bobo.model.tencent.order.GoodsInfo;
import org.bobo.model.tencent.order.PromotionInfo;
import org.bobo.model.tencent.order.UserInfo;
import org.bobo.watermark.MessageWaterEmitter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Properties;

public class TencentDataJob {
    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private static String servers;
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private static boolean enableAutoCommit;
    @Value("${spring.kafka.consumer.session-time-out}")
    private static String sessionTimeout;
    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private static String autoCommitInterval;
    @Value("${spring.kafka.consumer.group-id}")
    private static String groupId;
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private static String autoOffsetReset;
    @Value("${spring.kafka.consumer.concurrency}")
    private static int concurrency;

    @Value("${spring.kafka.template.flink-input}")
    private String flinkIn;


    void execute(){
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.enableCheckpointing(5000); // 非常关键，一定要设置启动检查点！！
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", servers);
        props.setProperty("group.id", groupId);

        FlinkKafkaConsumer010<String> consumer =
                new FlinkKafkaConsumer010<>(flinkIn, new SimpleStringSchema(), props);
        consumer.assignTimestampsAndWatermarks(new MessageWaterEmitter());
        env.addSource(consumer).flatMap(new OrdersFlatFunc()).print();
    /*    DataStream<Tuple12<String, String,Integer,String,Integer, Float, Float, Float, Float, UserInfo, List<PromotionInfo>, List<GoodsInfo>>> keyedStream = env
                .addSource(consumer)
                .flatMap(new ME)
                .keyBy(0)
                .timeWindow(Time.seconds(10))
                .apply(new WindowFunction<Tuple2<String, Long>, Tuple2<String, Long>, Tuple, TimeWindow>() {
                    @Override
                    public void apply(Tuple tuple, TimeWindow window, Iterable<Tuple2<String, Long>> input, Collector<Tuple2<String, Long>> out) throws Exception {
                        long sum = 0L;
                        int count = 0;
                        for (Tuple2<String, Long> record: input) {
                            sum += record.f1;
                            count++;
                        }
                        Tuple2<String, Long> result = input.iterator().next();
                        result.f1 = sum / count;
                        out.collect(result);
                    }
                });*/

    }
}
