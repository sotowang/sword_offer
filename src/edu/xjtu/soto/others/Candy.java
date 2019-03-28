package edu.xjtu.soto.others;
import java.util.Arrays;

/**
 * 有N个孩子站成一排，每个孩子有一个分值。给这些孩子派发糖果，需要满足如下需求：
 *
 * 1、每个孩子至少分到一个糖果
 *
 * 2、分值更高的孩子比他相邻位的孩子获得更多的糖果
 *
 * 求至少需要分发多少糖果？
 */
public class Candy {
    public static int candy(int[] scores, int[] candys) {
        if (scores == null || scores.length < 1 || candys.length < scores.length) {
            return 0;
        }
        if (scores.length == 1) {
            candys[0] = 1;
        }
        Arrays.fill(candys, 1);
        for (int i = 0; i < scores.length-1; i++) {
            if (scores[i] < scores[i + 1]) {
                candys[i+1]++;
            }
        }
        for (int i = scores.length - 1; i > 0; i--) {
            if (scores[i] < scores[i - 1] && candys[i] >= candys[i - 1]) {
                candys[i - 1] = candys[i] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < candys.length; i++) {
            sum += candys[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] scores1 = {1,2,2};
        int[] scores2 = {1,0,2};
        int[] candys = new int[scores1.length];

        int sum1 = candy(scores1, candys);
//        int sum2 = candy(scores2, candys);

        System.out.println(Arrays.toString(candys));
        System.out.println(sum1);
    }
}
