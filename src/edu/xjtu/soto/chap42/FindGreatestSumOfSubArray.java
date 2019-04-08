package edu.xjtu.soto.chap42;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值，要求时间复杂度为O(n)
 */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray fgss = new FindGreatestSumOfSubArray();
        int[] array1 = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] array2 = {1};
        int max1 = fgss.findGreatestSumOfSubArray(array1);
        int max2 = fgss.findGreatestSumOfSubArray(array2);

        System.out.println(max1);
        System.out.println(max2);

    }
}
