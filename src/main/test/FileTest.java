package main.test;

import java.io.File;
import java.io.IOException;

/***
 *@author : Ray
 *@date :  2020/6/28 1:47
 ***/
public class FileTest {

    public static void main(String[] args) throws IOException {

        File file = new File("E:/test");
        String [] s = file.list();
        for (String s1 : s) {
            System.out.println(s1);
        }
        String w = new String(new byte[]{65,97},0,2);
        System.out.println(w);
/*        File file2 = new File("E:/test/异常1.jpg");
        // 错误路径
        File file3 = new File("xxx");
        // 结果是1.txt
        System.out.println(file.createNewFile());
        // 结果是异常1.jpg
        System.out.println(file2.createNewFile());
        // 结果是xxx
        System.out.println(file3.createNewFile());*/
    }
}
