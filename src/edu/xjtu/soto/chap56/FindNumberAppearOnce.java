package edu.xjtu.soto.chap56;

import java.util.Arrays;

/**
 * 题目一：
 *
 * 一个整形数组里除两个数字之外，其他数字都出现了两次。请写程序找出为两个只出现一次数数字。
 *
 * 要求时间复杂度为O(n)，空间复杂度为O(1)
 */
public class FindNumberAppearOnce {

    public void findNum(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int temp = 0;

        //将数组所有元素进行异或运算，最后得到的值 为两个不同元素的异或值，因为一个数异或它本身为0
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        int index = findFirstOneIndex(temp);

        num1[0] = num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBitOne(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找到第1个为1的位置
     * @param n
     * @return
     */
    private int findFirstOneIndex(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while ((n & 1) != 1) {
            n = n >> 1;
            count++;
        }
        return count;
    }

    /**
     * 判断该位 是否为1
     * @param n
     * @param index
     * @return
     */
    private boolean isBitOne(int n, int index) {
        n = n >> index;
        if ((n & 1) == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumberAppearOnce f = new FindNumberAppearOnce();
        int[] num1 = {0};
        int[] num2 = {0};
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};

        f.findNum(array, num1, num2);

        System.out.println(Arrays.toString(num1) + "\n" +
                Arrays.toString(num2));

    }
}
