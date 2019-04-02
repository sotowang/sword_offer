package edu.xjtu.soto.chap23;

import edu.xjtu.soto.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：如果一个链表中包含环，如何找出环的入口节点？
 */
public class MeetingNode {

    /**
     * 双指针法
     * @param head
     * @return
     */
    public static ListNode meetingNode1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode p = head.next;
        ListNode q = head.next.next;
        while (p != q && q != null) {
            p = p.next;
            q = q.next.next;
        }
        if (q == null) {
            return null;
        } else {
            q = head;
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }


    /**
     * 利用set的无序性
     * @param head
     * @return
     */
    public static ListNode meetingNode2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while (set.add(p)) {
            p = p.next;
        }
        return p;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l3;

        ListNode result = meetingNode1(l2);
        System.out.println(result == null ? -1 : result.val);


        ListNode res = meetingNode2(l1);
        System.out.println(res == null ? -1 : res.val);

    }
}
