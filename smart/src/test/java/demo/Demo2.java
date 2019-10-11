package demo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public class Demo2 {
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal();

    public static <ExecutorService> void main(String[] args) {
        java.util.concurrent.ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> dateStrList = asList(
                "2018-04-01 10:00:01",
                "2018-04-02 11:00:02",
                "2018-04-03 12:00:03",
                "2018-04-04 13:00:04",
                "2018-04-05 14:00:05"
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (String str : dateStrList) {
            executorService.execute(() -> {
                try {
//                    SimpleDateFormat simpleDateFormat = threadLocal.get();
//                    if (simpleDateFormat==null){
//                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                        threadLocal.set(simpleDateFormat);
//                    }
                    //创建新的SimpleDateFormat对象用于日期-时间的计算
                    System.out.println(simpleDateFormat.parse(str));
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
