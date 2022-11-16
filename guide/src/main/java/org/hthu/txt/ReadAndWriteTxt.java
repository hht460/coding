package org.hthu.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/6/28
 */
public class ReadAndWriteTxt {


    public static void main(String[] args) throws IOException {

//        LinkedHashMap<String, String> stringStringMap2 = readTxtFile("D:\\doc\\yin2.txt");
//
//
//        LinkedHashMap<String, String> stringStringMap1 = readTxtFile("D:\\doc\\yin1.txt");

        LinkedHashMap<String, Integer> stringIntegerLinkedHashMap = readTxtFileMap("D:\\eee.txt");
        for (Map.Entry<String, Integer> text : stringIntegerLinkedHashMap.entrySet()){

            if (text.getValue()>1){
                System.out.println(text.getKey());
            }

        }

//        writeTxtFile("D:\\doc\\yin3.txt", stringStringMap2);

    }

    private static LinkedHashMap<String, Integer> readTxtFileMap(String filePath) {

        LinkedHashMap<String, Integer> textMap = new LinkedHashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (textMap.containsKey(line)){
                    Integer num = textMap.get(line);
                    num = num + 1;
                    textMap.put(line, num);
                }else {
                    textMap.put(line, 1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return textMap;
    }

    /**
     * 根据文件路径读取文件
     *
     * @param filePath
     *            文件路径
     * @return Map<String, String>
     */
    private static LinkedHashMap<String, String> readTxtFile(String filePath) {

        LinkedHashMap<String, String> textMap = new LinkedHashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\t");
                if (split.length == 1){
                    textMap.put(line, null);
                }else {
                    textMap.put(split[0], line);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return textMap;
    }

    /**
     * 写入文件
     *
     * @param filePath
     *            文件路径
     * @param textList
     *            文件行内容
     * @throws IOException
     *             异常信息
     */
    private static void writeTxtFile(String filePath, LinkedHashMap<String, String> textList) throws IOException {

        File file = new File(filePath);
        file.createNewFile();

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            for (Map.Entry<String, String> text : textList.entrySet()) {
                String str = text.getKey()+"\t"+text.getValue();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
