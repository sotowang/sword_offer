package edu.xjtu.soto.chap14;

/**
 * 剪绳子 动态规划算法
 */
public class CutString {
    public static int maxProductAfterCutting_solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];

        //先存绳子的长度
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;

    }

    /**
     * 贪婪算法
     *
     * @param length
     */

    public static int maxProductAfterCutting_solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = length / 3;
        //当绳子最后剩下的长度为4的时候，不能再剪长度为3的绳子段
        //此时更好的方法是殷绳子剪成长度为2的两段，因为2x2>1x3
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));


    }

    public static void main(String[] args) {
        int max = maxProductAfterCutting_solution1(0);
        System.out.println(max);
        System.out.println(maxProductAfterCutting_solution2(0));
    }
}
