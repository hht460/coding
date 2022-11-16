package org.hthu.leedcode;

import java.util.Stack;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/11/5
 */
public class NumberConvertChinese {


    public static void main(String[] args) {
        System.out.println(convertChinese(143232342));
        System.out.println(convertChinese(1000005));
    }

    public static String convertChinese(int input) {
        String[] convertMap = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] unitMap = new String[]{"", "十", "百", "千", "万", "十", "百", "千", "万", "亿", "十亿"};

        char[] chars = String.valueOf(input).toCharArray();

        // 转换索引
        int i = chars.length - 1;
        // 单位索引
        int j = 0;

        Stack<String> stack = new Stack<>();

        // handle case like : 10000
        while (i >= 0 && chars[i] == '0') {
            i--;
            j++;
        }

        while (i >= 0) {
            // 1005 -> 一千零五
            while (i >= 0 && chars[i] == '0') {
                if (!"零".equals(stack.peek())) {
                    stack.push("零");
                }
                i--;
                j++;
            }

            stack.push(convertMap[chars[i] - '0'] + unitMap[j]);
            i--;
            j++;
        }

        StringBuilder resp = new StringBuilder();
        while (!stack.isEmpty()) {
            resp.append(stack.pop());
        }

        return resp.toString();
    }
}
