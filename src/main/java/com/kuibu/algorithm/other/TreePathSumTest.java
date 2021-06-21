package com.kuibu.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
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
        if (father.left == null || father.right == null) {
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

    private static List<Node> copyPath(List<Node> path) {
        List<Node> copy = new ArrayList<Node>();
        for (Node node : path) {
            copy.add(node);
        }
        return copy;
    }

    private static boolean checkSum(List<Node> path, int sum) {
        int curSum = 0;
        for (Node node : path) {
            curSum += node.value;
        }
        return curSum == sum;
    }

}