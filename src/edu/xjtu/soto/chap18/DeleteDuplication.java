package edu.xjtu.soto.chap18;

import edu.xjtu.soto.ListNode;

/**
 * 删除链表重复结点
 * 题目：在一个排序的链表中，如何删除重复的节点？
 *
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    /**
     * 重新添加头结点
     * @param head
     */
    public static void deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode first = new ListNode(head.val - 1);
        first.next = head;
        ListNode pre = first;
        ListNode p = pre.next;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                p = p.next;
                pre = pre.next;
            } else {
                p = p.next;
                while (p.val == p.next.val) {
                    p = p.next;
                }
                p = p.next;
                pre.next = p;
            }

        }

        head = first.next;
        first = null;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node31 = new ListNode(3);
        ListNode node32 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node41 = new ListNode(4);
        ListNode node42 = new ListNode(4);
        ListNode node51 = new ListNode(5);
        node11.next = node21;
        node21.next = node31;
        node31.next = node32;
        node32.next = node33;
        node33.next = node41;
        node41.next = node42;
        node42.next = node51;

        deleteDuplicate(node11);

        while (node11 != null) {
            System.out.println(node11.val);
            node11 = node11.next;
        }
    }


}
