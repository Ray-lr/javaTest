package main;

import java.math.BigDecimal;

/**
 * 类的描述: BigDecimal相关计算的测试
 *
 * @author : lirui
 * @date : 2019/6/19 15:29
 */
public class BigDecimalTest {
    /**
     * 功能描述: 测试加上一个double的负数
     *
     * @author : lirui
     * @date : 2019/6/19 15:35
     */
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("-12.1");
        BigDecimal result = a.add(b);
        System.out.println(result);
    }
}
