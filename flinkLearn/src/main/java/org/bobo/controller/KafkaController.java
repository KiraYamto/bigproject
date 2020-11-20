package org.bobo.controller;

import org.apache.kafka.clients.producer.*;
import org.bobo.function.flatmap.MemoryUsageExtrator;
import org.bobo.model.KafkaProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@RestController
@RequestMapping("/flink")
public class KafkaController{

    @RequestMapping(value = {"/send"}, method = RequestMethod.POST)
    public String syncSendMessage(@ApiIgnore @RequestBody String message, HttpServletRequest request, HttpServletResponse response){
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaProperties.getServers());
        props.put("acks", KafkaProperties.getAck());
        props.put("retries", KafkaProperties.getRetries());
        props.put("batch.size", KafkaProperties.getBatchSize());
        props.put("linger.ms", KafkaProperties.getLinger());
        props.put("buffer.memory", KafkaProperties.getBufferMemory());
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        int totalMessageCount = 10000;
        for (int i = 0; i < totalMessageCount; i++) {
            String value = String.format("%d,%s,%d", System.currentTimeMillis(), "machine-1", currentMemSize());
            producer.send(new ProducerRecord<>("test", value), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception != null) {
                        System.out.println("Failed to send message with exception " + exception);
                    }
                }
            });
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.close();


        return "ok";
    }

    private static long currentMemSize() {
        return MemoryUsageExtrator.currentFreeMemorySizeInBytes();
    }
}
