package edu.xjtu.soto.chap35;

import edu.xjtu.soto.RandomListNode;

/**
 * 题目：请实现函数ComplexListNode Clone(ComplexListNode head),复制一个复杂链表，
 * 在复杂链表中，每个节点除了有一个next指针指向下一全邛是，还有一个sibling指针指向链表中的任意节点或者null
 */
public class CloneNodes {
    public RandomListNode cloneNodes(RandomListNode head) {

        if (head == null) {
            return null;
        }
        RandomListNode pNode = head;

        //复制结点
        while (pNode != null) {
            RandomListNode pClone = new RandomListNode(pNode.label+"'");
            pClone.next = pNode.next;
            pNode.next = pClone;
            pNode = pClone.next;
        }

        //设置每个复制结点的random
        pNode = head;
        while (pNode != null) {
            if (pNode.random != null) {
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }

        //拆分链表
        pNode = head;
        RandomListNode cloneHead = pNode.next;
        RandomListNode pcloneNode = cloneHead;

        while (pNode != null) {
            pNode.next = pNode.next.next;

            if (pcloneNode.next != null) {
                pcloneNode.next = pcloneNode.next.next;
            }
            pNode = pNode.next;
            pcloneNode = pcloneNode.next;
        }

        return cloneHead;


    }

    public static void main(String[] args) {
        CloneNodes cn = new CloneNodes();
        RandomListNode r1 = new RandomListNode("A");
        RandomListNode r2 = new RandomListNode("B");
        RandomListNode r3 = new RandomListNode("C");
        RandomListNode r4 = new RandomListNode("D");
        RandomListNode r5 = new RandomListNode("E");

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;

        RandomListNode head = cn.cloneNodes(r1);

        while (head != null) {
            System.out.println(head.label);
            head = head.next;
        }

    }
}
