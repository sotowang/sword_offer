package edu.xjtu.soto.chap2;

/**
 * 饿汉式单例
 */
public class EagerSingleton {

    //类加载时先New一个出来
    private static EagerSingleton eagerSingleton = new EagerSingleton();
    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }

    public static void main(String[] args) {
        EagerSingleton s1 = EagerSingleton.getInstance();
        EagerSingleton s2 = EagerSingleton.getInstance();

        System.out.println(s1 == s2);

    }

}
