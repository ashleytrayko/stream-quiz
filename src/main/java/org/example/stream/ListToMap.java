package org.example.stream;

import org.example.kafka.Producer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    public Map<Integer,String> ListToMapMethod(List<String> lists){
        Map<Integer, String> maps = new HashMap<>();
        maps = lists.stream().collect(Collectors.toMap(String::length, Function.identity()));
        return maps;
    }
}
