package org.hthu.excel;

import java.util.List;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/2/9
 */
public class MainReadTest {

    public static void main(String[] args) {
        // 设定Excel文件所在路径
        String excelFileName = "D://gqj.xlsx";
        // 读取Excel文件内容
        List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);
        System.out.println(readResult);
        // todo 进行业务操作
    }

}
