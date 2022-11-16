package org.hthu.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 遍历二叉树
 */
public class PrintTree {

    /**
     * 前序遍历二叉树 节点-->左子树-->右子树
     *
     * @param node
     */
    public void preOrder(Node node) {
        // 截至条件
        if (node == null) {
            return;
        }
        // 打印当前节点
        System.out.println(node.data);
        // 递归左子树
        preOrder(node.left);
        // 递归右子树
        preOrder(node.right);
    }

    /**
     * 中序遍历 左子树-->节点-->右子树
     *
     * @param node
     */
    public void inOrder(Node node) {
        // 截至条件
        if (node == null) {
            return;
        }
        // 递归左子树
        inOrder(node.left);
        // 打印当前节点
        System.out.println(node.data);
        // 递归右子树
        inOrder(node.right);
    }

    /**
     * 后续遍历, 左子树-->右子树-->节点
     *
     * @param node
     */
    public void posOrder(Node node) {
        // 截至条件
        if (node == null) {
            return;
        }
        // 递归左子树
        posOrder(node.left);
        // 递归右子树
        posOrder(node.right);
        // 打印当前节点
        System.out.println(node.data);

    }

    /**
     * 二叉树层序编列,利用队列辅助打印
     *
     * @param node
     */
    public void levelOrder(Node node) {
        if (node == null) {
            return;
        }
        // 定义一个队列
        Queue<Node> queue = new LinkedList<>();
        // 将二叉树根节点poll进队列
        queue.offer(node);
        while (!queue.isEmpty()) {
            // 从队列弹出一个根节点
            Node curNode = queue.poll();
            System.out.println(curNode.data);
            // 当前节点左子树不为空,放入队列中
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            // 当前节点右子树不为空,放入队列中
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
    }

    /**
     * 二叉树右视图
     * 就是在添加元素的时候，判断下是否是本层的最后一个即可
     *
     * @param node 二叉树
     */
    public void rightSideView(Node node) {
        if (node == null) {
            return;
        }
        // 定义一个队列
        Queue<Node> queue = new LinkedList<>();
        // 将二叉树根节点poll进队列
        queue.offer(node);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队列弹出一个节点
                Node curNode = queue.remove();
                if (i == size - 1) {
                    System.out.println(curNode.data);
                }
                // 左右树
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
    }

    /**
     * 二叉树左视图
     * 就是在添加元素的时候，判断下是否是本层的最后一个即可
     *
     * @param node 二叉树
     */
    public void leftSideView(Node node) {
        if (node == null) {
            return;
        }
        // 定义一个队列
        Queue<Node> queue = new LinkedList<>();
        // 将二叉树根节点poll进队列
        queue.offer(node);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队列弹出一个节点
                Node curNode = queue.remove();
                if (i == 0) {
                    System.out.println(curNode.data);
                }
                // 左右树
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
    }

    /**
     * 二叉树右视图
     *
     * @param node 二叉树
     */
    public void lookDownView(Node node) {

        if (node == null) {
            return;
        }
        leftSideView(node);
        rightSideView(node);
    }
}
