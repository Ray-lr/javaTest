package main.test;

import main.entity.Student;

/**
 * 类的描述: double数据特性测试
 *
 * @author : lirui
 * @date : 2019/9/30 9:35
 */
public class DoubleTest {
    /**
     * double 默认为0.0,但是判断为0也成立
     */
    public static void main(String[] args) {
        Student s = new Student();
        if (s.getNum() == 0) {
            System.out.print(s.getNum());
        }
    }
}
