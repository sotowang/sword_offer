package edu.xjtu.soto.chap48;

import java.util.Arrays;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'之间的字符，例如在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4
 */
public class LongestSubstring {
    public int longestSubString(String string) {
        int[] position = new int[26];
        Arrays.fill(position, -1);

        int p = 0;
        int max = 0;


        for (int i = 0; i < string.length(); i++) {
            int pre = position[string.charAt(i) - 'a'];
            if (pre == -1 || i - pre > p) {
                p++;
            } else {
                p = i-pre;
            }
            position[string.charAt(i) - 'a'] = i;
            if (max < p) {
                max = p;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
//        int max1 = longestSubstring.longestSubString("bdcefgc");
        int max2 = longestSubstring.longestSubString("erabcdabr");
        int max3 = longestSubstring.longestSubString("a");

//        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
    }
}
