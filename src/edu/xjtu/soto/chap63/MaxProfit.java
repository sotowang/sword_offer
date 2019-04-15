package edu.xjtu.soto.chap63;

/**
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}.如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11.
 */
public class MaxProfit {
    public int maxProfit(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int minPrice = array[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - minPrice > maxProfit) {
                maxProfit = array[i] - minPrice;
            }
            if (array[i] < minPrice) {
                minPrice = array[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] array = {9, 11, 8, 5, 7, 12, 16, 14};

        System.out.println(maxProfit.maxProfit(array));
    }

}
