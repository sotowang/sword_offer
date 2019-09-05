package edu.xjtu.soto.chap2;

/**
 * 懒汉式单例模式
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static volatile LazySingleton instance;

    //DCL
    public static LazySingleton getInstance() {
        if (null == instance) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (null == instance) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
