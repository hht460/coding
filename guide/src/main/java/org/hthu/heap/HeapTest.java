package org.hthu.heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(20);
        int[] a = new int[]{12,1,3,6,9,1,23,45,22,67};
//        heap.buildHeap(a,10);
        heap.heapSort(a,10);
        System.out.println(heap.toString());

        heap.insert(8);
//        heap.heapSort();
        System.out.println(heap.toString());
    }
}
