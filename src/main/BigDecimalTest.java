package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        /*BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("-12.1");
        BigDecimal result = a.add(b);
        System.out.println(result);*/
        scale();
    }

    /**
     * 功能描述: 计算结果,在进行保留位数和四舍五入
     *
     * @author : lirui
     * @date : 2019/7/30 14:11
     */
    private static void scale() {
        BigDecimal waterRatio = new BigDecimal(13.125);
        BigDecimal storageWeight = new BigDecimal(100);
        BigDecimal weightWithoutWater;
        weightWithoutWater = storageWeight
                .subtract(waterRatio);
        weightWithoutWater = weightWithoutWater.setScale(2, RoundingMode.HALF_UP);
        System.out.println(weightWithoutWater);
    }
}
