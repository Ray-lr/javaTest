package main.test;

import main.entity.Student;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/***
 *  @author : lirui
 *  @date :  2021/3/16
 *  @description : Set test
 *
 ***/
public class SetTest {

    @Test
    public void duplicate() {
        Set<Student> set = new HashSet<>();
        set.add(new Student(1,"a"));
        set.add(new Student(2,"b"));
        set.add(new Student(1,"a"));
        // result: 都重复才算重复，按hashCode算
        set.forEach(System.out::println);
    }
}
