package org.example;

import org.example.kafka.Consumer;
import org.example.kafka.Producer;
import org.example.stream.Column;
import org.example.stream.MakeColumnList;
import org.example.stream.ListToMap;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Producer kafkaProducer = new Producer();
        Consumer kafkaConsumer = new Consumer();
        ListToMap listToMap = new ListToMap();
        MakeColumnList makeColumnList = new MakeColumnList();

        // Column클래스에 맞춰 columnList 생성
        List<Column> columnList = makeColumnList.MakeColumnList();

        // Producer메서드로 데이터 전송
        kafkaProducer.producerMethod();

        // 컨슈머로 받은 데이터를 splitMethod를 통해 파싱하여 리스트에 저장
        List<String> lists = kafkaConsumer.consumerMethod();

        System.out.println("ColumnList : "+columnList);
        System.out.println("Kafka로 전송되어 파싱된 데이터 : " + lists);

        // 맵으로 저장
        listToMap.ListToMapMethod(columnList, lists);


    }
}