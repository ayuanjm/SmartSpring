package reflection;

public class TestYuan {
    public static int a = 5;

    static {
        System.out.println("静态代码块：" + Thread.currentThread().getName());
    }

//    public TestYuan() {
//        System.out.println("构造方法");
//    }

    public synchronized static void info() {
        System.out.println(Thread.currentThread().getName() + "休眠开始");

        try {
            if (Thread.currentThread().getName().equals("Thread-0"))
            Thread.sleep(1000);
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getName() + ",a:" + (a-=1));
    }

}