package org.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class producer {
    public void producerMethod(){
        try{
            Properties producerConfig = new Properties();
            producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
            producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

            KafkaProducer<String, byte[]> kafkaProducer = new KafkaProducer<String, byte[]>(producerConfig);

            ProducerRecord<String, byte[]> record = new ProducerRecord<>(key, value);
            kafkaProducer.send(record);
            kafkaProducer.flush();
            kafkaProducer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
