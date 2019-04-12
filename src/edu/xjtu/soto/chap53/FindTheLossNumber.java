package edu.xjtu.soto.chap53;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并覓每个数字都在范围0-n-1之内，
 * 在范围0-n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class FindTheLossNumber {
    public int findTheLossNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] == mid) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] == mid - 1) {
                    return mid;
                }
                high = mid - 1;
            }

        }

        if (low == array.length) return array.length;
        //  无效的输入数组，如不是递增排序，或者有的数字超出了0~n-1的范围
        return -1;
    }

    public static void main(String[] args) {
        FindTheLossNumber f = new FindTheLossNumber();
        int[] array1 = {0, 1, 2, 3, 5, 6, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int res1 = f.findTheLossNumber(array1);
        int res2 = f.findTheLossNumber(array2);


        System.out.println(res1);
        System.out.println(res2);
    }
}
