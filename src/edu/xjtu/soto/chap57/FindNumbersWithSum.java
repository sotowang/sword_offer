package edu.xjtu.soto.chap57;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
public class FindNumbersWithSum {
    public void findNumberWithSum(int[] array, int num, int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            if (array[low] + array[high] == num) {
                num1[0] = array[low];
                num2[0] = array[high];
                return;
            } else if (array[low] + array[high] > num) {
                high--;
            } else {
                low++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        FindNumbersWithSum f = new FindNumbersWithSum();
        int[] array = {1, 2, 4, 7, 11, 15};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        f.findNumberWithSum(array, 15, num1, num2);

        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }
}
