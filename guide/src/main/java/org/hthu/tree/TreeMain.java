package org.hthu.tree;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/11/15
 */
public class TreeMain {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Node node = new Node(20);

        binarySearchTree.insert(node,12);
        binarySearchTree.insert(node,13);
        binarySearchTree.insert(node,11);
        binarySearchTree.insert(node,21);
        binarySearchTree.insert(node,22);
        binarySearchTree.insert(node,24);
        binarySearchTree.insert(node,25);
        binarySearchTree.insert(node,31);

        PrintTree printTree = new PrintTree();

        printTree.lookDownView(node);

        printTree.inOrder(node);
    }
}
