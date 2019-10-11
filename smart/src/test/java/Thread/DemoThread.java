package Thread;

public class DemoThread implements Runnable {
    private int ticket = 10;
    @Override
    public void run() {
            for (int i = 0; i < 1; i++) {
                if (this.ticket > 0) {
                    function();
                    //System.out.println("ticket" + Thread.currentThread().getName() + ":" + function());
                }
            }
        }


    public synchronized int function() {
        int tmp = ticket;
        System.out.println("ticket" + Thread.currentThread().getName()+"start");
        try {
            if (Thread.currentThread().getName().equals("Thread-0")){
                Thread.sleep(100);
                System.out.println(Thread.holdsLock(this));
                wait();
            }else {
                notify();
            }
        } catch (Exception e) {

        }
        System.out.println("ticket" + Thread.currentThread().getName()+"end");

        ticket = tmp - 1;
        return ticket;
    }

    public static void main(String[] args) {
        DemoThread demoThread1 = new DemoThread();
        DemoThread demoThread2 = new DemoThread();

        new Thread(demoThread1).start();
        new Thread(demoThread1).start();
    }
}

