package org.hthu.jzoffer;

/**
 * 	跳台阶
 * 	台阶数：跳法
 * 	1   :   1
 * 	2   :   2
 * 	3   :   3
 * 	4   :   5
 * 	5   :   8
 * 	得到递推公式：f(n) = f(n-1) + f(n-2)
 */
public class JZ08 {

    public int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
