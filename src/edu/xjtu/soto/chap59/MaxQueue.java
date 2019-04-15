package edu.xjtu.soto.chap59;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义一个队列，实现max方法得到队列中的最大值。要求入列、出列以及邱最大值的方法时间复杂度都是O(1)
 */
public class MaxQueue {
    private Deque<Integer> maxQueue = new LinkedList<>();
    private Deque<Integer> dataQueue = new LinkedList<>();

    public void offer(int n) {
        dataQueue.offerLast(n);

        //即将要存入的元素比当前队列最大值还大，存入该元素
        if (maxQueue.isEmpty() || n > maxQueue.peekFirst()) {
            maxQueue.offerFirst(n);
        } else {
            //即将要存入和元素不超过当前队列最大值，再将最大值存入一次
            maxQueue.offerFirst(maxQueue.peekFirst());
        }
    }

    public void poll() {
        if (dataQueue.isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        dataQueue.pollFirst();
        maxQueue.pollFirst();
    }

    public int max() {
        if (maxQueue.isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        return maxQueue.peekFirst();
    }


}
