package edu.xjtu.soto.chap19;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    private static boolean matchCore(char[] str, char[] pattern, int s, int p) {
        if (s == str.length && p == pattern.length) {
            return true;
        }

        //模式串到头 ，文本串未到头 匹配失败
        if (p == pattern.length && s < str.length) {
            return false;
        }

        // 两种情况，1、模式和文本都没有到结尾
        // 2、或者文本到了结尾而模式还没有到结尾，此时肯定会调用else分支
        // 第二个字符是*
        if (p < pattern.length - 1 && pattern[p + 1] == '*') {
            if (s < str.length && str[s] == pattern[p] || (pattern[p] == '.' && s < str.length)) {
                return matchCore(str, pattern, s, p + 2) ||
                        matchCore(str, pattern, s + 1, p + 2) ||
                        matchCore(str, pattern, s + 1, p);
            }else {
                return matchCore(str, pattern, s, p + 2);
            }
        }

        //第二个字符不是*
        if ((s < str.length && str[s] == pattern[p]) || (pattern[p] == '.' && s < str.length)) {
            return matchCore(str, pattern, s + 1, p + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = match("aaa".toCharArray(), "a.a".toCharArray());
        System.out.println(b);
    }
}
