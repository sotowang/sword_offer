package edu.xjtu.soto.chap17;

public class PrintToMaxOfNDigits {

    public static void printToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }

        while (stillIncrease(sb)) {
            print(sb);
        }
    }

    /**
     * 判断sb是否还能增加1
     * @param sb
     * @return
     */
    private static boolean stillIncrease(StringBuilder sb) {
        int len = sb.length();
        int token = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum = sb.charAt(i) - '0' + token;
            if (i == len - 1) {
                sum++;
            }
            if (sum == 10) {

                if (i == 0) {
                    return false;
                } else {
                    //进位
                    sb.setCharAt(i, '0');
                    token = 1;

                }
            } else {
                //没有进位
                sb.setCharAt(i, (char) (sum + '0'));

                //自增完退出
                return true;
            }

        }
        return false;
    }

    private static void print(StringBuilder sb) {
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;

            }
        }
        if (start < sb.length()) {
            System.out.println(sb.substring(start));
        }

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("010");
//        print(sb);

        printToMaxOfNDigits(1);

    }




}
