package edu.xjtu.soto.chap10;

/**
 * 题目一：求斐波那契数列的第n项
 */
public class Fibonacci {
    /**
     * 非递归
     *
     * @param n
     * @return
     */
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new RuntimeException("非法数字");
        }
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long MinOne = 1;
        long MinTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = MinOne + MinTwo;
            MinTwo = MinOne;
            MinOne = fibN;
        }
        return fibN;

    }

    /**
     * 递归
     *
     * @param n
     */
    public static long finbonacci2(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        return finbonacci2(n - 1) + finbonacci2(n - 2);
    }


    public static void main(String[] args) {

        System.out.println(fibonacci(100));
        System.out.println(finbonacci2(100));

    }

}
