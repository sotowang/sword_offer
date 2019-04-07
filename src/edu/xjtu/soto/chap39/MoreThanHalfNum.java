package edu.xjtu.soto.chap39;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出为个数字。
 */
public class MoreThanHalfNum {
    public int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //计数器
        int count = 0;

        //表示当前数字
        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            }else {
                count--;
                if (count == 0) {
                    count++;
                    result = nums[i];
                }
            }
        }

        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            }
        }

        return count > nums.length / 2 ? result : 0;

    }

    public static void main(String[] args) {
        MoreThanHalfNum mthn = new MoreThanHalfNum();

        int[] nums1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int[] nums2 = {1,2};

        System.out.println(mthn.moreThanHalfNum(nums1));
        System.out.println(mthn.moreThanHalfNum(nums2));
    }
}
