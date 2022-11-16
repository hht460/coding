package org.hthu.tree;

/**
 * 二叉搜索树(BST),几种基本操作
 */
public class BinarySearchTree {

    // 持有二叉搜索树指针
    private Node node;

    /**
     * 二叉搜索树查找操作
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node tmp = node;
        while (tmp != null) {
            // 大于当前节点值,遍历右子树
            if (tmp.data < data) {
                tmp = tmp.right;
            }
            // 小于当前节点值,遍历左子树
            else if (tmp.data > data) {
                tmp = tmp.left;
            } else {
                return tmp;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树插入操作
     *
     * @param data
     */
    public Node insert(Node currNode, int data) {
        // 空二叉搜索树
        if (currNode == null) {
            currNode = new Node(data);
            return currNode;
        }
        // 循环遍历
        while (currNode != null) {
            // 比当前节点数据小,遍历左子树
            if (currNode.data > data) {
                // 左子树为空
                if (currNode.left == null) {
                    currNode.left = new Node(data);
                    return currNode;
                }
                // 左子树不为空,继续递归遍历左子树
                currNode = currNode.left;
            }
            // 比当前节点数据大,遍历右子树
            if (currNode.data < data){
                // 右子树为空
                if (currNode.right == null) {
                    currNode.right = new Node(data);
                    return currNode;
                }
                // 右子树不为空,继续递归遍历右子树
                currNode = currNode.right;
            }
        }
        return currNode;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
