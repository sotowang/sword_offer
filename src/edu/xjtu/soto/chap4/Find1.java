package edu.xjtu.soto.chap4;

/**
 * 使用二分法查找二维数组中的数字
 */
public class Find1 {

    /**
     * 对每一行的一维数组作二分查找.
     *如果矩阵是M*N的，一次二分查找是O(lg N), M行就是O(Mlg N)
     * @param arrays
     * @param target
     * @return
     */
    public boolean find(int[][] arrays, int target) {
        if (arrays == null || arrays.length <= 0) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int low = 0;
            int high = arrays[i].length - 1;
            int mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (arrays[i][mid] > target) {
                    high = mid - 1;
                } else if (arrays[i][mid] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Find1 find1 = new Find1();

        System.out.println(find1.find(arrays, 17));

    }

}
