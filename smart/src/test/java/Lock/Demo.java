package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.tryLock();
    }
}
