package edu.xjtu.soto.chap30;

import java.util.LinkedList;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数，在该栈中，调用min，push,及pop的时间复杂度都是O(1)。
 */
public class StackIncludeFuncMin {
    private LinkedList<Integer> stack = new LinkedList<>();

    //辅助栈，用于存储当前最小值
    private LinkedList<Integer> stackMin = new LinkedList<>();

    public void push(int node) {
        stack.push(node);
        if (stackMin.isEmpty() || node < stackMin.peek()) {
            stackMin.push(node);
        } else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stake is empty!");
        }
        stack.pop();
        stackMin.pop();
    }


    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return stack.peek();
    }

    public int min() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        StackIncludeFuncMin stackIncludeFuncMin = new StackIncludeFuncMin();

        stackIncludeFuncMin.push(5);
        System.out.println(stackIncludeFuncMin.min());
        stackIncludeFuncMin.push(4);
        System.out.println(stackIncludeFuncMin.min());
        stackIncludeFuncMin.push(6);
        System.out.println(stackIncludeFuncMin.min());
        stackIncludeFuncMin.push(3);
        System.out.println(stackIncludeFuncMin.min());

        stackIncludeFuncMin.pop();
        System.out.println(stackIncludeFuncMin.min());
        stackIncludeFuncMin.pop();
        System.out.println(stackIncludeFuncMin.min());
        stackIncludeFuncMin.pop();
        System.out.println(stackIncludeFuncMin.min());
    }
}
