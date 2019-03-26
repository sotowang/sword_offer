package edu.xjtu.soto.chap9;

import java.util.LinkedList;

/**
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead,分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class TwoStackImpQueue {
    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();

    public void enqueue(int node) {
        stack1.push(node);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        TwoStackImpQueue t = new TwoStackImpQueue();
//        System.out.println(t.dequeue());
        t.enqueue(1);
        t.enqueue(2);
        t.enqueue(3);

        System.out.println(t.dequeue());;

    }
}
