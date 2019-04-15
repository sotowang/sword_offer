package edu.xjtu.soto.chap59;

import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，它们的嗫大值分别为{4，4，6，6，6，5}
 */
public class MaxInWindow {

    /**
     * 使用优先队列（最大堆）
     * @param array
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindow1(int[] array, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < size || size <= 0) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            maxHeap.offer(array[i]);
            if (maxHeap.size() >= size) {
                res.add(maxHeap.peek());
                maxHeap.remove(array[j++]);
            }
        }
        return res;
    }

    /**
     * 使用双端队列，存入数组下标
     * @param array
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindow2(int[] array, int size) {
        ArrayList<Integer> res = new ArrayList<>();

        if (array == null || array.length < size || size <= 0) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && i - deque.peekFirst() >= size) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i + 1 >= size) {
                res.add(array[deque.peekFirst()]);
            }

        }
        return res;


    }


    public static void main(String[] args) {
        MaxInWindow f = new MaxInWindow();
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList list = f.maxInWindow1(array, 3);
        System.out.println(list);


        System.out.println(f.maxInWindow2(array,3));

    }
}
