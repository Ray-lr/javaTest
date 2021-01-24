package main.test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/***
 *@author : Ray
 *@date :  2021/1/24 20:41
 *description: write my own sort
 ***/
public class MySortTest {

    /**
     * @param array: int array to be sorted
     * @param low:   first index
     * @param high:  last index
     * @return :  sorted array
     * description: quick sort
     * @author : Ray
     * @date : 2021/1/24 20:45
     **/
    private int[] quickSort(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int key = array[low];
        if (low < high) {
            while (i < j) {
                while (i < j && key <= array[j]) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && key >= array[i]) {
                    i++;
                }
                array[j] = array[i];
                array[i] = key;
            }
            quickSort(array, low, i - 1);
            quickSort(array, i + 1, high);
        }
        return array;
    }

    @Test
    public void quickSortTest() {
        Random random = new Random();
        int[] test = new int[100];
        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(this.quickSort(test, 0, test.length - 1)));
    }
}
