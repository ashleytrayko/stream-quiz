package org.example.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    public void ListToMapMethod(List<Column> columnList, List<String> lists){
//        Map<String, Integer> map = columnList.stream()
//                .collect(Collectors.toMap(
//                Column::getColumnName,
//                Column::getOrder,
//                        (left, right) -> left,
//                        LinkedHashMap::new));
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for(String list : lists){
            map.put(String.valueOf(columnList.stream().filter(x -> x.getOrder() == lists.indexOf(list)+1).findAny().get().getColumnName()),list);
        }
        System.out.println("최종 : " + map);
    }
}
