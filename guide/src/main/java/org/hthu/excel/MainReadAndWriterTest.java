package org.hthu.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/2/9
 */
public class MainReadAndWriterTest {

    private static final Logger logger = LoggerFactory.getLogger(MainReadAndWriterTest.class);

    public static void main(String[] args) {
        // 设定Excel文件所在路径
        String excelFileName = "D://gqj.xlsx";
        // 读取Excel文件内容
        List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);
        assert readResult != null;
        logger.info(readResult.toString());

        // 写入数据到工作簿对象内
        Workbook workbook = ExcelWriter.exportData(readResult);

        // 以文件的形式输出工作簿对象
        FileOutputStream fileOut = null;
        try {
            String exportFilePath = "D://gqj-result.xlsx";
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            logger.warn("输出Excel时发生错误，错误原因：" + e.getMessage());
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
                logger.warn("关闭输出流时发生错误，错误原因：" + e.getMessage());
            }
        }

    }

}
