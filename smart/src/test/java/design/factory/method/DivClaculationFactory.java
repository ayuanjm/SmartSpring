package design.factory.method;

import design.factory.simple.Calculation;
import design.factory.simple.DivCalculation;

public class DivClaculationFactory implements CalculationFactory {
    @Override
    public Calculation createCalculation(double numberA, double numberB) {
        return new DivCalculation(numberA, numberB);
    }
}
