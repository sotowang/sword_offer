package edu.xjtu.soto.chap49;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNum {

    public int getUglyNum(int num) {
        if (num <= 0) {
            return 0;
        }
        int[] res = new int[num];
        res[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        for (int i = 1; i < num; i++) {
            int m2 = res[t2] * 2;
            int m3 = res[t3] * 3;
            int m5 = res[t5] * 5;

            res[i] = Math.min(m2, Math.min(m3, m5));
            if (res[i] == m2) {
                t2++;
            }
            if (res[i] == m3) {
                t3++;
            }
            if (res[i] == m5) {
                t5++;
            }

        }
        return res[num - 1];
    }


    public static void main(String[] args) {
        GetUglyNum getUglyNum = new GetUglyNum();
        int res = getUglyNum.getUglyNum(7);
        System.out.println(res);

    }

}
