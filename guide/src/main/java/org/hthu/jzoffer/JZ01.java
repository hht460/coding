package org.hthu.jzoffer;

public class JZ01 {
    public static void main(String[] args) {

    }

    /**
     * 二维数组中的查找
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
