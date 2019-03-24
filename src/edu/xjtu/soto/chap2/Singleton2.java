package edu.xjtu.soto.chap2;
/**
 * 设计一个类，只能生成该类的一个实例
 */

/**
 * 通常写法
 */
public class Singleton2 {
    private Singleton2() {

    }

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }


    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();

        if (s1 == s2) {
            System.out.println("是相同实例");

        } else {
            System.out.println("不是相同实例");
        }
    }

}
