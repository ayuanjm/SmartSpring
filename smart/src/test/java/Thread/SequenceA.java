package Thread;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SequenceA implements Sequence {
    //    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//        @Override
//        protected Integer initialValue() {
//            return 0;
//        }
//    };
    public int i = 0;

    @Override
    public int getNumber() {
//        threadLocal.set(threadLocal.get() + 1);
////        return threadLocal.get();
        return function();
    }

    public int function() {
        int tmp = i;
        try {
            if (Thread.currentThread().getName().equals("Thread-1")) {
                Thread.sleep(100);
            }
        } catch (Exception e) {

        }
        i = tmp + 1;
        return tmp;
    }


    public static void main(String[] args) {
//        SequenceA sequenceA = new SequenceA();
//        ClientThread clientThread1 = new ClientThread(sequenceA);
//        ClientThread clientThread2 = new ClientThread(sequenceA);
//        ClientThread clientThread3 = new ClientThread(sequenceA);
//        clientThread1.start();
//        clientThread2.start();
//        clientThread3.start();
        DemoThread demoThread = new DemoThread();
        new Thread(demoThread).start();
        new Thread(demoThread).start();
        new Thread(demoThread).start();

    }
}
