package com.nature.mybatis.tools;

import com.nature.extjs.tools.CreateBase;
import com.nature.extjs.tools.Tools;

/**
 * 创建dao文件
 *
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月6日 下午8:27:13
 */
public class CreateMapper extends CreateBase
{
    private String tableName;
    private String inClassName;
    private String packageName;
    private String projectName;

    public CreateMapper(String className, String tableName, String packageName, String filePath, String projectName,
                        String author)
    {
        super.author = author;
        super.className = className;
        super.filePath =
                filePath + Tools.pathSeparator + "java" + Tools.pathSeparator + "mapper" + Tools.pathSeparator + projectName;
        this.packageName = packageName;
        this.projectName = projectName;
        this.inClassName = packageName + ".pojo." + projectName + "." + className;
        this.tableName = tableName;
    }

    public void createDao()
    {
        Tools.writeFile(filePath, className + "Mapper.java", createDaoFileContent());
    }

    /**
     * 创建 dao文件内容
     *
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月6日 下午8:32:16
     */
    private String createDaoFileContent()
    {
        StringBuffer contentSB = new StringBuffer();
        contentSB.append("package ").append(packageName).append(".mapper.").append(projectName).append(";")
                .append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("import ").append(packageName).append(".mybatis.config.MyMapper;").append(Tools.lineSeparator);
        contentSB.append("import ").append(inClassName).append(";").append(Tools.lineSeparator);
        contentSB.append("import org.apache.ibatis.annotations.Param;").append(Tools.lineSeparator);
        contentSB.append("import org.springframework.stereotype.Repository;").append(Tools.lineSeparator);
        contentSB.append("import java.util.List;").append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("/**").append(Tools.lineSeparator);
        contentSB.append(" * ").append(Tools.lineSeparator);
        contentSB.append(" * ").append(className).append(" 数据持久化").append(Tools.lineSeparator);
        contentSB.append(" * ").append(className).append(Tools.lineSeparator);
        contentSB.append(" * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append(" */").append(Tools.lineSeparator);
        contentSB.append("@Repository").append(Tools.lineSeparator);
        contentSB.append("public interface ").append(className).append("Mapper extends MyMapper<").append(className).append(">")
                .append(Tools.lineSeparator);
        contentSB.append("{").append(Tools.lineSeparator);
        contentSB.append("   /**").append(Tools.lineSeparator);
        contentSB.append("    * 查询所有数据").append(Tools.lineSeparator);
        contentSB.append("    * ").append(Tools.lineSeparator);
        contentSB.append("    * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append("    * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append("    */").append(Tools.lineSeparator);
        contentSB.append("    public List<").append(className).append("> list(@Param(value = \"key\") String key);")
                .append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("   /**").append(Tools.lineSeparator);
        contentSB.append("    * 添加新数据").append(Tools.lineSeparator);
        contentSB.append("    * ").append(Tools.lineSeparator);
        contentSB.append("    * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append("    * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append("    */").append(Tools.lineSeparator);
        contentSB.append("    public int add(").append(className).append(" obj);").append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("   /**").append(Tools.lineSeparator);
        contentSB.append("    * 更新数据").append(Tools.lineSeparator);
        contentSB.append("    * ").append(Tools.lineSeparator);
        contentSB.append("    * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append("    * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append("    */").append(Tools.lineSeparator);
        contentSB.append("    public int modify(").append(className).append(" obj);").append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("   /**").append(Tools.lineSeparator);
        contentSB.append("    * 删除数据").append(Tools.lineSeparator);
        contentSB.append("    * ").append(Tools.lineSeparator);
        contentSB.append("    * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append("    * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append("    */").append(Tools.lineSeparator);
        contentSB.append("    public int deleteById(@Param(value = \"id\") Integer id);").append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("   /**").append(Tools.lineSeparator);
        contentSB.append("    * 批量删除").append(Tools.lineSeparator);
        contentSB.append("    * ").append(Tools.lineSeparator);
        contentSB.append("    * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append("    * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append("    */").append(Tools.lineSeparator);
        contentSB.append("    public void deleteByIds(@Param(value = \"ids\") String[] ids);").append(Tools.lineSeparator);
        contentSB.append(Tools.lineSeparator);
        contentSB.append("   /**").append(Tools.lineSeparator);
        contentSB.append("    * 根据id查询数据").append(Tools.lineSeparator);
        contentSB.append("    * ").append(Tools.lineSeparator);
        contentSB.append("    * Author:").append(author).append(Tools.lineSeparator);
        contentSB.append("    * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        contentSB.append("    */").append(Tools.lineSeparator);
        contentSB.append("    public ").append(className).append(" findById(@Param(value = \"id\") Integer id);")
                .append(Tools.lineSeparator);
        contentSB.append("}").append(Tools.lineSeparator);
        return contentSB.toString();
    }
}
