package edu.xjtu.soto.chap38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
 */
public class Permutation3 {
    public static ArrayList<int[]> possibilitiesOfCube(int[] array) {
        ArrayList<int[]> list = new ArrayList<>();
        if (array == null || array.length != 8) {
            return list;
        }
        ArrayList<int[]> result = new ArrayList<>();

        permutation(array, 0, list);
        if (list.size() > 0) {
            for (int[] a : list) {
                if (check(a)) {
                    result.add(a);
                }
            }

        }
        return result;
    }

    private static void permutation(int[] array, int begin, ArrayList<int[]> result) {
        if (begin == array.length - 1) {
            if (!has(result, array)) {
                result.add(Arrays.copyOf(array, array.length));
                return;
            }
        }

        for (int i = begin; i < array.length; i++) {
            swap(array, i, begin);
            permutation(array, begin + 1, result);
            swap(array, i, begin);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * list中的数组是包含array
     *
     * @param list
     * @param array
     * @return
     */
    private static boolean has(ArrayList<int[]> list, int[] array) {
        for (int i = 0; i < list.size(); i++) {
            if (equal(list.get(i), array)) {
                return true;
            }
        }
        return false;
    }

    /**
     * array1是否与array2值相等
     *
     * @param array1
     * @param array2
     * @return
     */
    private static boolean equal(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断各边和是满足要求
     *
     * @param array
     * @return
     */
    private static boolean check(int[] array) {

        if (array[0] + array[1] + array[2] + array[3] == array[4] + array[5] + array[6] + array[7]
                && array[0] + array[2] + array[4] + array[6] == array[1] + array[3] + array[5] + array[7]
                && array[0] + array[1] + array[4] + array[5] == array[2] + array[3] + array[6] + array[7]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] A = {1,2,3,1,2,3,2,2};
        int[] B = {1,2,3,1,8,3,2,2};
        List<int[]> list = possibilitiesOfCube(B);
        System.out.println("有" + list.size() + "种可能");
        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
