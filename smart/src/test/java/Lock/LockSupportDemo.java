package Lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Thread boyThread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("boy: 我要吃鸡");
                LockSupport.park();
                System.out.println("boy: park1");
                LockSupport.park(); // 第二次会阻塞住，因为只有一个permit
                System.out.println("boy: park2");
                System.out.println("boy: 开始吃鸡了");
            }
        });

        Thread girlThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("girl: 允许1");
                LockSupport.unpark(boyThread); // unpark两次，但是permit不会叠加
//                try {
//                    //Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                System.out.println("girl: 允许2");

                LockSupport.unpark(boyThread);
                System.out.println("girl: 允许2");

            }
        });

        boyThread.start();
        girlThread.start();
    }
}
