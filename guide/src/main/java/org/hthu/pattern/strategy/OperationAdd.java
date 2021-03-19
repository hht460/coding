package org.hthu.pattern.strategy;

/**
 * 策略算法1
 */
public class OperationAdd implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
