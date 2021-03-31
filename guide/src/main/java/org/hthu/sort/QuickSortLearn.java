package org.hthu.sort;

/**
 * @file: QuickSortLearn.java
 * @version: 1.0
 * @Description 快排算法
 * @author: 胡海涛(X4818)
 * @date 2020年12月16日 下午5:28:13
 */
public class QuickSortLearn {

    /*
     * 1、选取分区点(关键)
     * 2、根据分区点将数组一分为二,进行递归
     */
    public void quickSort(int[] a) {
        int len = a.length;
        recursionSort(a,0,len-1);
    }


    /*
     * 递归
     * startIndex: 头指针
     * endIndex：尾指针
     */
    public void recursionSort(int[] temp, int startIndex, int endIndex) {
        if(startIndex >= endIndex) {
            return;
        }

        // 由分区值获取分区点
//        int p = getPartition(temp, startIndex,endIndex);
        int p = getPartitionMethod2(temp, startIndex,endIndex);
        recursionSort(temp,startIndex,p-1);
        recursionSort(temp,p+1,endIndex);
    }

    /*
     * 获取分区点; 方法一
     * 1、默认取第一个元素作为起始分区点
     * 2、取余下元素与分区点元素比较
     * 2.1、大于分区点放置在右边,小区分区点放置在左边
     */
    public int getPartition(int[] temp, int lo, int hi) {
        int pv = temp[lo];
        int startIndex = lo;
        int endIndex = hi + 1;
        while(true) {
            /*
             * 左边元素与分区点比较
             * 比分区点元素小，保持位置不动，移动指针
             * 比分区点元素大，保存当前指针位置，跳出循环，停止向前移动
             * 当指针越界，过了尾指针endIndex,此刻也需要停止向前移动，跳出循环（表示当前数组元素都比分区点值小）
             */
            while(temp[++startIndex] < pv) {
                if(startIndex>=hi) {
                    break;
                }
            }

            /*
             * 右边元素与分区点比较
             * 比分区点元素大，保持位置不动，向左移动指针
             * 比分区点元素小，保存当前指针位置，跳出循环，停止向左移动
             * 当指针越界，过了头指针startIndex,此刻也需要停止向左移动，跳出循环（表示当前数组元素都比分区点值大）
             */
            while(temp[--endIndex] > pv) {
                if(endIndex<=lo) {
                    break;
                }
            }

            /*
             * 跳出循环
             */
            if(startIndex>=endIndex) {
                break;
            }

            /*
             * 交换temp[startIndex] 和 temp[endIndex]
             */
            int t = temp[endIndex];
            temp[endIndex] = temp[startIndex];
            temp[startIndex] = t;

        }

        /*
         * 获取该次分区点
         */
        int cpv = temp[endIndex];
        temp[endIndex] = temp[lo];
        temp[lo] = cpv;
        return endIndex;
    }

    /**
     * 获取分区点；方法二
     * @param temp
     * @param lo
     * @param hi
     * @return
     */
    public int getPartitionMethod2(int[] temp, int lo, int hi){
        int partition = temp[lo]; // 取起始位置为起始分区点
        int i = lo;
        int j = hi;
        while ( i < j){
            while( i < j && temp[j] >= partition){
                j--; // 向左移动
            }
            temp[i] = temp[j];
            while(i < j && temp[i] <= partition){
                i++;
            }
            temp[j] = temp[i];
        }
        temp[i] = partition;
        return i;
    }
}



