package Lock;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static int a = 0;

    public static void increase() {
        atomicInteger.incrementAndGet();
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread[] = new Thread[100];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            };
            thread[i].start();
        }
//        thread[99].join();
//        Thread.currentThread().join();
//        Thread.sleep(10000);
//        System.out.println(atomicInteger.get());
        System.out.println(a);
    }
}
