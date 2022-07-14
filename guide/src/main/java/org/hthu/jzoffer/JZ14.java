package org.hthu.jzoffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 */
public class JZ14 {

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode pHead, int k) {
        if (null == pHead) {
            return null;
        }
        ListNode fast = pHead;
        ListNode last = pHead;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) { // 结束条件区别删除倒数第K个节点结束条件
            fast = fast.next;
            last = last.next;
        }
        return last;
    }
}

