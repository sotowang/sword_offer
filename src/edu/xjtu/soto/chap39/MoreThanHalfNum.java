package edu.xjtu.soto.chap39;

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出为个数字。
 */
public class MoreThanHalfNum {

    /**
     * 基于数组的特点，时间复杂度o(n)
     * @param nums
     * @return
     */
    public int moreThanHalfNum1(int[] nums) {
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

        return check(nums, result) ? result : 0;

    }

    private boolean check(int[] nums, int result) {
        int count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            }
        }
        return count > nums.length / 2;
    }

    /**
     * 使用快速排序思想，切分法。时间复杂度o(n)
     * @param nums
     * @return
     */
    public int moreThanHalfNum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = nums.length / 2;
        int low = 0;
        int high = nums.length - 1;
        while (high > low) {
            int j = partition(nums, low, high);
            if (j == k) {
                return nums[k];
            } else if (j < k) {
                low = j + 1;
            } else {
                high = j - 1;
            }
        }

        //检查
        return check(nums, nums[k]) ? nums[k] : 0;
    }

    /**
     * 快速排序切分
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;

        if (i < j) {
            int piv = nums[low];
            while (i < j) {
                while (nums[j] > piv) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                while (nums[i] < piv) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = piv;
        }
        return i;

    }

    public static void main(String[] args) {
        MoreThanHalfNum mthn = new MoreThanHalfNum();

        int[] nums1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int[] nums2 = {1,2};

        System.out.println(mthn.moreThanHalfNum2(nums1));
        System.out.println(mthn.moreThanHalfNum2(nums2));

        System.out.println("**********");
        System.out.println(mthn.moreThanHalfNum1(nums1));
        System.out.println(mthn.moreThanHalfNum1(nums2));
    }
}
