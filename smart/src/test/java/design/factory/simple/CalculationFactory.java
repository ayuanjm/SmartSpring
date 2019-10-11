package design.factory.simple;

public class CalculationFactory {
    public static Calculation createCalculation(double numberA, double numberB, String operate) {
        Calculation calculation;
        switch (operate) {
            case "*":
                calculation = new MulCalculation(numberA,numberB);
                break;
            case "/":
                calculation = new DivCalculation(numberA,numberB);
                break;
            default:
                calculation = new Calculation(numberA,numberB);
        }
        return calculation;
    }
}
