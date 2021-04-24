package org.hthu.jzoffer;

/**
 * 	斐波那契数列
 */
public class JZ07 {

    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);

    }

}
