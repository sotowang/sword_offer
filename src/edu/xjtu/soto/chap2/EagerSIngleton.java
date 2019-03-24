package edu.xjtu.soto.chap2;

/**
 * 饿汉式单例
 */
public class EagerSIngleton {

    //类加载时先New一个出来
    private static EagerSIngleton eagerSIngleton = new EagerSIngleton();
    private EagerSIngleton() {

    }

    public static EagerSIngleton getInstance() {
        return eagerSIngleton;
    }

    public static void main(String[] args) {
        EagerSIngleton s1 = EagerSIngleton.getInstance();
        EagerSIngleton s2 = EagerSIngleton.getInstance();

        System.out.println(s1 == s2);

    }

}
