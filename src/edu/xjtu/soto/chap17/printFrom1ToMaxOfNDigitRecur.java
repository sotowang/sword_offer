package edu.xjtu.soto.chap17;

public class printFrom1ToMaxOfNDigitRecur {
    public static void printFrom1ToMaxOfNDigitRecur(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }

        printRecur(sb, n, -1);


    }

    private static void printRecur(StringBuilder sb, int len, int index) {
        if (index == len - 1) {
            print(sb);
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.setCharAt(index+1, (char) (i + '0'));
            printRecur(sb,len,index+1);
        }


    }

    private static void print(StringBuilder sb) {
        int start = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;

            }
        }
        if (start < sb.length()) {
            System.out.println(sb.substring(start));
        }

    }

    public static void main(String[] args) {
        printFrom1ToMaxOfNDigitRecur(2);
    }


}
