package main.test.question;

import org.junit.Test;

/***
 *@author : Ray
 *@date :  2021/1/26 17:41
 *description: 3 bottles change 1 drink
 ***/
public class DrinkTest {

    private int calculate(int bottles) {
        int sum = 0;
        while (bottles >= 3) {
            int drink = bottles / 3;
            sum += drink;
            bottles = drink + bottles % 3;
        }
        if (bottles == 2) {
            sum += 1;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(this.calculate(100));
    }
}
