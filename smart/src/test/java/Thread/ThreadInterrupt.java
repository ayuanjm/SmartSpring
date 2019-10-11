package Thread;

public class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadInterrupt interrupt = new ThreadInterrupt();
        interrupt.start();
        interrupt.interrupt();
        System.out.println(interrupt.isInterrupted());
        System.out.println(interrupt.isAlive());
    }

}
