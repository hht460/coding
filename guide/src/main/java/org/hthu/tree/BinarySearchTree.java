package org.hthu.tree;

/**
 * 二叉搜索树,几种基本操作
 */
public class BinarySearchTree {

    private Node node;

    /**
     * 二叉搜索树查找操作
     * @param data
     * @return
     */
    public Node find(int data){
        while(node !=null){
            // 大于当前节点值,遍历右子树
            if (node.data < data){
                node = node.right;
            }
            // 小于当前节点值,遍历左子树
            if(node.data > data){
                node = node.left;
            }
            return node;
        }
        return null;
    }

    /**
     * 静态内部类,构造节点数据结构
     */
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
