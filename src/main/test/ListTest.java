package main.test;

import main.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的描述: 列表测试
 *
 * @author : lirui
 * @date : 2019/7/16 15:35
 */
public class ListTest {

    /**
     * 功能描述: 测试结果为,同一个对象第二次放入list时,会覆盖第一次的值
     *
     * @param args:
     * @author : lirui
     * @date : 2019/7/16 15:45
     */
    public static void main(String[] args) {
        Student student = new Student(1, "wo");
        List<Student> list = new ArrayList<>(2);
        list.add(student);
        System.out.println(list.get(0).toString());
        student.setId(2);
        student.setName("ni");
        list.add(student);
        for (Student s : list) {
            System.out.println(s.toString());
        }
    }
}
