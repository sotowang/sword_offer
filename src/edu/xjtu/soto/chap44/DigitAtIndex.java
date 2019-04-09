package edu.xjtu.soto.chap44;

/**
 * 题目： 数字以0123456789101112131415... 的格式序列化得到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数，求任意第n位对应的数字。
 */
public class DigitAtIndex {
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        //位数，digits = 1；表示一位数，0-9区间；digjts = 2表示两位数，10-99区间...
        int digits = 1;
        while (true) {
            int numbers = numOfRange(digits);
            //范围锁定，numbers*digits表示该区间共有多少位数字，如digits = 2，范围10-99 有 2*90=80位
            if (index < numbers * digits) {
                return digitAt2(index, digits);
            }

            //缩小范围
            index -= numbers * digits;
            digits++;
        }
    }

    /**
     * 根据位数得到范围内的个数，比如1位，0-9共10个
     * 2位，10-99共90个
     * 3们，100-999 共900个
     * @param n
     * @return
     */
    private int numOfRange(int n) {
        if (n == 1) {
            return 10;
        }
        return (int)(9 * Math.pow(10, n - 1));
    }

    /**
     * n位数范围内的的第一个数，比如1位数，0~9，第一个是0
     * 3位数，100~199，第一个数是100
     * @param n
     * @return
     */
    private int beginNumber(int n) {
        if (n == 1) {
            return 0;
        }
        return (int) Math.pow(10, n-1);
    }

    /**
     * 返回某数的第d位，第0位是个位，第1位是十位
     * @param value
     * @param d
     * @return
     */
    private int digitAt(int value, int d) {
        return (value/(int)Math.pow(10,d))% 10;
    }

    /**
     * 锁定范围后，根据位数就能得到包含index处那位数的数字，然后从该数中找到要求的那位
     * @param seqIndex
     * @param digits
     * @return
     */
    private int digitAt2(int seqIndex, int digits) {
        int number = beginNumber(digits) + seqIndex / digits;
        return digitAt(number, digits - seqIndex % digits - 1);
    }


    public static void main(String[] args) {
        DigitAtIndex a = new DigitAtIndex();
        System.out.println(a.digitAtIndex(1001));

    }

}
