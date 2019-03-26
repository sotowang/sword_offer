package edu.xjtu.soto.chap9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列模拟一个栈
 */
public class TwoQueueImpStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int node) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.offer(node);
        } else if (!q1.isEmpty()) {
            q1.offer(node);
        } else {
            q2.offer(node);
        }
    }

    public int pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        if (!q1.isEmpty()) {
            for (int i = 0; i < q1.size()-1; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else{
            for (int i = 0; i < q2.size()-1; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }


    }

    public static void main(String[] args) {
        TwoQueueImpStack a = new TwoQueueImpStack();
        a.push(54);
        a.push(55);
        a.push(56);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(53);
        System.out.println(a.pop());
        a.push(52);
        System.out.println(a.pop());
        System.out.println(a.pop());
    }

}
