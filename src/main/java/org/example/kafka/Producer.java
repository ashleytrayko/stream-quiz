package org.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Producer {
    public void producerMethod() {
            // 루프 빠져나갈 행동
            try {
                Scanner sc = new Scanner(System.in);
                // 카프카 프로듀서 설정
                Properties producerConfig = new Properties();
                producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
                producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

                // 토픽명
                final String TOPIC = "stream-test";

                // 보낼 데이터
                String data = sc.nextLine();
                byte[] value = data.getBytes(StandardCharsets.UTF_8);

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
