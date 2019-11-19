package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * https://segmentfault.com/a/1190000018596177
 * https://blog.csdn.net/weixin_38810239/article/details/79941964
 */
public class Demo2 {
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal();

    public static <ExecutorService> void main(String[] args) {
        parse();
//        format();
//        test();
    }

    static void test(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = "2019-10-10";
        try {
            simpleDateFormat.parse(s);
            simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void format() {
        java.util.concurrent.ExecutorService executorService = new ThreadPoolExecutor(100, 100,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        List<Date> dateStrList = asList(
                new Date(), new Date(), new Date(), new Date(), new Date()
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (Date str : dateStrList) {
            executorService.execute(() -> {
                try {
//                    SimpleDateFormat simpleDateFormat = threadLocal.get();
//                    if (simpleDateFormat==null){
//                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                        threadLocal.set(simpleDateFormat);
//                    }
                    //创建新的SimpleDateFormat对象用于日期-时间的计算
                    System.out.println(simpleDateFormat.format(str));
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void parse() {
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
                    //创建新的SimpleDateFormat对象用于日期-时间的计算
//                    SimpleDateFormat simpleDateFormat = threadLocal.get();
//                    if (simpleDateFormat==null){
//                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                        threadLocal.set(simpleDateFormat);
//                    }
                    System.out.println(simpleDateFormat.parse(str));
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
