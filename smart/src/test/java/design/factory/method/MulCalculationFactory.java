package design.factory.method;

import design.factory.simple.Calculation;

public class MulCalculationFactory implements CalculationFactory{
    @Override
    public Calculation createCalculation(double numberA,double numberB) {
        return new design.factory.simple.MulCalculation(numberA,numberB);
    }
}
