package design.factory.method;

import design.factory.simple.Calculation;

public class Demo {
    public static void main(String[] args) throws Exception {
        methodFactory();
    }

    /**
     * 工厂方法模式
     * 工厂方法模式，在原有的基础上扩展，不修改原来的代码，符合"开放-封闭"原则，但是要修改客户端代码。
     *
     * @throws Exception
     */
    private static void methodFactory() throws Exception {
        CalculationFactory calculationFactory = new MulCalculationFactory();
        Calculation calculation = calculationFactory.createCalculation(1, 2);
        Object o = calculation.getResult();
        System.out.println(o);
    }
}


