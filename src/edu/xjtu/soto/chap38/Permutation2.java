package edu.xjtu.soto.chap38;

import java.util.ArrayList;

/**
 * 字符串的组合
 */
public class Permutation2 {
    public static ArrayList<String> permutation2(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            permutationCore(str, i,sb, result);
        }

        return result;
    }

    private static void permutationCore(String str, int num, StringBuilder sb ,ArrayList<String> list) {
        if (num == 0) {
            if (!list.contains(sb.toString())) {
                list.add(sb.toString());
                return;
            }
        }
        if (str.length() == 0) {
            return;
        }
        // 公式C(n, m) = C(n-1, m-1)+ C(n-1, m)
        // 第一个字符是组合中的第一个字符，在剩下的n-1个字符中选m-1个字符
        sb.append(str.charAt(0));  //选中第一个字符
        permutationCore(str.substring(1), num - 1, sb, list);


        // 第一个字符不是组合中的第一个字符，在剩下的n-1个字符中选m个字符
        sb.deleteCharAt(sb.length() - 1);
        permutationCore(str.substring(1), num, sb, list);


    }

    public static void main(String[] args) {
        ArrayList list1 = permutation2("abc");
        System.out.println(list1);
        ArrayList list2 = permutation2("abcca");
        System.out.println(list2);
    }
}
