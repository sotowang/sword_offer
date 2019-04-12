package edu.xjtu.soto.chap53;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 例如，输入排序数组{1，2，3，3，3，3，4，5}和烃字3.由于3在这个数组中出现了4次，因此输出4
 */
public class GetNumOfK {

    public int getNumOfK(int[] array,int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int first = getFirstOfK(array, k, 0, array.length - 1);
        int last = getLastOfK(array, k, 0, array.length - 1);
        if (first != -1 && last != -1) {
            return last - first + 1;
        }
        return -1;

    }

    private int getLastOfK(int[] array, int k, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == array.length-1 || array[mid + 1] != k) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;

    }

    private int getFirstOfK(int[] array, int k, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 更巧妙的二分法
     *
     * @param
     */
    private int rank(int[] array, double k) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (k > array[mid]) {
                low = mid + 1;
            } else if (k < array[mid]) {
                high = mid - 1;
            }
        }
        return low;
    }

    public int getNumberOfK2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return rank(array, k + 0.5) - rank(array, k - 0.5);
    }

    public static void main(String[] args) {
        GetNumOfK getNumOfK = new GetNumOfK();
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int res = getNumOfK.getNumOfK(array, 3);
        System.out.println(res);


        System.out.println(getNumOfK.getNumberOfK2(array,3));


        


    }

}
