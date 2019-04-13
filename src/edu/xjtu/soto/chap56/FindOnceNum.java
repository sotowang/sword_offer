package edu.xjtu.soto.chap56;

/**
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class FindOnceNum {
    public int findOnceNum(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Input Error");
        }

        int[] res = new int[32];

        int bit = 1;

        for (int i = 31; i >= 0; i--) {
            for (int num : array) {
                //第i位不为1
                if ((num & bit) != 0) {
                    res[i]++;
                }
            }
            bit = bit << 1;
        }

        int num = 0;
        // 转换成十进制时，从最高位开始，从由左至右第一个不为0的位开始
        for (int i = 0; i <32; i++) {
            num = num << 1;
            num += res[i] % 3;
        }
        return num;
    }

    public static void main(String[] args) {
        FindOnceNum f = new FindOnceNum();
        int[] array = {3, 3, 3, 6};

        int res = f.findOnceNum(array);
        System.out.println(res);
    }
}
