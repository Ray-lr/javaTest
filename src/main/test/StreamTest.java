package main.test;

import main.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



/**
 * @author lirui
 */

public class StreamTest {
    public static void main(String [] args){
//        filter();
//        groupSum();
    }

    private static void filter() {
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

    @Test
    public void groupSum() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "wo", 2);
        Student student2 = new Student(2, "wo",3);
        Student student3 = new Student(1, "wo",3);
        Student student4 = new Student(2, "wo",3);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Map<Integer, List<Student>> result = students.stream().collect(Collectors.groupingBy(Student::getId,Collectors.toList()));
        result.forEach((key,value)-> System.out.println(key+":"+ value));
    }
}
