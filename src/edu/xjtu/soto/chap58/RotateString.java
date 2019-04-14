package edu.xjtu.soto.chap58;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *
 * 比如，输入字符串“abcdefg”和数字2，该函数将返回左旋转两位得到的结果"cdrfgab".
 */
public class RotateString {
    public String rotateString(String str, int n) {
        if (str == null || str.length() == 0 || str.length() < n) {
            return "";
        }
        char[] chars = str.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int low, int high) {

        while (low <= high) {
            char c = chars[high];
            chars[high] = chars[low];
            chars[low] = c;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        String res = rs.rotateString("abcdefg", 2);

        System.out.println(res);

    }
}
