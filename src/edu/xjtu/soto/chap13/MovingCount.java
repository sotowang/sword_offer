package edu.xjtu.soto.chap13;

public class MovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean marked[] = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, marked);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] marked) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, marked)) {
            marked[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, marked)
                    + movingCountCore(threshold, rows, cols, row + 1, col, marked)
                    + movingCountCore(threshold, rows, cols, row, col - 1, marked)
                    + movingCountCore(threshold, rows, cols, row, col + 1, marked);
        }


        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] marked) {
        if (row >= 0 && row< rows && col>=0 && col<cols && getDigitSum(row) + getDigitSum(col) <= threshold
        && !marked[row*cols+col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
//        int count1 = movingCount(2, 3, 4);
        int count2 = movingCount(1, 1, 0);
//        System.out.println(count1);
        System.out.println(count2);
    }

}
