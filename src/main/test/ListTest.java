package main.test;

import main.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * @author : lirui
     * @date :  2021/3/22
     * @description : 找出重复名字的对象，输出对应的number (412ms)
     **/
    @Test
    public void findDuplicateTest() {
        // 数据list
        List<Student> list = getStudents();
        // 结果list
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getName().equals(list.get(j).getName())) {
                    result.add(list.get(j).getNum());
                }
            }
        }
        //循环输出
        result.forEach(System.out::println);
    }

    /**
     * @author : lirui
     * @date :  2021/3/22
     * @description : 相较于循环嵌套，map.contains() 效率更好(62ms)
     **/
    @Test
    public void findDuplicateTest2() {
        List<Student> list = getStudents();
        Map<String,Double> map = new HashMap<>();
        for (Student student : list) {
            if (map.containsKey(student.getName())) {
                System.out.println(student.getNum());
            } else {
                map.put(student.getName(),student.getNum());
            }
        }
    }

    private List<Student> getStudents() {
        // 数据list
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Student(i, "" + i, i + 1));
        }
        list.add(new Student(1, "aa", 2));
        list.add(new Student(2, "bb", 4));
        list.add(new Student(3, "vv", 6));
        list.add(new Student(4, "bb", 8));
        list.add(new Student(5, "aa", 0));
        return list;
    }


}
