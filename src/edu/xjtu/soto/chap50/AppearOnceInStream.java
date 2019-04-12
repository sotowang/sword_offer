package edu.xjtu.soto.chap50;


import java.util.Arrays;

/**
 * 字符流中第一个只出现一次的字符。
 * 这次字符串是动态变化的了，比如现在只从字符流中读取了两个字符为"go"那么字符流中第一个只出现一次的字符是'g'，
 * 等到从字符流中读取了前6个字符"google"时，第一个只出现一次的字符变成了'l'.
 */
public class AppearOnceInStream {

    private int[] count = new int[256];
    private int index = 0;

    public AppearOnceInStream() {
        Arrays.fill(count, -1);
    }
    public void insert(char c) {
        if (count[c] == -1) {
            count[c] = index;
        } else if (count[c] >= 0) {
            count[c] = -2;
        }
        index++;
    }

    public char appearOnceInStream() {
        int min = Integer.MAX_VALUE;
        char c = '\0';
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 0 && count[i] < min) {
                min = count[i];
                c = (char) i;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        AppearOnceInStream appearOnceInStream = new AppearOnceInStream();
        appearOnceInStream.insert('g');
        appearOnceInStream.insert('o');
        System.out.println(appearOnceInStream.appearOnceInStream());
        appearOnceInStream.insert('o');
        appearOnceInStream.insert('g');
        appearOnceInStream.insert('l');
        appearOnceInStream.insert('e');
        System.out.println(appearOnceInStream.appearOnceInStream());

    }
}
