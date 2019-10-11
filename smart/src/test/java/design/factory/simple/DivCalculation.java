package design.factory.simple;

public class DivCalculation extends Calculation {
    public DivCalculation(double numberA, double numberB) {
        super(numberA, numberB);
    }

    @Override
    public double getResult() throws Exception {
        if (getNumberB() == 0) {
            throw new Exception("除数不能为0");
        }
        return getNumberA() / getNumberB();
    }
}
