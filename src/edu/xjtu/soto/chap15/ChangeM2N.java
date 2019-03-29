package edu.xjtu.soto.chap15;

/**
 * 题目：输入两个整数m和n，计算需要改变m的二朝向表示中的多少位才能得到n。
 * <p>
 * 比如10的二进制表示为1010，13的二进制表示为1101。需要改变1010中的3位才能得到1101。
 */
public class ChangeM2N {
    public static int changeM2N(int m, int n) {
        int a = m ^ n;
        int count = 0;
        while (a != 0) {
            count++;
            a = (a - 1) & a;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(changeM2N(10, 13));
    }

}
