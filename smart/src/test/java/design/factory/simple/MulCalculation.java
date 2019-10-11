package design.factory.simple;

public class MulCalculation extends Calculation {
    public MulCalculation(double numberA, double numberB) {
        super(numberA, numberB);
    }

    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }
}
