package edu.xjtu.soto.chap11;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < array.length ; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        bubbleSort(array);

        System.out.println(Arrays.toString(array));

    }

}
