package Lock;

public class LockClient{
    Lock lock = new Lock();
//    ReentrantLock lock = new ReentrantLock();
    void read() throws InterruptedException {
        lock.lock();
        System.out.println("read");
        read1();
        lock.unLock();
    }
    void read1() throws InterruptedException {
        lock.lock();
        System.out.println("read1");
        lock.unLock();
    }
    public static void main(String[] args) throws InterruptedException {
        new LockClient().read();
    }

}

