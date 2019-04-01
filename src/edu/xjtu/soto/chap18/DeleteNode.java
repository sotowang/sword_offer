package edu.xjtu.soto.chap18;

import edu.xjtu.soto.ListNode;

/**
 * 删除链表 指定结点
 */
public class DeleteNode {
    public static void deleteNode(ListNode head, ListNode p) {
        if (head == null || p == null) {
            return;
        }

        //要删除的节点不是尾节点
        if (p.next != null) {
            ListNode pNext = p.next;
            p.val = pNext.val;
            p.next = pNext.next;
            pNext = null;
            //是尾节点也是头节点
        } else if (head == p) {
            head = head.next;
            //仅是尾节点
        } else {
            ListNode first = head;
            while (first.next != p) {
                first = first.next;
            }
            first.next = null;
        }
    }

}

