package edu.xjtu.soto.chap67;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public static boolean valid;

    public long strToInt(String str) {
        if (str == null || str.length() == 0) {
            valid = false;
            return 0;
        }
        //这里为long
        long num = 0;
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                if (str.charAt(i) == '+') {
                    isNegative = false;
                }
                if (str.charAt(i) == '-') {
                    isNegative = true;
                }

                continue;
            }
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                valid = false;
                return 0;
            }
            int flag = isNegative ? -1 : 1;
            num = num * 10 +  flag*(str.charAt(i) - '0');
            if (isNegative && num < Integer.MIN_VALUE || !isNegative && num > Integer.MAX_VALUE) {
                valid = false;
                return 0;
            }
        }
        valid = true;
        return num;
    }

    public static void main(String[] args) {
        StrToInt s = new StrToInt();
        System.out.println(s.strToInt("12"));
        System.out.println(s.strToInt("-12"));
        System.out.println(s.strToInt("+12"));
        System.out.println(s.strToInt("+")+ " "+ StrToInt.valid);
        System.out.println(s.strToInt("0")+ " "+ StrToInt.valid);
        System.out.println(s.strToInt("12345678901112")+ " "+ StrToInt.valid);
    }

}
