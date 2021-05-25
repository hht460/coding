package org.hthu.test;

import org.apache.commons.lang3.StringUtils;

/**
 * 处理类
 */
public class MasStringTool {

    public String maxStr(String str){
        if (StringUtils.isBlank(str)){
            return "";
        }
        int len = str.length();
        int count = 0;
        for (int i=0; i<len;i++){
            // 字符串被切换，若模式串为最大子串，则切割后数组应该为空
            String[] split = str.split(str.substring(0, i));
            if(split.length == 0){
                count = i;
                break;
            }
        }
        String result = "";
        // 未找到
        if (count == 0){
            result = "1" + str;
        }else {
            result = len/count + str.substring(0,count);
        }
        return result;
    }
}
