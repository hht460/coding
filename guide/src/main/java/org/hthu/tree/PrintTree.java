package org.hthu.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 遍历二叉树
 */
public class PrintTree {

    /**
     * 前序遍历二叉树 节点-->左子树-->右子树
     * @param node
     */
    public void preOrder(Node node){
        // 截至条件
        if(node == null){
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
     * @param node
     */
    public void inOrder(Node node){
        // 截至条件
        if (node == null){
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
     * @param node
     */
    public void posOrder(Node node){
        // 截至条件
        if (node == null){
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
     * @param node
     */
    public void levelOrder(Node node){
        if (node == null){
            return;
        }
        // 定义一个队列
        Queue<Node> queue = new LinkedList<>();
        // 将二叉树根节点poll进队列
        queue.offer(node);
        while (!queue.isEmpty()){
            // 从队列弹出一个根节点
            Node curNode = queue.poll();
            System.out.println(curNode.data);
            // 当前节点左子树不为空,放入队列中
            if (curNode.left !=null){
                queue.offer(curNode.left);
            }
            // 当前节点右子树不为空,放入队列中
            if (curNode.right !=null){
                queue.offer(curNode.right);
            }
        }
    }
}
