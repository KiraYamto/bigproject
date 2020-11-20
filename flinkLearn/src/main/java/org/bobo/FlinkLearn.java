package org.bobo;


import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple;
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
import org.bobo.model.KafkaProperties;
import org.bobo.watermark.MessageWaterEmitter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Properties;

@SpringBootApplication(scanBasePackages = "org.bobo")
@EnableDiscoveryClient
@MapperScan("org.bobo.mybatis.mapper")
public class FlinkLearn {
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

    @Value("${spring.kafka.producer.retries}")
    private static int retries;
    @Value("${spring.kafka.producer.batch-size}")
    private static int batchSize;
    @Value("${spring.kafka.producer.linger}")
    private static int linger;
    @Value("${spring.kafka.producer.buffer-memory}")
    private static int bufferMemory;
    @Value("${spring.kafka.producer.acks}")
    private static String ack;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;
    @Value("${spring.kafka.template.input-topic}")
    private String inputTopic;
    @Value("${spring.kafka.template.output-topic}")
    private String outputTopic;
    @Value("${spring.kafka.template.flink-input}")
    private String flinkIn;
    @Value("${spring.kafka.template.flink-output}")
    private String flinkOut;
    public static void main(String[] args) {
        System.out.println("------FlinkLearn Start----------");
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000); // 非常关键，一定要设置启动检查点！！
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "172.16.22.55:9093");
        props.setProperty("group.id", "flinktest");

        FlinkKafkaConsumer010<String> consumer =
                new FlinkKafkaConsumer010<>("flink_test", new SimpleStringSchema(), props);
        consumer.assignTimestampsAndWatermarks(new MessageWaterEmitter());
        env.addSource(consumer).flatMap(new OrdersFlatFunc());

/*        DataStream<Tuple2<String, Long>> keyedStream = env
                .addSource(consumer)
                .flatMap(new MessageSplitter())
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
                });
        keyedStream.print();*/
        //keyedStream.writeAsText("./result.txt");
        System.out.println("------FlinkLearn process----------");

        try {
            env.execute("Flink-Kafka Demo");
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("------FlinkLearn Finish----------");
    }
}
