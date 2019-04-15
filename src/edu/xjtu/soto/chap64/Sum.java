package edu.xjtu.soto.chap64;

import edu.xjtu.soto.chap63.MaxProfit;

/**
 * 题目：求1+2+..+n，要求不能使用乘除法，for，while，if，else,switch,case等关键字及条件判断语句（A？B:C）
 */
public class Sum {

    /**
     * 逻辑与 短路
     * @param n
     * @return
     */
    public int sum1(int n) {
        int sum = n;
        boolean b = n > 0 && (sum+=sum1(n - 1)) > 0;
        return sum;
    }

    /**
     * 数学公式
     * @param n
     * @return
     */
    public int sum2(int n) {
        return (int)(Math.pow(n, 2) + n) >> 1;
    }


    public static void main(String[] args) {
        Sum sum = new Sum();
        int a = sum.sum1(5);
        System.out.println(a);


        System.out.println(sum.sum2(5));

    }
}
