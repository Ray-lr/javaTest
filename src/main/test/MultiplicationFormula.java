package main.test;

/***
 *  @author : lirui
 *  @date :  2021/5/10
 *  @description : 乘法表(动态对齐)
 *
 ***/
public class MultiplicationFormula {
    public static void main(String[] args) {
        printFormula(111);
    }

    public static void printFormula(int x) {
        // 计算最长等式的占位(两个最大乘数+乘积+2) 其中2是*和=
        int max = ("" + x).length() * 2 + ("" + x * x).length() + 2;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                // 双循环输出等式
                String formula = j + "*" + i + "=" + i * j + " ";
                System.out.print(formula);
                // 补齐空格,使所有等式长度都为最大值
                for (int space = formula.length(); space < max; space++) {
                    System.out.print(" ");
                }
            }
            // 单层循环结束,换行
            System.out.println();
        }
    }
}
