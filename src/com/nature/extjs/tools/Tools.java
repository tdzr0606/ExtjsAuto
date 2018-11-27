package com.nature.extjs.tools;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

/**
 * 工具类
 *
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月5日 下午2:47:19
 */
public class Tools
{
    public final static String lineSeparator = System.getProperty("line.separator");
    public final static String pathSeparator = System.getProperty("file.separator");

    /**
     * 日期格式转换
     *
     * @param date
     * @param formatString
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:47:29
     */
    public static String getDate(Date date, String formatString)
    {
        String returnValue = null;
        try
        {
            if(null == date)
            {
                date = new Date();
            }
            if(null == formatString)
            {
                formatString = "yyyy-MM-dd HH:mm:ss";
            }
            DateFormat df = new SimpleDateFormat(formatString);
            returnValue = df.format(date);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return returnValue;
        }
    }

    /**
     * 获取当前日期
     *
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:52:42
     */
    public static String getNowDate()
    {
        return getDate(null, "yyyy-MM-dd");
    }

    /**
     * 获取当前日期时间
     *
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:53:25
     */
    public static String getNowDateTime()
    {
        return getDate(null, null);
    }


    /**
     * 转换数据库字段类型到java类型
     *
     * @param fieldType
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午3:04:23
     */
    public static String changeFieldType2JavaType(String fieldType)
    {
        String javaType = "String";
        switch(fieldType.toUpperCase().trim())
        {
            case "INT":
            case "INT UNSIGNED":
                javaType = "Integer";
                break;
            case "DECIMAL":
                javaType = "Float";
                break;
            case "TINYINT":
                javaType = "Boolean";
                break;
            case "DATE":
                javaType = "Date";
                break;
            case "DATETIME":
                javaType = "Timestamp";
                break;
            default:
                break;
        }
        return javaType;
    }

    /**
     * 转换数据库字段类型到extjs model类型
     *
     * @param fieldType
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午3:04:23
     */
    public static String changeFieldType2ExtjsModelType(String fieldType)
    {
        String extjsModelType = "String";
        switch(fieldType.toUpperCase().trim())
        {
            case "INT":
            case "INT UNSIGNED":
                extjsModelType = "int";
                break;
            case "DECIMAL":
                extjsModelType = "float";
                break;
            case "TINYINT":
                extjsModelType = "boolean";
                break;
            case "DATE":
                extjsModelType = "date";
                break;
            case "DATETIME":
                extjsModelType = "datetime";
                break;
            default:
                break;
        }
        return extjsModelType;
    }

    /**
     * 数据表字段名转换为java属性名
     *
     * @param fieldName
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午3:10:09
     */
    public static String changeFieldName2JavaPropertyFieldName(String fieldName)
    {
        StringBuffer javaFieldName = new StringBuffer();
        javaFieldName.append(fieldName.substring(0, 1).toLowerCase());
        javaFieldName.append(fieldName.substring(1, fieldName.length()));
        return javaFieldName.toString();
    }

    /**
     * 数据表字段名转换为get、set方法名
     *
     * @param methodType
     * @param fieldName
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午3:13:02
     */
    public static String changeFieldName2JavaMethodName(String methodType, String fieldName)
    {
        StringBuffer javaMethodName = new StringBuffer();
        javaMethodName.append(methodType);
        javaMethodName.append(fieldName.substring(0, 1).toUpperCase());
        javaMethodName.append(fieldName.substring(1, fieldName.length()));
        return javaMethodName.toString();
    }


    /**
     * 创建文件
     *
     * @param fileContent
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午3:24:30
     */
    public static void writeFile(String filePath, String fileName, String fileContent)
    {
        try
        {
            File file = new File(filePath);
            if(!file.exists())
            {
                file.mkdirs();
            }
            file = new File(filePath + Tools.pathSeparator + fileName);
            FileUtils.writeStringToFile(file, fileContent, "UTF-8");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * 首字母小写
     *
     * @param value
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午5:57:21
     */
    public static String smallFirstChar(String value)
    {
        StringBuffer returnValue = new StringBuffer();
        returnValue.append(value.substring(0, 1).toLowerCase());
        returnValue.append(value.substring(1, value.length()));
        return returnValue.toString();
    }

}
