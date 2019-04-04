package edu.xjtu.soto.chap29;

import java.util.ArrayList;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class PrintMatrix {

    private ArrayList<Integer> list = new ArrayList<>();
    public void printMatrixClockwisely(int[][] numbers, int columns, int rows) {
        if (numbers == null || columns <= 0 || rows <= 0) {
            return;
        }
        int start = 0;

        while (columns > start * 2 && rows > start * 2) {
            PrintMatrixInCircle(numbers, columns, rows, start);
            ++start;
        }
    }

    private void PrintMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = numbers[start][i];
            list.add(number);
        }

        //从上到下打印一列
        if (start < endY) {
            for (int i = start+1; i <= endY ; i++) {
                int number = numbers[i][endX];
                list.add(number);
            }
        }

        //从历到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = numbers[endY][i];
                list.add(number);
            }
        }

        //从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = numbers[i][start];
                list.add(number);
            }
        }


    }

    public static void main(String[] args) {
        PrintMatrix pm = new PrintMatrix();
        int[][] numbers1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] numbers2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        pm.printMatrixClockwisely(numbers1, 4, 4);
        System.out.println(pm.list);
        pm.list.clear();
        pm.printMatrixClockwisely(numbers2, 5, 5);
        System.out.println(pm.list);
    }

}
