package org.hthu.pattern;

/**
 * 饿汉式
 */
public class HungrySingleton {

    private final static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}
