package org.hthu.linked;

/**
 * 单链表实现 LRU缓存淘汰算法
 * 1、维护一个按照新旧顺序单链表
 * 2、访问一个数据时，遍历链表
 * 2.1、节点存在，将该节点从原来位置删除、然后插入到链表头部
 * 2.2、节点不存在，查询 DB
 *     2.2.1、链表未满，将此节点插入链表头部
 *     2.2.2、链表已经满、删除链表尾节点，将新的数据插入链表头部
 */
public class LRU {

    // 链表节点
    public static class Node {
        public int v;
        public Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    /**
     * 访问某个数据
     * @param node
     * @return
     */
    public Node query(Node node, int n){
        boolean flag = false; // 节点是否存在, true：存在, false: 不存在
        Node head = node;
        Node guard = new Node(0); // 构建哨兵节点
        guard.next = node;
        Node temp = guard;
        Node follower = null;
        while(temp.next != null){
            // 节点存在
            if (n == temp.next.v){
                Node curr = temp.next; // 临时持有当前节点
                temp.next = temp.next.next; // 删除当前节点
                curr.next = head;
                guard.next = curr;
                flag = true; // 节点存在
                return curr;
            }
            follower = temp; // 跟随节点，用于删除最后一个节点
            temp = temp.next;
        }
        // 节点不存在
        if (!flag){
            Node newHead = new Node(66); // 构建新的节点,类似查询db获取数据
            // 链表未满,直接插入链表头部
            // 链表已满, 删除链表尾节点，将该节点插入头部
            if (10 == 10){
                follower.next = follower.next.next; // 删除尾节点
            }
            newHead.next = guard.next;
            guard.next = newHead;
        }
        return guard.next;
    }
}
