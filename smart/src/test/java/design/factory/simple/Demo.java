package design.factory.simple;

public class Demo {
    public static void main(String[] args) throws Exception {
        simpleFactory();
    }


    /**
     * 简单工厂模式
     * 简单工厂模式的优点在于工厂中包含了必要的逻辑判断，根据客户端的选择条件动态的实例化相关的类，
     * 对于客户端来说去除了与具体的产品的依赖。但是违背了"开放-封闭"原则
     * @throws Exception
     */
    private static void simpleFactory() throws Exception {
        Calculation calculation = CalculationFactory.createCalculation(1, 2, "/");
        Object o = calculation.getResult();
        System.out.println(o);
    }
}
