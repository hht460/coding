package org.hthu.jzoffer;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级
 * 	台阶数：跳法
 * 	f(0) = 1 --> 一次跳n阶跳法
 * 	1   :   1 --> f(1)
 * 	2   :   2 --> f(1) + f(0)
 * 	3   :   4 --> f(2) + f(1) + f(0)
 * 	4   :   8 --> f(3) + f(2) + f(1) + f(0)
 * 	5   :   16 --> f(4) + f(3) + f(2) + f(1) + f(0)
 * 	f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1) + f(0) ---(1)
 * 	f(n-1) = f(n-2) + f(n-3) + ... + f(1) + f(0)        ---(2)
 * 	式(1) - (2)得：
 * 	f(n) - f(n-1) = f(n-1)
 * 	得到递推公式： f(n) = 2 * f(n-1) (n=2)
 */
public class JZ09 {

    public int jumpFloorII(int target) {
        if(target <= 0){
            return 1;
        }
        if(target == 1){
            return 1;
        }
        return 2* jumpFloorII(target - 1);
    }
}
