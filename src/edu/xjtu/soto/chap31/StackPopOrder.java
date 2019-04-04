package edu.xjtu.soto.chap31;


import java.util.LinkedList;

/**
 * 题目：输入两个整数序列。第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列{1,2,3,4,5,}是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4，3，5，1，2}就不可能是该压栈序列的弹出序列。
 */
public class StackPopOrder {
    /**
     *
     * @param push 压入序列
     * @param pop  弹出序列
     * @return
     */
    public boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0) {
            return false;
        }

        int position = 0;
        LinkedList<Integer> stackAur = new LinkedList<>();
        for (int i = 0; i < push.length; i++) {
            stackAur.push(push[i]);
            while (!stackAur.isEmpty() && stackAur.peek() == pop[position]) {
                stackAur.pop();
                position++;
            }
        }
        return stackAur.isEmpty();

    }

    public  static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        StackPopOrder stackPopOrder = new StackPopOrder();
        boolean b1 = stackPopOrder.isPopOrder(push, pop1);
        boolean b2 = stackPopOrder.isPopOrder(push, pop2);


        System.out.println(b1);
        System.out.println(b2);
    }
}
