package org.example;

import org.example.kafka.Consumer;
import org.example.kafka.Producer;
import org.example.stream.ListToMap;
import org.example.stream.SplitMethod;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SplitMethod splitMethod = new SplitMethod();
        ListToMap listToMap = new ListToMap();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Scanner sc = new Scanner(System.in);

        List<String> lists = splitMethod.SplitAlgotithm(sc.nextLine());
        lists.stream().forEach(System.out::println);
        Map<Integer, String> maps = listToMap.ListToMapMethod(lists);
        producer.producerMethod(maps);
        consumer.consumerMethod();

    }
}