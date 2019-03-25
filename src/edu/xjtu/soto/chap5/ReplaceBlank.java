package edu.xjtu.soto.chap5;

/**
 * 题目：请实现一个函数。把字符串中的每个空格替换成”％20“。例如，输入”We are happy“,则输出”We%20are%20happy“
 */
public class ReplaceBlank {
    /**
     * 使用Java内置函数
     * @param s
     * @return
     */
    public String replaceBlank1(StringBuffer s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        return s.toString().replace(" ", "%20");
    }


    /**
     * 从后往前扫描
     * @param s
     * @return
     */
    public String replaceBlank2(StringBuffer s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== ' ') {
                spaceNum++;
            }
        }
        int oldP = s.length() - 1;
        s.setLength(s.length() + 2 * spaceNum);
        int newP = s.length() - 1;
        while (oldP >= 0 && oldP != newP) {
            if (s.charAt(oldP) == ' ') {
                s.setCharAt(newP--, '0');
                s.setCharAt(newP--, '2');
                s.setCharAt(newP--, '%');
            } else {
                s.setCharAt(newP--, s.charAt(oldP));
            }
            oldP--;
        }
        return s.toString();
    }


    public static void main(String[] args) {
        ReplaceBlank replaceBlank = new ReplaceBlank();
        StringBuffer s = new StringBuffer("  We  are happy.  ");
        System.out.println(replaceBlank.replaceBlank1(s));
        System.out.println(replaceBlank.replaceBlank2(s));
    }
}
