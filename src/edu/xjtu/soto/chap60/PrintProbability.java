package edu.xjtu.soto.chap60;

/**
 * 把n个骰子扔在地上，所有骰子朝上的一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 */
public class PrintProbability {

    public void printProbability(int n) {
        if (n < 1) {
            return;
        }
        int maxVal = 6 * n;
        int[] p = new int[maxVal - n + 1];
        getProbabilities(n, n, 0, p);
        int total = (int) Math.pow(6, n);

        for (int i = n; i <= maxVal; i++) {
            System.out.println("s=" + i + ": " + p[i - n] + "/" + total);
        }
    }
    private void getProbabilities(int n, int cur, int sum, int[] p) {
        if (cur == 0) {
            p[sum - n]++;
        } else {
            for (int i = 1; i <= 6; i++) {
                getProbabilities(n, cur-1, sum+i, p);
            }
        }
    }

    public static void main(String[] args) {
        PrintProbability p = new PrintProbability();
        p.printProbability(3);

    }


}
