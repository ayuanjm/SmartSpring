package demo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public class Demo3 {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        java.util.concurrent.ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        List<String> dateStrList = asList(
                "2018-04-01 10:00:01",
                "2018-04-02 11:00:02",
                "2018-04-03 12:00:03",
                "2018-04-04 13:00:04",
                "2018-04-05 14:00:05"
        );
        for (String date : dateStrList) {
            executorService.execute(() -> {
                try {
//                    SimpleDateFormat simpleDateFormat = threadLocal.get();
//                    if (simpleDateFormat==null){
//                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                        threadLocal.set(simpleDateFormat);
//                    }
                    //创建新的SimpleDateFormat对象用于日期-时间的计算
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(dateTimeFormatter.parse(date));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
    }
}
