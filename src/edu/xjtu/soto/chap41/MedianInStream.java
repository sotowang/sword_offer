package edu.xjtu.soto.chap41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class MedianInStream {

    private PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minPQ = new PriorityQueue<>();

    private int count;

    public void insert(Integer num) {

        //第一个元素插入最大堆
        if (count == 0) {
            maxPQ.offer(num);
        }//当前数据流为奇数个时，存入最小堆
        else if ((count & 1) == 1) {
            //如果存入最小堆的元素比最大堆的最大元素要小，，将不能保证最小堆的最小元素大于最大堆的最大元素
            //此时需要将最大堆的最大元素给最小堆，然后将这个元素存入最大堆中
            if (num < maxPQ.peek()) {
                minPQ.offer(maxPQ.poll());
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }
        }//当前数据流为偶数个时，存入最大堆
        else if ((count & 1) == 0) {
            // 如果要存入最大堆的元素比最小堆的最小元素大，将不能保证最小堆的最小元素大于最大堆的最大元素
            // 此时需要将最小堆的最小元素给最大堆，然后将这个元素存入最小堆中
            if (num > minPQ.peek()) {
                maxPQ.offer(minPQ.poll());
                minPQ.offer(num);
            } else {
                maxPQ.offer(num);
            }
        }
        count++;
    }

    public Double getMedian() {
        // 当数据流读个数为奇数时，最大堆的元素个数比最小堆多1,因此中位数在最大堆中
        if ((count & 1) == 1) {
            return Double.valueOf(maxPQ.peek());
        }
        // 当数据流个数为偶数时，最大堆和最小堆的元素个数一样，两个堆的元素都要用到
        System.out.println(maxPQ.peek());
        System.out.println(minPQ.peek());
        return (Double.valueOf(maxPQ.peek()) + Double.valueOf(minPQ.peek())) / 2;
    }

    public static void main(String[] args) {
        MedianInStream medianInStream = new MedianInStream();
        medianInStream.insert(1);
        medianInStream.insert(2);
        medianInStream.insert(3);
        medianInStream.insert(4);
        medianInStream.insert(5);
        medianInStream.insert(6);
        System.out.println(medianInStream.getMedian());

    }
}
