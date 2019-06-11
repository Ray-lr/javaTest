package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String [] args){
        List<String> list = new ArrayList<>(5);
        list.add(String.valueOf(1));
        list.add(String.valueOf(2));
        list.add("");
        list.add(null);
        list.add(String.valueOf(5));
        list = list.stream().filter(s -> s != null && !"".equals(s)).collect(Collectors.toList());
        for (String a : list) {
            System.out.println(a);
        }
    }
}
