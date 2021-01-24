package main.test.thread;

/***
 *@author : Ray
 *@date :  2021/1/14 18:11
 *description: thread test
 ***/
public class MyThread implements Runnable {
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + ",run: " + i);
        }
    }
}
