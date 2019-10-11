package Lock;

import java.util.concurrent.locks.ReentrantLock;

//不可重入锁
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
    }
    public synchronized void unLock(){
        isLocked = false;
    }
}
