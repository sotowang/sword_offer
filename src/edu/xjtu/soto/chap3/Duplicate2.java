package edu.xjtu.soto.chap3;

/**
 * 在一个长度为n+1的数组里的所有数字都在1-n 的范围内，所以数组中至少有一个数字是重复的，请找出数组中任意一个重复的数字，但不能修改输入的数组。
 *
 *  例如：如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出重复数字为2或3
 */
public class Duplicate2 {

    /**
     * 可以创建一个长度为n+1的辅助数组，然后逐一把原数组的每个数字复制到辅助数组。如果原数组中被复制的数字是m
     * 则把它复制到辅助数组中下标为m的位置。这样就很容易发现哪个数字是重复的，由于需要创建一个数组，该方案需要O（n）的辅助空间
     *
     * @return
     */
    public int duplicate(int[] arrays, int length, int[] duplicate) {
        if (arrays == null || arrays.length <= 0 || length != arrays.length) {
            return 0;
        }
        for (int i = 1; i < length ; i++) {
            if (arrays[i] < 1 || arrays[i] > length - 1) {
                return 0;
            }


        }
        for (int i = 1; i < length; i++) {
            if (arrays[i] == duplicate[arrays[i]]) {
                return arrays[i];
            }
            duplicate[arrays[i]] = arrays[i];
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] arrays = {2, 3, 5, 4, 3, 2, 6, 7};
        Duplicate2 duplicate2 = new Duplicate2();
        int[] dup = new int[arrays.length];
        int a = duplicate2.duplicate(arrays, 8, dup);
        System.out.println(a);

    }
}
