package edu.xjtu.soto.chap57;

import java.util.ArrayList;

/**
 *输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 *
 * 例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15,所以打印出3个连续序列1-5，4-6和7-8.
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 1) {
            return res;
        }
        int mid = (sum + 1) / 2;

        int low = 1;
        int high = 2;
        int curSum = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        while (high <= mid) {
            curSum = (low + high) * (high - low + 1) / 2;
            if (curSum == sum) {
                for (int i = low; i <= high; i++) {
                    temp.add(i);
                }
                res.add(new ArrayList<>(temp));
                temp.clear();
                low++;
                high = low + 1;
            } else if (curSum < sum) {
                high++;
            } else {
                low++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindContinuousSequence f = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> res = f.findContinuousSequence(9);

        System.out.println(res);
    }
}
