package edu.xjtu.soto.chap53;

/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的，请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。
 * <p>
 * 例如，在数组{-3,-1,1,3,5}中，数字3和它的下标相等。
 */
public class FindValEqualsIndex {
    public int findValEqualsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int high = array.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == mid) {
                return mid;
            } else if (mid > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindValEqualsIndex f = new FindValEqualsIndex();

        int[] array = {-3, -1, 1, 3, 5};
        int index = f.findValEqualsIndex(array);
        System.out.println(index);

    }

}
