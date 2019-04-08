package edu.xjtu.soto.chap40;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：输入n个整数，找出其中最小的k个数。
 * <p>
 * 例如，输入4，5，1，6，2，7，3，8这8个数字，则最小的4个数字是1，2，3，4
 */
public class GetLeastNumbers {

    public ArrayList<Integer> getLeastNumbers(int[] arrays, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arrays == null || arrays.length == 0 || k <= 0 || k > arrays.length) {
            return list;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : arrays) {
            maxHeap.offer(a);

            //只要size大于k，不断剔除最大值，最后优先队列里只剩最小的k个
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        list.addAll(maxHeap);
        return list;
    }


    public static void main(String[] args) {
        GetLeastNumbers gln = new GetLeastNumbers();
        int[] arrays = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList list = gln.getLeastNumbers(arrays, 4);
        System.out.println(list);

    }

}
