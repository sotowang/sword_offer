package edu.xjtu.soto.chap15;

public class PowOf2 {
    public static boolean powOf2(int n) {
        return ((n - 1) & n) == 0;
    }

    public static void main(String[] args) {
        System.out.println(powOf2(6));
    }
}
