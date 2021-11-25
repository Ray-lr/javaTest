package main.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *  @author : lirui
 *  @date :  2021/3/8
 *  @description : Map test
 *
 ***/
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        System.out.println(getValues(map));
    }

    /**
     *  @author : lirui
     *  @date :  2021/3/8
     *  @param map: param
     *  @return : value list
     *  @description : check if changes will effect the map not only the param
     *
     **/
    private static List<Integer> getValues(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>(map.size());
        map.put(4, 1);
        map.put(5, 5);
        map.forEach((k, v) -> {
            if (k % 2 == 1) {
                list.add(v);
            }
        });
        return list;
    }

    /**
     * @param map: 需要翻转的map
     * @return : 结果map
     * @author : lirui
     * @date :  2021/9/30
     * @description : 翻转map的key和value
     **/
    private static Map<String, String> reverse(Map<String, String> map) {
        Map<String, String> result = new HashMap<>(map.size());
        map.forEach((key, value) -> result.put(value, key));
        return result;
    }
}
