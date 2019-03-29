package edu.xjtu.soto.chap38;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 例如：输入字符串abc，则打印出由字符a、b、c所能排列出来的甩有字符串abc、acb、bac、bca、cab和cba
 */
public class Permutation1 {


    public static ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        permutationCore(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;

    }

    private static void permutationCore(char[] chars,int begin, ArrayList<String> result) {
        if (begin == chars.length - 1) {
            String s = String.valueOf(chars);
            if (!result.contains(s)) {
                result.add(s);
                return;
            }
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            permutationCore(chars, begin + 1, result);
            //交换后再交换回来
            swap(chars, i, begin);
        }

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> result = permutation("abc");

        for (String s : result
        ) {
            System.out.println(s);

        }
    }
}
