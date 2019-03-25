package edu.xjtu.soto.chap6;

import edu.xjtu.soto.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头打印链表每个节点的值。
 */
public class FromTail2Head {
    private  ArrayList<Integer> arrayList = new ArrayList<>();


    /**
     * 使用栈
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        return new ArrayList<>(stack);
    }

    /**
     * 使用递归
     * @param listNode
     * @return
     */
    public  ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        printListFromTailToHead2(listNode.next);

        arrayList.add(listNode.val);
        return arrayList;

    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1);
        ListNode p = listNode;
        for (int i = 0; i <10; i++) {
            p.next = new ListNode(2 * i + 1);
            p = p.next;
        }

        FromTail2Head fromTail2Head = new FromTail2Head();
        ArrayList arrayList2 = fromTail2Head.printListFromTailToHead2(listNode);
        ArrayList arrayList3 = fromTail2Head.printListFromTailToHead2(null);

        ArrayList arrayList = printListFromTailToHead(listNode);
        for (int i = 0; i <arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }
    }

}
