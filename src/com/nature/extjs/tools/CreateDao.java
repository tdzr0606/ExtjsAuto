package com.nature.extjs.tools;

/**
 * 创建dao文件
 * 
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月6日 下午8:27:13
 */
public class CreateDao extends CreateBase
{
	private String tableName;
	private String inClassName;
	private String packageName;
	private String projectName;

	public CreateDao(String className, String tableName, String packageName, String filePath, String projectName,String author)
	{
		super.author = author;
		super.className = className;
		super.filePath = filePath + Tools.pathSeparator + "java" + Tools.pathSeparator + "dao" + Tools.pathSeparator
				+ projectName;
		this.packageName = packageName;
		this.projectName = projectName;
		this.inClassName = packageName + ".pojo." + projectName + "." + className;
		this.tableName = tableName;
	}

	public void createDao()
	{
		Tools.writeFile(filePath, className + "Dao.java", createDaoFileContent());
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
		contentSB.append("package ").append(packageName).append(".dao.").append(projectName).append(";").append(Tools.lineSeparator);
		contentSB.append(Tools.lineSeparator);
		contentSB.append("import ").append(packageName).append(".dao.system.BaseDao;").append(Tools.lineSeparator);
		contentSB.append("import org.springframework.stereotype.Repository;").append(Tools.lineSeparator);
		contentSB.append(Tools.lineSeparator);
		contentSB.append("/**").append(Tools.lineSeparator);
		contentSB.append(" * ").append(Tools.lineSeparator);
		contentSB.append(" * ").append(className).append(" 数据持久化").append(Tools.lineSeparator);
		contentSB.append(" * ").append(className).append(Tools.lineSeparator);
		contentSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		contentSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		contentSB.append(" */").append(Tools.lineSeparator);
		contentSB.append("@Repository").append(Tools.lineSeparator);
		contentSB.append("public class ").append(className).append("Dao extends BaseDao").append(Tools.lineSeparator);
		contentSB.append("{").append(Tools.lineSeparator);
		contentSB.append("    @Override").append(Tools.lineSeparator);
		contentSB.append("    public Class defineClassName()").append(Tools.lineSeparator);
		contentSB.append("    {").append(Tools.lineSeparator);
		contentSB.append("        return ").append(inClassName).append(".class;").append(Tools.lineSeparator);
		contentSB.append("    }").append(Tools.lineSeparator);
		contentSB.append(Tools.lineSeparator);
		contentSB.append("    @Override").append(Tools.lineSeparator);
		contentSB.append("    public String defineTableName()").append(Tools.lineSeparator);
		contentSB.append("    {").append(Tools.lineSeparator);
		contentSB.append("         return \"").append(tableName).append("\";").append(Tools.lineSeparator);
		contentSB.append("    }").append(Tools.lineSeparator);
		contentSB.append("}").append(Tools.lineSeparator);
		return contentSB.toString();
	}
}
