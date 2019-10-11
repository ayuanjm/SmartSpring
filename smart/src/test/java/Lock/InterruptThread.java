package Lock;

import java.util.Vector;

public class InterruptThread extends Thread {
    @Override
    public void run() {
        Vector vector = new Vector();
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        System.out.println("run方法执行完毕");
    }
}
