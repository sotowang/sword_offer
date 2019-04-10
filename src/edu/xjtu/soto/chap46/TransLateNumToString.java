package edu.xjtu.soto.chap46;

/**
 * 题目：给定一个数字，我们按照如下地铡把它翻译为字符串：0翻译成”a“，1管充成”b“，......，11翻译成”l“。25秒充成”z“。一个数字可能有多个翻译。
 * 例如，12258有5种不同的翻译，分别是”bccfi“，”bwfi“，bczi”，“mcfi”，“mzi”。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class TransLateNumToString {
    public int transLateNumToString(int n) {
        if (n < 0) {
            return 0;
        }
        return count(String.valueOf(n));
    }

    private int count(String num) {
        int len = num.length();
        int[] counts = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int count = 0;
            if (i < len - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }

            if (i < len - 1) {
                int digit1 = num.charAt(i)-'0';
                int digit2 = num.charAt(i + 1)-'0';
                int convertD = digit1 * 10 + digit2;
                if (convertD >= 10 && convertD <= 25) {
                    if (i < len - 2) {
                        count += counts[i + 2];
                    } else {
                        count++;
                    }
                }

            }
            counts[i] = count;
        }
        return counts[0];

    }

    public static void main(String[] args) {

        TransLateNumToString ts = new TransLateNumToString();
        System.out.println(ts.transLateNumToString(12258));

    }
}
