package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.kafka.Consumer;
import org.example.kafka.Producer;
import org.example.stream.Column;
import org.example.stream.SplitMethod;
import org.example.stream.SplitMethodTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producer kafkaProducer = new Producer();
        Consumer kafkaConsumer = new Consumer();
        kafkaProducer.producerMethod();
        List<String> lists = kafkaConsumer.consumerMethod();
//        lists.stream().forEach(System.out::println);
//        File csvFile = new File("C:\\Users\\User\\Desktop\\CSVconfig.csv");
//        Scanner sc = new Scanner(System.in);
//        String line = "";
//
//        try {
//            List<Column> columns = new CsvToBeanBuilder(new FileReader(csvFile))
//                    .withSeparator(';')
//                    .withType(Column.class)
//                    .build()
//                    .parse();
//            columns.forEach(System.out::println);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}