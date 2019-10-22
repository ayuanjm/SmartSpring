public class Demo {
    public static void main(String[] args) throws Exception{
        System.out.println(Demo.class);
        Demo demo = new Demo();
        System.out.println(demo.getClass().newInstance());
        System.out.println(Class.forName("Demo"));
    }
}
