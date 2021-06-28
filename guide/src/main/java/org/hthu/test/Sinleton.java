package org.hthu.test;

/**
 * 单例模式获取 处理类
 */
public class Sinleton {

    // volatile修饰 防止指令重排序
    private static volatile MasStringTool masStringTool;

    private Sinleton(){}

    // 双重if校验, 获取单例实例对象
    public static MasStringTool getMasStringTool() {
        if (masStringTool == null) {
            synchronized (Sinleton.class) {
                if (masStringTool == null) {
                    masStringTool = new MasStringTool();
                }
            }
        }
        return masStringTool;
    }
}
