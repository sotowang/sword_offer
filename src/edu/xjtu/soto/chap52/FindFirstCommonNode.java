package edu.xjtu.soto.chap52;

import edu.xjtu.soto.ListNode;
import edu.xjtu.soto.chap42.FindGreatestSumOfSubArray;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：输入两个链表，找出它们的第一个公共节点。
 */
public class FindFirstCommonNode {

    /**
     * 方法1：两个辅助栈，从尾到头，找到最后一个相同的结点
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNode1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode p = head1;
        ListNode q = head2;

        while (p != null) {
            set.add(p);
            p = p.next;
        }
        while (q != null) {
            if (!set.add(q)) {
                return q;
            }
            q = q.next;
        }
        return null;
    }


    /**
     * 长链表先走
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode p = head1;
        ListNode q = head2;
        int len1 = 0;
        int len2 = 0;

        while (p != null) {
            len1++;
            p = p.next;
        }
        while (q != null) {
            len2++;
            q = q.next;
        }
        p = head1;
        q = head2;

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p = p.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                q = q.next;
            }
        }

        while (p != q && p != null) {
            p = p.next;
            q = q.next;
        }
        if (p == q && p != null) {
            return p;
        }else
            return null;

    }

    public static void main(String[] args) {
        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode commonNode1 = findFirstCommonNode.findFirstCommonNode1(l1, l2);
        ListNode commonNode2 = findFirstCommonNode.findFirstCommonNode2(l1, l2);


        System.out.println(commonNode1.val);
        System.out.println(commonNode2.val);

    }

}
