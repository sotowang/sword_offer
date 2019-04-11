package edu.xjtu.soto.chap50;

/**
 * 题目一：字符串中第一个只出现一次的字符
 *
 * 在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”，则输出’b‘
 */
public class FirstNotReoeatingChar {
    public char firstNotRepeatingChar(String string) {
        if (string == null || string.length() == 0) {
            return '\0';
        }
        int count[] = new int[256];
        for (int i = 0; i < string.length(); i++) {
            count[string.charAt(i)]++;
        }

        for (int i = 0; i < string.length(); i++) {
            if (count[string.charAt(i)] == 1) {
                return string.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        FirstNotReoeatingChar firstNotReoeatingChar = new FirstNotReoeatingChar();
        char res1 = firstNotReoeatingChar.firstNotRepeatingChar(null);
        System.out.println(res1);

        char res2 = firstNotReoeatingChar.firstNotRepeatingChar("abaccdeff");
        System.out.println(res2);

    }
}
