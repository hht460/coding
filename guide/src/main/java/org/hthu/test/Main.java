package org.hthu.test;

public class Main {
    public static void main(String[] args) {
        MasStringTool masStringTool = Sinleton.getMasStringTool();

        System.out.println(masStringTool.maxStr("ababab"));
    }
}
