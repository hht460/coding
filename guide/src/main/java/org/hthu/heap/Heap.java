package org.hthu.heap;

/**
 * 堆几种基本操作
 */
public class Heap {

    // 利用数组构建堆,
    private int[] heap;

    // 堆可以存储最大数据个数
    private int n;

    // 当前堆存储元素个数
    private int count;

    // 构造函数
    public Heap(int capacity) {
        // 从数组下标1的位置开始存储
        heap = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 堆化,构建大顶堆
     * 堆化有两种方式: 从【下往上堆化,从上往下堆化】
     * 当前插入操作采用【从下往上】堆化
     */
    // 插入一个元素, 默认当前堆没有元素
    public void insert(int data) {
        // 堆满了
        if (count >= n) {
            return;
        }
        ++count;
        // 新元素放入堆底部
        heap[count] = data;
        // 从下往上堆化
        // 末尾元素位置
        int i = count;
        while (i / 2 > 0 && heap[i] > heap[i / 2]) {
            // 父节点比自己点小
            swap(heap, i, i / 2);
            i = i/2;
        }
    }

    /**
     * 移除大顶堆 堆顶元素(最大值)
     * 采用覆盖方式,即将堆末尾元素(数组末尾元素)移到堆顶位置, 再进行堆化重建堆
     */
    public int removeMax(){
        // 堆为空
        if(count == 0){
            return -1;
        }
        heap[1] = heap[count];
        // 更新堆中元素个数
        --count;
        // 堆化,重建堆

    }

    /**
     * 堆化大顶堆, 采用【从上往下】堆化
     * @param temp 堆
     * @param i 当前删除数据位置,即数组第一个位置(index = 1)
     * @param n 堆大小
     */
    private void heapify(int[] temp, int i, int n) {
        while (true) {
            // 定义临时最大点位置
            int maxPos = i;
            // 比较当前节点与其两个子节点大小
            // 左子树
            if (2 * i <= n && temp[i] < temp[2 * i]) {
                // 更新最大点位
                maxPos = 2*i;
            }
            // 右子树
            if (2*i+1 <=n && temp[maxPos] < temp[2*i+1]){
                // 更新最大点位
                maxPos = 2*i+1;
            }
            // 当前节点满足堆特性,当前节点大于等于或者小于等于两个子节点, 终止循环
            if (maxPos == i){
                break;
            }
            // 交换两个节点,将大节点上移(大顶堆)
            swap(temp,maxPos,i);
            // 节点值交换后,继续对maxPos位置存储的节点向下搜索,直到找到合适的位置
            i = maxPos;
        }
    }

    /**
     * 交换a、b位置
     * @param array
     * @param a
     * @param b
     */
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
