package edu.xjtu.soto.chap66;

import java.util.Arrays;

/**
 * 题目：给定一个数组A[0,1,...n-1]，请构建一个数组B[0,1,...,n-1]，
 * 其中B中元素B[i]=A[0]xA[1]x...xA[i-1]xA[i+1]...A[n-1]。不能使用除法。
 */
public class Multiply {

    public int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }

        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;

        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int d = 1;
        for (int i = len - 2; i >= 0; i--) {
            d = d * A[i + 1];
            B[i] *= d;
        }
        return B;
    }


    public static void main(String[] args) {
        Multiply m = new Multiply();

        int[] array = {1, 2, 3, 4};

        int[] b = m.multiply(array);
        System.out.println(Arrays.toString(b));

    }
}
