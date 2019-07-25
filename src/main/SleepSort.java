package main;

/**
 * 类的描述: 线程的sleep(long ms)方法进行排序
 *
 * @author : lirui
 * @date : 2019/7/25 10:57
 */
public class SleepSort {
    public static void main(String[] args) {
        int[] ints = {1, 4, 7, 3, 8, 9, 2, 6, 5};
        SortThread[] sortThreads = new SortThread[ints.length];
        // 循环创建n个线程 n=要排序的元素个数
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SortThread(ints[i]);
        }
        // 循环让每个线程运行run方法
        for (SortThread sortThread : sortThreads) {
            sortThread.start();
        }
    }
}

/**
 * 类的描述: 排序线程类
 *
 * @author : lirui
 * @date : 2019/7/25 11:53
 */
class SortThread extends Thread {
    private int ms = 0;

    SortThread(int ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        try {
            sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ms);
    }
}
