package edu.xjtu.soto.chap4;

/**
 * 利用二维数组的特性缩小查找范围
 * 由于矩阵从上到下递增，从左到右递增。
 *  总是和二维矩阵的右上角元素比较（对称地，左下角也可以）
 *  如果目标比右上角的大，删除该行，行指针向下移动；如果比右上角的小，删除该列，列指针左移
 */
public class Find2 {


    public boolean find2(int[][] arrays, int target) {
        if (arrays == null || arrays.length <= 0) {
            return false;
        }

        int row = 0;
        int rows = arrays.length;
        int cols = arrays[0].length-1;

        while (row < rows && cols >= 0) {
            if (arrays[row][cols] > target) {
                cols--;
            }else if (arrays[row][cols] <target) {
                row++;
            } else{
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Find2 find2 = new Find2();

        System.out.println(find2.find2(arrays, -1));

    }

}
