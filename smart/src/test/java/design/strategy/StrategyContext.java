package design.strategy;

import design.factory.simple.Calculation;
import design.factory.simple.DivCalculation;
import design.factory.simple.MulCalculation;

public class StrategyContext {
    private Calculation calculation;

    public StrategyContext(Calculation calculation) {
        this.calculation = calculation;
    }

    public StrategyContext(double numberA, double numberB, String operate) {
        switch (operate) {
            case "*":
                calculation = new MulCalculation(numberA, numberB);
                break;
            case "/":
                calculation = new DivCalculation(numberA, numberB);
                break;
            default:
                calculation = new Calculation(numberA, numberB);
        }
    }

    public double getResult() throws Exception {
        return calculation.getResult();
    }
}
