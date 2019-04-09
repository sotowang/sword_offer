package edu.xjtu.soto.chap45;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打针能拼接出的所有数字中最小的一个。
 *
 * 例如，输入数组{3，32，321}，慢打印出这3个数字能排成最小数字321323。
 */
public class PrintMinNumber {
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int a : numbers) {
            list.add(a);
        }

        //a b 比较，小的排在前面
        list.sort((a, b) -> (a + "" + b).compareTo(b +a+ ""));
        StringBuilder sb = new StringBuilder();
        for (int a : list) {
            sb.append(a);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber pm = new PrintMinNumber();
        int[] nums = {3, 32, 321};
        String res = pm.printMinNumber(nums);
        System.out.println(res);

    }
}
