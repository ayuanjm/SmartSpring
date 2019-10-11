package Thread;

public class JDKThread extends Thread {
    private int ticket = 6;
    private static int a = 10;

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            //System.out.println(Thread.currentThread().getName() + " =>" + function());
            function();
        }
    }

    public synchronized int function() {
        System.out.println(Thread.currentThread().getName());
        int tmp = a;
        try {
            if (Thread.currentThread().getName().equals("Thread-0")) {
                Thread.sleep(100);
            }
        } catch (Exception e) {

        }
        a = tmp - 1;
        System.out.println(Thread.currentThread().getName() + " =>" + a);

        return a;
    }

    public static void main(String[] args) {
        JDKThread jdkThread1 = new JDKThread();
        JDKThread jdkThread2 = new JDKThread();
        JDKThread jdkThread3 = new JDKThread();
        jdkThread1.start();
        jdkThread2.start();
        jdkThread3.start();
    }
}
