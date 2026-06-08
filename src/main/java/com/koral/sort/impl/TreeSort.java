package com.koral.sort.impl;

public class TreeSort {
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        Node root = null;

        // строим дерево
        for (int value : array) {
            root = insert(root, value);
        }

        // заполняем массив через inorder обход
        int[] index = new int[]{0};
        inorder(root, array, index);

        return array;
    }

    private static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    private static void inorder(Node node, int[] array, int[] index) {
        if (node == null) {
            return;
        }

        inorder(node.left, array, index);
        array[index[0]++] = node.value;
        inorder(node.right, array, index);
    }
}
