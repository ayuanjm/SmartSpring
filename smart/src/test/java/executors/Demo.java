package executors;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorsDemo executorsDemo = new ExecutorsDemo();
//        executorsDemo.duiBaConfirmNotice("hello world");
//        System.out.println("正常执行代码");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Task task = new Task("yuan");
        FutureTask<String> futureTask = new FutureTask(task);
//        executorService.submit(futureTask);
        Future<String> future =  executorService.submit(task);
        //executorService.shutdown();
        Thread.sleep(1000);
        System.out.println("主线程执行中");
//        System.out.println("task执行结果："+ task.get());
        System.out.println("task执行结果："+ future.get());

        System.out.println("所有任务执行完毕");
    }
}
