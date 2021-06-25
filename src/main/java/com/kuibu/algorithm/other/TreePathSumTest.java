package com.kuibu.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 求二叉树某条路径的和，是否等于指定值，如果等于输出路径
 *
 */
public class TreePathSumTest {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(3);
        head.left.right = new Node(1);
        head.left.right.right = new Node(2);


        head.right = new Node(5);


        List<List<Node>> result = new ArrayList<List<Node>>();
        List<Node> path = new ArrayList<Node>();
        int sum = 6;

        checkPath(head, sum, path, result);

        for (List<Node> curPath : result) {
            System.out.print("[");
            for (Node value : curPath) {
                System.out.printf(" " + value.value);
            }
            System.out.print("]");
            System.out.println();
        }
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node addLeft(Node left) {
            this.left = left;
            return left;
        }

        public Node addRight(Node right) {
            this.right = right;
            return right;
        }
    }

    public static void checkPath(Node father, int sum, List<Node> path, List<List<Node>> result) {
        path.add(father);

        if (father.left == null && father.right == null) {
            if (checkSum(path, sum)) {
                result.add(copyPath(path));
            }
        }

        if (father.left != null) {
            checkPath(father.left, sum, path, result);
        }

        if (father.right != null) {
            checkPath(father.right, sum, path, result);
        }

        path.remove(path.size() - 1);
    }

    private static boolean checkSum(List<Node> path, int sum) {
        int curSum = 0;
        for (Node node : path) {
            curSum += node.value;
        }
        return curSum == sum;
    }

    private static List<Node> copyPath(List<Node> path) {
        List<Node> copy = new ArrayList<Node>();
        for (Node node : path) {
            copy.add(node);
        }
        return copy;
    }
}