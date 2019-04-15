package edu.xjtu.soto.chap62;

import java.util.LinkedList;

/**
 * 0, 1, 2...,n - 1这n个数字排成一个圆圈，一开始从数字0开始，从这个圆圈里删除第m个数字；
 * 然后从被删除的数字后一位开始计数，继续删除第m个数字...重复这个过程，直到最后只剩一个数字为止。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class LastInCircle {
    public int lastIncircle(int n,int m) {
        if (m <= 0 || n <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (m - 1 + index) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);

    }

    /**
     * 数学规律：约瑟夫环问题
     */
    public int lastNumInCycle2(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (f + m) % i;
        }
        return f;
    }

    public static void main(String[] args) {
        LastInCircle f = new LastInCircle();
        int res = f.lastIncircle(5, 3);
        System.out.println(res);
        System.out.println(f.lastNumInCycle2(5, 3));
    }
}
