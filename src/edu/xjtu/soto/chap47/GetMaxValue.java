package edu.xjtu.soto.chap47;

/**
 * 题目：在一个mxn的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class GetMaxValue {
    /**
     * 使用递归求解
     * @param gifts
     * @return
     */
    public int getMaxValue1(int[][] gifts) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }
        int rows = gifts.length;
        int cols = gifts[0].length;
        int[] max = {0};
        select(gifts, 0, 0, max,rows,cols,0);
        return max[0];
    }

    private void select(int[][] gifts, int row, int col,int[] max,int rows, int cols,int val) {
        if (row >= rows || col >= cols) {
            return;
        }
        val += gifts[row][col];
        if (row == rows - 1 && col == cols - 1) {
            if (val > max[0]) {
                max[0] = val;
            }
        }
        select(gifts, row + 1, col, max, rows, cols, val);
        select(gifts, row , col+1, max, rows, cols, val);

    }

    /**
     * 动态规划求解
     * @param gifts
     * @return
     */
    public int getMaxValue2(int[][] gifts) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }
        int rows = gifts.length;
        int cols = gifts[0].length;

        int[][] max = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int left = 0;
                int up = 0;

                if (row > 0) {
                    up = max[row - 1][col];
                }
                if (col > 0) {
                    left = max[row][col - 1];
                }
                max[row][col] = Math.max(up, left) + gifts[row][col];
            }
        }
        return max[rows - 1][cols - 1];
    }

    /**
     * 上述方法优化，用一维数组代替二维数组
     * @param gifts
     * @return
     */
    public int betterGetMaxVal(int[][] gifts) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }
        int rows = gifts.length;
        int cols = gifts[0].length;
        int[] maxVal = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int left = 0;
                int up = 0;
                if (row > 0) up = maxVal[col];
                if (col > 0) left = maxVal[col -1];
                maxVal[col] = Math.max(up, left) + gifts[row][col];
            }
        }
        return maxVal[cols-1];
    }


    public static void main(String[] args) {
        GetMaxValue gmv = new GetMaxValue();

        int[][] gifts = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int res1 = gmv.getMaxValue1(gifts);
        System.out.println(res1);
        int res2 = gmv.getMaxValue2(gifts);
        System.out.println(res2);
        int res3 = gmv.betterGetMaxVal(gifts);
        System.out.println(res3);

    }
}
