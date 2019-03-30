package com.nature.mybatis.tools;

import com.nature.extjs.tools.CreateBase;
import com.nature.extjs.tools.Tools;

import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * ExtjsAuto
 * CreateMapperXml
 *
 * @Author: 竺志伟
 * @Date: 2018-11-28 10:03
 */
public class CreateMapperXml extends CreateBase
{
    private Statement statement;
    private String tableName;
    private String packageName;
    private String projectName;
    private String inClassName;

    // 字段名、字段类型
    private Map<String, String> tableContentMap = new HashMap<String, String>();

    public CreateMapperXml(Statement statement, String tableName, String className, String packageName, String filePath,
                           String projectName, String author)
    {
        super.author = author;
        this.statement = statement;
        this.tableName = tableName;
        super.className = className;
        this.packageName = packageName;
        this.projectName = projectName;
        super.filePath =
                filePath + Tools.pathSeparator + "java" + Tools.pathSeparator + "mapperXml" + Tools.pathSeparator + projectName;
        this.inClassName = packageName + ".pojo." + projectName + "." + className;
    }

    public void createMapperXml()
    {
        this.getTableContent();
        Tools.writeFile(filePath, className + "Mapper.xml", this.createXmlFileContent());
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
     * 创建xml文件
     *
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月5日 下午2:36:01
     */
    private String createXmlFileContent()
    {
        StringBuffer fileContent = new StringBuffer();
        try
        {
            String field = null;
            StringBuffer fieldSb = new StringBuffer();
            StringBuffer fieldVSb = new StringBuffer();
            StringBuffer fieldMSb = new StringBuffer();
            for(Map.Entry<String, String> entry : tableContentMap.entrySet())
            {
                field = entry.getKey();
                fieldSb.append(field).append(",");
                fieldVSb.append("#{").append(field).append("},");
                if(!field.equalsIgnoreCase("id"))
                {
                    fieldMSb.append(field).append(" = #{").append(field).append("},");
                }
            }


            fileContent.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis" +
                    ".org/dtd/mybatis-3-mapper.dtd\" >").append(Tools.lineSeparator);
            fileContent.append("<mapper namespace=\"").append(packageName).append(".mapper.").append(projectName).append(".")
                    .append(className).append("Mapper").append("\">").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("    <cache type=\"org.mybatis.caches.ehcache.EhcacheCache\"></cache> ")
                    .append(Tools.lineSeparator);
            fileContent.append("    <!--基础 表字段定义 -->").append(Tools.lineSeparator);
            fileContent.append("    <sql id=\"basicColumn\">").append(Tools.lineSeparator);
            fileContent.append("        ").append(fieldSb.substring(0, fieldSb.length() - 1)).append(Tools.lineSeparator);
            fileContent.append("    </sql>").append(Tools.lineSeparator);

            fileContent.append(Tools.lineSeparator);
            fileContent.append("    <!-- 查询所有数据 -->").append(Tools.lineSeparator);
            fileContent.append("    <select id=\"list\" resultType=\"").append(inClassName)
                    .append("\" parameterType=\"java.lang" + ".String\">").append(Tools.lineSeparator);
            fileContent.append("        select <include refid=\"basicColumn\"/> from ").append(tableName)
                    .append(Tools.lineSeparator);
            fileContent.append("        <where>").append(Tools.lineSeparator);
            fileContent.append("            <if test=\"key != null and key != '' \">").append(Tools.lineSeparator);
            int keySize = 0;
            for(Map.Entry<String, String> entry : tableContentMap.entrySet())
            {
                if(Tools.changeFieldType2JavaType(entry.getValue()).equals("String"))
                {
                    if(keySize == 0)
                    {
                        fileContent.append("                ");
                    }
                    else
                    {
                        fileContent.append("                or ");
                    }
                    fileContent.append(entry.getKey()).append(" like CONCAT(concat('%',#{key})," + "'%')")
                            .append(Tools.lineSeparator);
                    keySize++;
                }
            }
            fileContent.append("            </if>").append(Tools.lineSeparator);
            fileContent.append("        </where>").append(Tools.lineSeparator);
            fileContent.append("        order by  id desc").append(Tools.lineSeparator);
            fileContent.append("    </select>").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("    <!-- 根据ID查询数据 -->").append(Tools.lineSeparator);
            fileContent.append("    <select id=\"findById\" resultType=\"").append(inClassName)
                    .append("\" parameterType=\"java.lang" + ".Integer\">").append(Tools.lineSeparator);
            fileContent.append("        select <include refid=\"basicColumn\"></include> from ").append(tableName)
                    .append(" where " + "id = #{id}").append(Tools.lineSeparator);
            fileContent.append("    </select>").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("    <!-- 新建 -->").append(Tools.lineSeparator);
            fileContent.append("    <insert id=\"add\" parameterType=\"").append(inClassName)
                    .append("\" useGeneratedKeys=\"true\" " + "keyProperty=\"id\">").append(Tools.lineSeparator);
            fileContent.append("        INSERT INTO ").append(tableName).append(" ( ")
                    .append(fieldSb.substring(0, fieldSb.length() - 1)).append(" ) ").append(Tools.lineSeparator);
            fileContent.append("        VALUES ( ").append(fieldVSb.substring(0, fieldVSb.length() - 1)).append(" ) ")
                    .append(Tools.lineSeparator);
            fileContent.append("    </insert>").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("    <!-- 修改-->").append(Tools.lineSeparator);
            fileContent.append("    <update id=\"modify\" parameterType=\"").append(inClassName).append("\">")
                    .append(Tools.lineSeparator);
            fileContent.append("        UPDATE ").append(tableName).append(" SET ")
                    .append(fieldMSb.substring(0, fieldMSb.length() - 1)).append(Tools.lineSeparator);
            fileContent.append("        WHERE  id = #{id} ").append(Tools.lineSeparator);
            fileContent.append("    </update>").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("    <!-- 删除 -->").append(Tools.lineSeparator);
            fileContent.append("    <delete id=\"deleteById\" parameterType=\"java.lang.Integer\">")
                    .append(Tools.lineSeparator);
            fileContent.append("        DELETE FROM ").append(tableName).append(" WHERE  id = #{id}")
                    .append(Tools.lineSeparator);
            fileContent.append("    </delete>").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("    <!-- 批量删除-->").append(Tools.lineSeparator);
            fileContent.append("    <delete id=\"deleteByIds\" parameterType=\"java.util.Arrays\">")
                    .append(Tools.lineSeparator);
            fileContent.append("        DELETE FROM ").append(tableName).append(" WHERE id in").append(Tools.lineSeparator);
            fileContent.append("        <foreach collection=\"ids\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" " +
                    "close=\")\">").append(Tools.lineSeparator);
            fileContent.append("            ${item} ").append(Tools.lineSeparator);
            fileContent.append("        </foreach>").append(Tools.lineSeparator);
            fileContent.append("    </delete>").append(Tools.lineSeparator);
            fileContent.append(Tools.lineSeparator);

            fileContent.append("</mapper>");
            fileContent.append(Tools.lineSeparator);
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


    public Map<String, String> getTableContentMap()
    {
        return tableContentMap;
    }
}
