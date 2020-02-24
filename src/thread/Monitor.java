package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition first = lock.newCondition();
    private static Condition second = lock.newCondition();
    private static Condition third = lock.newCondition();

    private static int count = 0;

    public void printA() {
        lock.lock();
        try {
            while (count % 3 != 0) {
                first.await();
            }
            System.out.print("A");
            count++;
            second.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (count % 3 != 1) {
                second.await();
            }
            System.out.print("B");
            count++;
            third.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (count % 3 != 2) {
                third.await();
            }
            System.out.print("C");
            count++;
            first.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    monitor.printA();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    monitor.printB();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    monitor.printC();
                }
            }
        }).start();
    }

}
