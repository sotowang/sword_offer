package edu.xjtu.soto.chap11;


import java.util.Arrays;

/**
 * 题目：请实现一个排序算法，要求时间效率为O（n）
 *
 * 对公司所有员工的年龄排序，公司员工人数几万，可以使用辅助空间
 */
public class AgeSort {


    public static void ageSort(int[] ages) {

        if (ages == null) {
            return;
        }
        int[] temp = new int[101];
        for (int i = 0; i < ages.length; i++) {
            temp[ages[i]]++;
        }
        int index = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j < temp[i]; j++) {
                ages[index++] = i;
            }
        }


    }

    public static void main(String[] args) {
        int[] ages = {23, 50, 23, 17, 18, 18, 20};

        ageSort(ages);

        System.out.println(Arrays.toString(ages));


    }



}
