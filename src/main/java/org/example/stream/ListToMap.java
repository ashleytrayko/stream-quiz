package org.example.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class ListToMap {
    public void ListToMapMethod(List<Column> columnList, List<String> list){

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        // lists의 길이 만큼 반복하여 맵에 저장

        for(String item : list){
            map.put(String.valueOf(columnList.stream().filter(x -> x.getOrder() == list.indexOf(item)+1).findAny().get().getColumnName()),item);
        }

        // sort로도 해보기

        System.out.println("최종 : " + map);
    }
}
