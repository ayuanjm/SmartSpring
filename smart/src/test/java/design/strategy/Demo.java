package design.strategy;

public class Demo {
    public static void main(String[] args) throws Exception {
        StrategyContext strategyContext = new StrategyContext(2, 3, "*");
        Object o = strategyContext.getResult();
        System.out.println(o);
    }
}
