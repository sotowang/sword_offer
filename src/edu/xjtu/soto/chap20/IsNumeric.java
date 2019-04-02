package edu.xjtu.soto.chap20;

/**
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数），
 * 例如，字符串“+100”，“5e2”，“-123”，“3.1416”及“-1E-16”都表示数值，但"12e"，"1a3.14"，“1.2.3”，“+-5”及“12e+5.4”都不是。
 */
public class IsNumeric {
    /**
     * 正则表达式匹配
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[\\+\\-]?[0-9]*(\\.[0-9]+)?([Ee][\\+\\-]?[0-9]+)?");
    }

    public static void main(String[] args) {
        boolean b = isNumeric("5e.-2");
        System.out.println(b);
    }
}
