package Lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    //默认为不公平锁，true为公平锁,以 reentrantLock 作为共享变量
    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    public int a = 0;

    public void run() {
        try {
            test();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread()+"中断");
        }
    }

    private void test() throws InterruptedException {
        while (true) {
            reentrantLock.lockInterruptibly();
            //reentrantLock.lock();
            try {
                a++;
                System.out.println(Thread.currentThread().getName() + "，获得锁!" + a);
            } catch (Exception e) {
            } finally {
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + "，释放锁!" + a);
                if (a>10){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "线程1");
        Thread t2 = new Thread(fairLock, "线程2");
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
