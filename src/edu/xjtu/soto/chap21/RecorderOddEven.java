package edu.xjtu.soto.chap21;

import java.util.Arrays;

/**
 * 题目：输入一全整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class RecorderOddEven {
    /**
     * 使用两全指针
     * @param array
     */
    public static void recorderOddEven(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while ((array[start] & 1) == 1) {
                start++;
            }
            while ((array[end] & 1) == 0) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 8, 9};

        recorderOddEven(a);
        System.out.println(Arrays.toString(a));

    }
}
