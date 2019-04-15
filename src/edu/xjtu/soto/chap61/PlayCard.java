package edu.xjtu.soto.chap61;

import java.util.Arrays;

public class PlayCard {
    public boolean isContinue1(int[] array) {
        if (array == null || array.length != 5) {
            return false;
        }
        Arrays.sort(array);

        int joker = 0;
        //统计0的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                joker++;
            }
        }

        int gap = 0;
        //统计gap
        for (int i = array.length - 1; i > joker; i--) {
            if (array[i] == array[i - 1]) {
                return false;
            }
            gap += array[i] - array[i - 1] - 1;
        }

        return gap <= joker;
    }

    /**
     * 利用顺子本身规律
     * @param array
     * @return
     */
    public boolean isContinue2(int[] array) {
        if (array == null || array.length != 5) {
            return false;
        }

        int[] count = new int[14];
        int max = -1;
        int min = 14;
        for (int number : array) {
            count[number]++;

            //对除了0之外的其他数将运算最大值最小值
            if (number != 0) {
                if (count[number] > 1) {
                    return false;
                }

                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }

            //如果没有0，最大最小值之差为4，有0还能凑成顺子的，差值小于4；大于4肯定不能凑成顺子
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        PlayCard playCard = new PlayCard();
        int[] array = {0, 2, 5, 6, 7};
        boolean b = playCard.isContinue1(array);
        System.out.println(b);
        System.out.println(playCard.isContinue2(array));

    }
}
