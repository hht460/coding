package org.hthu.jzoffer;

import java.util.ArrayList;

/**
 * 	从尾到头打印链表(反转链表)
 */
public class JZ03 {

    // 链表反转（原地反转）
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        // 为空、或只有一个节点，直接返回
        if(listNode == null){
            return list;
        }
        if(listNode.next == null){
            list.add(listNode.val);
            return list;
        }
        // 创建哨兵节点
        ListNode resultList = new ListNode();
        // 将当前链表挂在哨兵节点后面
        resultList.next = listNode;
        // 保留当前节点指针
        ListNode p = listNode;
        ListNode pNext = p.next;

        while(pNext != null){
            // 切断节点 pNext处于游离状态
            p.next = pNext.next;
            // 将原始链表挂在游离节点后面
            pNext.next = resultList.next;
            // 将pNext挂到起始节点后面
            resultList.next = pNext;
            // 移动 pNext指针，继续下一个节点切分，注意，p指针无须移动
            pNext = p.next;
        }

        ListNode temp = resultList.next;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }

    public static class ListNode{
        private Integer val;
        private ListNode next;

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
