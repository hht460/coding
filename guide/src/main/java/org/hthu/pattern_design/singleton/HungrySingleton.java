package org.hthu.pattern_design.singleton;

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
