package com.nature.mybatis.tools;

import com.nature.extjs.tools.CreateBase;
import com.nature.extjs.tools.Tools;

import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 创建pojo对象
 *
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月5日 下午2:15:16
 */
public class CreateLombokSpringBootVO extends CreateBase
{
    private Statement statement;
    private String tableName;
    private String packageName;
    private String projectName;

    private StringBuffer importSB = new StringBuffer();
    private int dateCount = 0;
    private int dateTimeCount = 0;
    private int bigDecimalCount = 0;

    // 字段名、字段类型
    private Map<String, String> tableContentMap = new HashMap<String, String>();

    public CreateLombokSpringBootVO(Statement statement, String tableName, String className, String packageName,
                                    String filePath, String projectName, String author)
    {
        super.author = author;
        this.statement = statement;
        this.tableName = tableName;
        super.className = className;
        this.packageName = packageName;
        this.projectName = projectName;
        super.filePath =
                filePath + Tools.pathSeparator + "java" + Tools.pathSeparator + "pojo" + Tools.pathSeparator + projectName;
    }

    public void createVo()
    {
        this.getTableContent();
        Tools.writeFile(filePath, className + ".java", this.createClassFileContent());
    }

    /**
     * 获取表字段内容
     *
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:35:51
     */
    private void getTableContent()
    {
        try
        {
            String sql = " select * from " + tableName;
            ResultSetMetaData rsmd = statement.executeQuery(sql).getMetaData();
            int columnCount = rsmd.getColumnCount();
            for(int i = 0; i < columnCount; i++)
            {
                tableContentMap.put(rsmd.getColumnName(i + 1), rsmd.getColumnTypeName(i + 1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 创建VO文件
     *
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:36:01
     */
    private String createClassFileContent()
    {
        StringBuffer fileContent = new StringBuffer();
        try
        {
            String propertyContent = createPropertyContent();

            fileContent.append("package ").append(packageName).append(".pojo.").append(projectName).append(";")
                    .append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);
            fileContent.append(importSB.toString());
            fileContent.append("import lombok.Data;").append(Tools.lineSeparator);
            fileContent.append("import java.io.Serializable;").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);
            fileContent.append("/**").append(Tools.lineSeparator);
            fileContent.append(" * ").append(Tools.lineSeparator);
            fileContent.append(" * ").append(className).append(Tools.lineSeparator);
            fileContent.append(" * Author:").append(author).append(Tools.lineSeparator);
            fileContent.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
            fileContent.append(" */ ").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);
            fileContent.append("@Data ").append(Tools.lineSeparator);
            fileContent.append("public class ").append(className).append("  implements Serializable ")
                    .append(Tools.lineSeparator);
            fileContent.append("{").append(Tools.lineSeparator);
            fileContent.append(propertyContent);
            fileContent.append("}").append(Tools.lineSeparator);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return fileContent.toString();
        }
    }

    /**
     * 创建类属性内容
     *
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:57:47
     */
    private String createPropertyContent()
    {
        if(tableContentMap.isEmpty())
        {
            return "";
        }
        StringBuffer propertySB = new StringBuffer();

        String fieldName;
        String fieldType;
        for(Entry<String, String> entry : tableContentMap.entrySet())
        {
            fieldName = entry.getKey();
            fieldType = entry.getValue();

            if(Tools.changeFieldType2JavaType(fieldType).equals("Date"))
            {
                if(dateCount == 0)
                {
                    importSB.append("import com.fasterxml.jackson.annotation.JsonFormat;").append(Tools.lineSeparator);
                    importSB.append("import org.springframework.format.annotation.DateTimeFormat;").append(Tools.lineSeparator);
                    importSB.append("import java.util.Date;").append(Tools.lineSeparator);
                }
                propertySB.append("   @JsonFormat(pattern = \"yyyy-MM-dd\") ").append(Tools.lineSeparator);
                propertySB.append("   @DateTimeFormat(pattern = \"yyyy-MM-dd\") ").append(Tools.lineSeparator);
                dateCount++;
            }
            else if(Tools.changeFieldType2JavaType(fieldType).equals("Timestamp"))
            {
                if(dateTimeCount == 0)
                {
                    importSB.append("import com.fasterxml.jackson.annotation.JsonFormat;").append(Tools.lineSeparator);
                    importSB.append("import org.springframework.format.annotation.DateTimeFormat;").append(Tools.lineSeparator);
                    importSB.append("import java.sql.Timestamp;").append(Tools.lineSeparator);
                }
                propertySB.append("   @JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\") ").append(Tools.lineSeparator);
                propertySB.append("   @DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\") ").append(Tools.lineSeparator);
                dateTimeCount++;
            }
            else if(Tools.changeFieldType2JavaType(fieldType).equals("BigDecimal"))
            {
                if(bigDecimalCount == 0)
                {
                    importSB.append("import java.math.BigDecimal;").append(Tools.lineSeparator);
                }
                bigDecimalCount++;
            }
            propertySB.append("    private ").append(Tools.changeFieldType2JavaType(fieldType)).append(" ")
                    .append(Tools.changeFieldName2JavaPropertyFieldName(fieldName)).append(";").append(Tools.lineSeparator);
        }
        propertySB.append(Tools.lineSeparator);
        return propertySB.toString();
    }

    public Map<String, String> getTableContentMap()
    {
        return tableContentMap;
    }

}
