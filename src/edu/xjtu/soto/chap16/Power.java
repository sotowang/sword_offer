package edu.xjtu.soto.chap16;

/**
 * 题目：实现了函数double Power(double base,int exponent)，
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Power {
    /**
     * 连乘
     * @param base
     * @param exponent
     * @return
     */
    public static double power1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);
        for (int i = 0; i < positiveExponent; i++) {
            result = result * base;
        }
        return exponent < 0 ? 1 / result : result;
    }


    /**
     * 非递归。推荐的做法，复杂度O(lg n)
     * @param base
     * @param exponent
     * @return
     */
    public static double power2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);

        while (positiveExponent != 1) {

            //判断是否为奇数
            if ((positiveExponent & 1) == 1) {
                result = result * base;
            }
            base = base * base;

            //positiveExponent 除以2
            positiveExponent = positiveExponent >> 1;
        }

        return exponent < 0 ? 1 / (result * base) : result * base;

    }


    public static void main(String[] args) {
        System.out.println(power1(2, -2));
        System.out.println(power2(2,-2));
    }
}
