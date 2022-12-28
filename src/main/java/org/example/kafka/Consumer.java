package org.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class Consumer {
    public void consumerMethod(){
        byte[] loadedByte = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(loadedByte);
        try(ObjectInputStream ois = new ObjectInputStream(bais)){
            // 카프카 컨슈머 설정
            Properties consumerConfig = new Properties();
            consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
            consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "stream");

            // 카프카 컨슈머 객체 생성
            KafkaConsumer<String, byte[]> kafkaConsumer = new KafkaConsumer<String, byte[]>(consumerConfig);

            // 토픽 구독
            kafkaConsumer.subscribe(Arrays.asList("stream-test"));


            final int batchSize = 1024;
            // 버퍼 설정은 다시하기 -> Byte로?
            // StringBuilder stringBuilder = new StringBuilder();

            // 토픽에서 1초 간격으로 데이터를 받아 컨슈머 레코드에 저장
            ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(Duration.ofSeconds(1));


            // 카프카 데이터 바이트 배열로 받기
            for(ConsumerRecord<String, byte[]> record : records){
                loadedByte = new byte[record.value().length];
                loadedByte = record.value();
            }

            Map<Integer, String> maps = (Map<Integer, String>)ois.readObject();
            System.out.println(maps);


            // 복호화?

            // 커밋
            kafkaConsumer.commitSync();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
