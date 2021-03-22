package org.hthu.pattern_design.strategy;

/**
 * 测试策略模式
 */
public class StrategyDemo {
    public static void main(String[] args) {
        StrategyFactory strategyFactory = new StrategyFactory(new OperationAdd());
        System.out.println(strategyFactory.execStrategy(12, 23));
    }
}
