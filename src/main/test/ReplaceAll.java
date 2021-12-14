package main.test;

import java.io.*;

/***
 *  @author : lirui
 *  @date :  2021/12/14
 *  @description : 批量替换
 *      VALUES (1, 1, NULL, 中的第二个1改成222
 *
 ***/
public class ReplaceAll {

    public static void main(String[] args) throws IOException {
        // 用来查看当前行是否包含目标数据
        String target = "(1,";
        // 用来分割
        String regex = "\\(1,";
        // 要提换成的字符串
        String replacement = "222";
        // 源文件
        File file = new File("src/resource/test.sql");
        // 读取
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        // 目标文件
        FileWriter fileWriter = new FileWriter("src/resource/result.sql");
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        String line;
        // 分割后,第一个逗号的位置
        int comma;
        while ((line = buffer.readLine()) != null) {
            // 如果包含匹配值,分割,拼接
            if (line.contains(target)) {
                String[] temp = line.split(regex);
                comma = temp[1].indexOf(',');
                temp[1] = target + replacement + temp[1].substring(comma);
                fileWriter.write(temp[0] + temp[1]);
            } else {
                // 不包含,直接写入
                fileWriter.write(line);
            }
        }
        // 缓存刷入
        fileWriter.flush();
        // 关闭流
        fileWriter.close();
        buffer.close();
    }
}
