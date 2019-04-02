package edu.xjtu.soto.chap22;

import edu.xjtu.soto.ListNode;

/**
 * 题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 */
public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k-1; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        System.out.println(findKthToTail(head, 5).val);
    }
}
