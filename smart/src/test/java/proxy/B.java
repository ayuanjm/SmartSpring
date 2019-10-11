package proxy;

public class B extends A{
    private String b = "b";
    public int yuan = 1;
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public B(String a) {
        super(a);
    }

    @Override
    public void show() {
        System.out.println(b);
    }
}
