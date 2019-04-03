package edu.xjtu.soto.chap25;

import edu.xjtu.soto.ListNode;

/**
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍是递增排序的。
 *
 * 例如，输入链表1：1--3--5--7      链表2:2--4--6--8
 *
 * 合并之：  链表3 ：   1--2--3--4--5--6--7--8
 */
public class Merge {
    /**
     * 非递归版本，设定两个指针
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head= null;
        ListNode p = l1;
        ListNode q = l2;

        if (l1.val <= l2.val) {
            head = l1;
            p = l1.next;
        } else {
            head = l2;
            q = l2.next;
        }

        ListNode cur = head;
        while (p != null || q != null) {
            if (p == null) {
                cur.next = q;
                break;
            } else if (q == null) {
                cur.next = p;
                break;
            } else if (p.val < q.val) {
                cur.next = p;
                cur = cur.next;
                p = p.next;
            } else {
                cur.next = q;
                cur = cur.next;
                q = q.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;
        l2.next = l4;
        l4.next = l6;
//        l6.next = l8;


        ListNode res = merge(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}
