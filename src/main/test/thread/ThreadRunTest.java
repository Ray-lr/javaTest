package main.test.thread;

/***
 *@author : Ray
 *@date :  2021/1/14 18:14
 *description: thread run test
 ***/
public class ThreadRunTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("thread1");
        MyThread myThread2 = new MyThread("thread2");
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
    }
}
