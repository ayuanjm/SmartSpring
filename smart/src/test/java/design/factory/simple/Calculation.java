package design.factory.simple;

public class Calculation {
    private double numberA;
    private double numberB;
    private double result;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getResult() throws Exception {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Calculation(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public Calculation() {
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "numberA=" + numberA +
                ", numberB=" + numberB +
                ", result=" + result +
                '}';
    }
}
