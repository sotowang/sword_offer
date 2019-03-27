package edu.xjtu.soto.chap10;

public class FrogJump {
    public static long fabonacci(long n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n < 1) {
            throw new RuntimeException("非法值");
        }
        long a = 1;
        long b = 2;
        long f = 0;
        for (int i = 3; i <= n; i++) {
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }


    public static void main(String[] args) {
        System.out.println(fabonacci(3));
        System.out.println(fabonacci(5));
        System.out.println(fabonacci(50));

    }
}
