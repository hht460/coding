package org.hthu.pattern;

/**
 * 懒汉式
 */
public class LazySingleton {

    // volatile修饰
    private static volatile LazySingleton instance;

    private LazySingleton() {}

    // 双重if校验
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
