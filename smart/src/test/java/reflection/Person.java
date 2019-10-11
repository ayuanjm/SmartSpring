package reflection;

public class Person {
    String name;
    private int age;
    static {
        System.out.println("静态代码块");
    }
    public Person(){
        System.out.println("无参构造器");
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        privateMethod();
        age++;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private void privateMethod(){
        System.out.println("这是一个私有的方法！");
    }

    public void setName(String name,int age){
        System.out.println("getName is:"+name);
        System.out.println("getAge is:"+age);
    }

    public Integer show(Integer a){
        System.out.println(a);
        return a;
    }

    public static void sycsynchronizedTest(){
        System.out.println("synchronized");
    }
}