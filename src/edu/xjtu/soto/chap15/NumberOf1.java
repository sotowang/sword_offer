package edu.xjtu.soto.chap15;

/**
 * 题目:请实现一个函数，输入一个整数，输出该数二进制表示中1的个数，例如，把9表示成二进制是1001，有2位是1.因此，如果输入9，则该函数输出2.
 */
public class NumberOf1 {

    /**
     * 右移版本
     * @param num
     * @return
     */
    public static int numberOf1Right(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }

    /**
     * 左移版本
     * @param num
     * @return
     */
    public static int numberOf1Left(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;

    }

    /**
     * 更好的解法
     * @param num
     * @return
     */
    public static int numberOf1Best(int num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Right(9));
        System.out.println(numberOf1Left(0));
        System.out.println(numberOf1Best(-1));


    }
}
