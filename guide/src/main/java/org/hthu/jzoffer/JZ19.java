package org.hthu.jzoffer;

import java.util.ArrayList;

public class JZ19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 向右遍历最上面一行
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            up++; // 上面一行遍历结束，往下移动一行
            if (up > down) {
                break; // 如果最上行移动到最下行处，则跳出循环，结束
            }
            // 向下遍历最右列
            for (int row = up; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            if (right < left) {
                break; // 如果最右行移动到最左行处，则跳出循环，结束
            }
            // 向左遍历最下面一行
            for (int col = right; col >= left; col--) {
                result.add(matrix[down][col]);
            }
            down--;
            if (down < up) {
                break; // 如果最下面一行移动到最上面一行处，则跳出循环，结束
            }
            // 向上遍历最左边一行
            for (int row = down; row >= up; row--) {
                result.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break; // 如果最左行移动到最右行处，则跳出循环，结束
            }
        }
        return result;
    }
}
