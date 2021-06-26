package com.kuibu.algorithm.other;

public class RandomListNodeCopy {

    public static Node copy(Node head) {
        if(head == null) {
            return null;
        }

        Node cur = head;

        // 在原链表每个节点后边新建一个节点， 作为新链表的元素
        while(cur != null) {
            Node newNode = new Node(cur.val);

            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        // 复制原链表的随机指针
        cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            if(cur.random != null) {
                newNode.random = cur.random.next;
            }

            cur = newNode.next;
        }

        // 将新链表和旧链表拆分开
        Node newHead = head.next;
        cur = head;
        while (cur !=null) {
            Node newNode = cur.next;
            cur.next = newNode.next;

            cur = cur.next;

            if(cur != null) {
                newNode.next = cur.next;
            }
        }

        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}
