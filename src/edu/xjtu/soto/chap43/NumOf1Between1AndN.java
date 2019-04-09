package edu.xjtu.soto.chap43;

/**
 * 题目：输入一个整数n，求1-n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1-12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
 */
public class NumOf1Between1AndN {

    /**
     * 使用StringBuilder拼接
     * @param n
     * @return
     */
    public int numberOf1Between1AndN1(int n) {
        n = Math.abs(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i );
        }
        int count = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param n
     * @return
     */
    public int numberOf1Between1AndN2(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            if (a % 10 == 0) {
                ones += a / 10 * m;
            } else if (a % 10 == 1) {
                ones += (a / 10 * m) + (b + 1);
            }else {
                ones += (a / 10 + 1) * m;
            }
        }
        return ones;
    }

    public static void main(String[] args) {
        NumOf1Between1AndN nob1 = new NumOf1Between1AndN();
        int res = nob1.numberOf1Between1AndN1(21235);
        System.out.println(res);
        int res2 = nob1.numberOf1Between1AndN2(21235);
        System.out.println(res2);

    }
}
