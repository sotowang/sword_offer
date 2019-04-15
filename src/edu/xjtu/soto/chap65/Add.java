package edu.xjtu.soto.chap65;

/**
 * 题目：写一个函数，求两个整数之和，要求在函数体愉产处使用”+“，”-“，”x“，”/“四则运算符号
 */
public class Add {
    public int add(int a, int b) {
        //b!=0 说明还有进位需要相加
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;

            a = sum;
            b = carry;

        }
        return a;
    }

    public static void main(String[] args) {
        Add add = new Add();
        int sum = add.add(15, 8);
        System.out.println(sum);

    }
}
