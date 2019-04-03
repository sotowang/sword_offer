package edu.xjtu.soto.chap24;

import edu.xjtu.soto.ListNode;

/**
 * 题目:定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {

    /**
     * 头插法
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode p = head.next;
        head.next = null;
        ListNode q = p;
        while (p != null) {
            q = p.next;
            p.next = first.next;
            first.next = p;
            p = q;
        }
        head = first.next;
        first = null;
        return head;

    }

    /**
     * 使用递归
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //递归后的头节点
        ListNode headNode  = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return headNode;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

//        ListNode result = reverseList1(l1);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }

        System.out.println("------------------------");
        ListNode res = reverseList2(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
