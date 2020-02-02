package edu.xjtu.soto.chap62.约瑟夫环;

import java.util.LinkedList;

/**
 * @auther: sotowang
 * @date: 2020/2/2 21:16
 */
public class LastInCircle {
    public int lastIncircle(int n, int m) {
        if (m < 1 || n < 1) {
            return -1;
        }
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int cur = 0;
        while (n != 1) {
            cur = (cur + m - 1) % n;
            circle.remove(cur);
            n--;
        }
        return circle.get(0);
    }

    public static void main(String[] args) {
        assert new LastInCircle().lastIncircle(5, 3) == 3;
    }
}
