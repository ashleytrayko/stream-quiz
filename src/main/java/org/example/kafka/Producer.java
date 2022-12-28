package org.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Properties;

public class Producer {
    public void producerMethod(Map<Integer, String> maps) {
            // 루프 빠져나갈 행동
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try(ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                // 카프카 프로듀서 설정
                Properties producerConfig = new Properties();
                producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
                producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

                // 토픽명
                final String TOPIC = "stream-test";

                // 보낼 데이터

                oos.writeObject(maps);
                byte[] value = baos.toByteArray();
                System.out.println(value);

                // 암호화
                //byte[] encoded = Base64.getEncoder().encode(value);

                // 설정한 내용으로 카프카 프로듀서 객체 생성
                KafkaProducer<String, byte[]> kafkaProducer = new KafkaProducer<String, byte[]>(producerConfig);
                
                // 프로듀서 레코드 객체 생성
                ProducerRecord<String, byte[]> record = new ProducerRecord<>(TOPIC, value);
                
                // 레코드 전송
                kafkaProducer.send(record);
                kafkaProducer.flush();
                kafkaProducer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
