package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public void duiBaConfirmNotice(String name) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("执行异步通知开始:" + name);
                    Thread.sleep(5000);
                    System.out.println("执行异步通知:结束" + name);
                    executorService.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
