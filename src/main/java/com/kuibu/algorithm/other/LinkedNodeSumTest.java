package com.kuibu.algorithm.other;

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
public class LinkedNodeSumTest {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.addNode(new ListNode(2)).addNode(new ListNode(2));

        ListNode l2 = new ListNode(2);
        l2.addNode(new ListNode(3));

        ListNode result  = addTwoNumbers(l1, l2);

        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curResult = result;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null || cur2 != null) {
            int sum = 0;
            if(cur1 != null) {
                sum += cur1.value;
                cur1 = cur1.next;
            }

            if (cur2 != null) {
                sum += cur2.value;
                cur2 = cur2.next;
            }

            curResult.value += sum % 10;
            curResult.next = new ListNode(0);

            if(sum / 10 > 0) {
                curResult.next.value = sum / 10;
                curResult.next.value += curResult.value / 10;
            }

            curResult = curResult.next;
        }

        return result;
    }

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode addNode(ListNode node) {
            next = node;
            return node;
        }
    }
}