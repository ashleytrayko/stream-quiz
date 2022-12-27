package org.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class consumer {
    public void consumerMethod(){
        KafkaConsumer<String, byte[]> kafkaConsumer = null;
        try{
            Properties consumerConfig = new Properties();
            consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
            consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "stream");

            kafkaConsumer = new KafkaConsumer<String, byte[]>(consumerConfig);
            kafkaConsumer.subscribe(Arrays.asList("stream-test"));

            final int batchSize = 1024;
            // 버퍼 설정은 다시하기 -> Byte로?
            // StringBuilder stringBuilder = new StringBuilder();

            ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(Duration.ofSeconds(1));
            byte[] loadedByte = null;

            for(ConsumerRecord<String, byte[]> record : records){
                loadedByte = new byte[record.value().length];
                loadedByte = record.value();
            }


            kafkaConsumer.commitSync();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            kafkaConsumer.commitSync();
            kafkaConsumer.close();
        }
    }
}
