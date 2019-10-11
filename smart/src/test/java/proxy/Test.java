package proxy;

public class Test {
    public static void main(String[] args) {
        B b = new B("a");
        A a = b;
        a.show();
        System.out.println(a.getA());
        System.out.println(a.yuan);

    }
}
