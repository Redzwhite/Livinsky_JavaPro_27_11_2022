package org.example.homework17;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = createBinaryTree();
        bt.traverseInOrder(bt.root);
        System.out.println();
        bt.traversePreOrder(bt.root);
        System.out.println();
        bt.traversePostOrder(bt.root);
        System.out.println();
        bt.traverseLevelOrder();
        System.out.println();
        bt.containsNode(6);
    }
    private static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }
}
