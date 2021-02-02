package org.hthu.tree;

/**
 * 二叉搜索树(BST),几种基本操作
 */
public class BinarySearchTree {

    // 持有二叉搜索树指针
    private Node node;

    /**
     * 二叉搜索树查找操作
     * @param data
     * @return
     */
    public Node find(int data){
        Node tmp = node;
        while(tmp !=null){
            // 大于当前节点值,遍历右子树
            if (tmp.data < data){
                tmp = tmp.right;
            }
            // 小于当前节点值,遍历左子树
            else if(tmp.data > data){
                tmp = tmp.left;
            }else {
                return tmp;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树插入操作
     * @param data
     */
    public void insert(int data){
        // 空二叉搜索树
        if (node == null){
            node = new Node(data);
            return;
        }
        //
        while (node !=null){
            // 比当前节点数据小,遍历左子树
            if (node.data > data){
                // 左子树为空
                if (node.left == null){
                    node.left = new Node(data);
                    return;
                }
                // 左子树不为空,继续递归遍历左子树
                node = node.left;
            }
            // 比当前节点数据大,遍历右子树
            if (node.data < data){
                // 右子树为空
                if (node.right == null){
                    node.right = new Node(data);
                    return;
                }
                // 右子树不为空,继续递归遍历右子树
                node = node.right;
            }
        }
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
