package design.factory.method;

import design.factory.simple.Calculation;

public interface CalculationFactory {
    Calculation createCalculation(double numberA, double numberB);
}
