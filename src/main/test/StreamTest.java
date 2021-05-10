package main.test;

import main.entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/***
 *  @author : lirui
 *  @date :  2021/5/10
 *  @description : stream相关测试
 *
 ***/

public class StreamTest {
    public static void main(String[] args) {
        filter();
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
            // 1,2,5
            System.out.println(a);
        }
    }

    @Test
    public void groupSum() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "wo", 2);
        Student student2 = new Student(2, "wo", 3);
        Student student3 = new Student(1, "wo", 3);
        Student student4 = new Student(2, "wo", 3);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Map<Integer, List<Student>> result =
                students.stream().collect(Collectors.groupingBy(Student::getId, Collectors.toList()));
        result.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    @Test
    public void sortDistinct() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "wo", 12));
        students.add(new Student(3, "ni", 4));
        students.add(new Student(2, "wo", 3));
        students.add(new Student(4, "ni", 5));
        students = students.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(Student::getName))), ArrayList::new));
        students.forEach(System.out::println);
    }

    @Test
    public void filterByPredicate() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "wo", 10));
        list.add(new Student(2, "ni", 20));
        list.add(new Student(3, "wo", 30));
        list.add(new Student(4, "ni", 40));
        list.add(new Student(5, "ni1", 50));
        List<String> nameCondition = new ArrayList<>();
        nameCondition.add("n");
        nameCondition.add("1");

        Predicate<Student> predicate = student -> true;
        predicate = predicate.and(student -> {
            boolean flag = false;
            for (String s : nameCondition) {
                if (student.getName().contains(s)) {
                    flag = true;
                    break;
                }
            }
            return flag;
        });
        predicate = predicate.and(student -> student.getNum() > 20);
        list.stream().filter(predicate).forEach(System.out::println);
    }

    @Test
    public void distinctTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list = list.stream().distinct().collect(Collectors.toList());
        // 1,2,3
        System.out.println(list);
    }
}
