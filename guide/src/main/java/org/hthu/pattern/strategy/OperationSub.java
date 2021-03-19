package org.hthu.pattern.strategy;

/**
 * 策略算法2
 */
public class OperationSub implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
