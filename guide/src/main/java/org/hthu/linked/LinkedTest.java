package org.hthu.linked;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 链表相关
 */
public class LinkedTest {

    // 链表节点
    public static class Node {
        public char c;
        public Node next;

        public Node(char c) {
            this.c = c;
        }
    }

    // 链表反转
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node next = head.next;

        while (next != null) {
            // 断开下一个节点，调整链表方向
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = prev;
        return cur;
    }

    /**
     * 判断是否为循环链表，快慢指针
     */
    public static boolean existsCircle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 两个有序链表合并
    public static Node merge(Node head1, Node head2) {

        // 哨兵
        Node guard = new Node('/');
        Node cur = guard;

//        while (head1 != null && head2 != null) {
//            if (head1.c <= head2.c) {
//                while (head1 != null && head1.c <= head2.c) {
//                    cur.next = head1;
//                    cur = cur.next;
//                    head1 = head1.next;
//                }
//            } else {
//                while (head2 != null && head1.c > head2.c) {
//                    cur.next = head2;
//                    cur = cur.next;
//                    head2 = head2.next;
//                }
//            }
//        }

        while (head1 != null && head2 != null) {
            if (head1.c <= head2.c) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }

        return guard.next;

    }

    /**
     *  k个有序链表合并（优先队列）
     *
     * ^            ^           ^
     * |            |           |
     * *****        *****       *****
     * *   *        *   *       *   *
     * *****        *****       *****
     * ^            ^           ^
     * |            |           |
     * *****        *****       *****
     * *   *        *   *       *   *
     * *****        *****       *****
     * ^            ^           ^
     * |            |           |
     * *****        *****       *****
     * *   *        *   *       *   *
     * *****        *****       *****
     * *****|************|***********|*******
     * *  *****        *****       *****    *
     * *  *   *        *   *       *   *    *
     * *  *****        *****       *****    *
     * ************************************** （优先队列）
     */
    public static Node mergeKList(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 定义一个哨兵
        Node guard = new Node('0');
        Node cur = guard;

        // 创建优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>(lists.length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c - o2.c;
            }
        });
        // 遍历所有链表，将每个链表第一个节点放入队列
        for (Node node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        // 循环从队列中取节点
        while (!queue.isEmpty()) {
            // 弹出第一个最小节点
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                // 当前链表是否存在下一个节点
                // 链表放入队列，链表自身指针依然存在
                queue.add(cur.next);
            }
        }
        return guard.next;
    }

    // 删除倒数第N个节点
    public static Node deleteLastN(Node head, int n) {
        if (n < 1 || head == null) {
            return head;
        }
        // 哨兵节点
        Node guard = new Node('/');
        // 添加哨兵节点
        guard.next = head;

        Node slow = guard;
        Node fast = guard;

        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除节点操作
        slow.next = slow.next.next;
        return guard.next;
    }

    /**
     * 获取中间节点,快慢指针
     */
    public static Node getMiddle(Node head, int n) {
        Node slow = head;
        Node fast = head;

        // 链表个数为奇数：fast指针移到倒数第一个节点结束（fast.next != null）
        // 链表个数为偶数：fast指针移到倒数第二个节点结束（fast.next.next != null）
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
