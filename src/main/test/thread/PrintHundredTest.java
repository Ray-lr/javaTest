package main.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *@author : Ray
 *@date :  2021/1/26 1:51
 *description: print 1-99 by 3 threads
 ***/
public class PrintHundredTest {

    public static void main(String[] args) {
        Resource resource = new Resource();
        List<Runnable> runnableList = new ArrayList<>(3);
        runnableList.add(() -> resource.print(resource.first, resource.second));
        runnableList.add(() -> resource.print(resource.second, resource.third));
        runnableList.add(() -> resource.print(resource.third, resource.first));
        for (int i = 0; i < runnableList.size(); i++) {
            new Thread(runnableList.get(i), i + 1 + "").start();
        }
    }

    static class Resource {
        int num = 0;
        Lock lock = new ReentrantLock();
        Condition first = lock.newCondition();
        Condition second = lock.newCondition();
        Condition third = lock.newCondition();

        void print(Condition current, Condition next) {
            lock.lock();
            try {
                while (num < 99) {
                    num += 1;
                    System.out.println("t" + Thread.currentThread().getName() + ":" + num);
                    next.signal();
                    current.await();
                }
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
