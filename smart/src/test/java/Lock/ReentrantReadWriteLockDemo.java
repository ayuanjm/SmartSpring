package Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo re = new ReentrantReadWriteLockDemo();
        set(re);
        set(re);
        get(re);
        get(re);
    }

    private static void get(ReentrantReadWriteLockDemo re) {
        new Thread() {
            @Override
            public void run() {
                re.get(Thread.currentThread());
            }
        }.start();
    }

    private static void set(ReentrantReadWriteLockDemo re) {
        new Thread() {
            @Override
            public void run() {
                re.set(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread) {
        rw.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "正在读操作结束");
        } finally {
            rw.readLock().unlock();
        }
    }

    public void set(Thread thread) {
        rw.writeLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 0.5) {
                System.out.println(thread.getName() + "正在进行写操作");
            }
            System.out.println(thread.getName() + "正在写操作结束");
        } finally {
            rw.writeLock().unlock();
        }
    }

}
