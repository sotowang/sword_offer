package edu.xjtu.soto.chap3;

import java.util.Arrays;

/**
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次，请找出数组中任意一个重复的数字.
 *
 * 例如：如果输入长度为7的数组{2,3,1,0,2,5,3}那么对应的输出是重复的数字2或者3
 */
public class Duplicate1 {

    /**
     * 1,通过数组排序
     */
    public Boolean duplicate1(int[] arrays,int length,int[] duplicate) {
        if (arrays == null || arrays.length != length || length == 0  ) {
            return false;
        }
        Arrays.sort(arrays);
        for (int i = 0; i < arrays.length - 1; i++) {
            if (arrays[i] == arrays[i + 1]) {
                duplicate[0] = arrays[i];
                return true;
            }
        }

        return false;
    }


    /**
     * 推荐的做法，通过交换元素，将值i保存到numbers[i]
     *  在numbers[i]不和i相等时，如果numbers[i]和numbers[numbers[i]]相等就说明重复元素；
     *  否则就交换这两个元素，这个过程相当于排序。举个例子，通过交换将2放入numbers[2]。
     * @param arrays
     * @param length
     * @param duplicate
     * @return
     */
    public Boolean duplicate2(int[] arrays, int length, int[] duplicate) {
        if (arrays == null || arrays.length != length || length == 0  ) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (arrays[i] < 0 || arrays[i] > length-1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (i != arrays[i]) {
                if (arrays[arrays[i]] == arrays[i]) {
                    duplicate[0] = arrays[i];
                    return true;
                }
                swap(arrays, i, arrays[i]);
            }

        }



        return false;
    }

    private void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }


    public static void main(String[] args) {
        int[] arrays1 = {2, 3, 1, 0, 2, 5, 3};
        int[] arrays2 = null;
        int[] arrays3 = {2, 3, 1, 0, 2, 7, 3};
        Duplicate1 duplicate = new Duplicate1();
        int legnth = 7;
        int[] a = new int[7];
//        duplicate.duplicate1(arrays2, legnth, a);
        duplicate.duplicate2(arrays3, legnth, a);
        System.out.println(a[0]);

    }
}
