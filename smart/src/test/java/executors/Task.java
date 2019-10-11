package executors;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("异步通知开始");
        Thread.sleep(5000);
        duiBaConfirmNotice(name);
        System.out.println("异步通知结束");
        return name;
    }

    public void duiBaConfirmNotice(String name) {
        System.out.println("执行任务：" + name   );
    }

}
