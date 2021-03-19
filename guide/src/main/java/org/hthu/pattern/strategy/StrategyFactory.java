package org.hthu.pattern.strategy;

/**
 * 策略工厂
 */
public class StrategyFactory {
    private Strategy strategy;

    public StrategyFactory(Strategy strategy){
        this.strategy = strategy;
    }

    public int execStrategy(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }
}
