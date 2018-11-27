package com.nature.layerui.tools;

import com.nature.extjs.tools.CreateBase;
import com.nature.extjs.tools.Tools;

import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 创建 Service
 * 
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月6日 下午9:16:33
 */
public class CreateService extends CreateBase
{
	private Statement statement;
	private String tableName;
	private String packageName;
	private String projectName;

	// 字段名、字段类型
	private Map<String, String> tableContentMap = new HashMap<String, String>();

	public CreateService(Statement statement, String tableName, String className, String filePath, String packageName, String projectName,
                         String author)
	{
		super.author = author;
		super.className = className;
		super.filePath = filePath + Tools.pathSeparator + "java" + Tools.pathSeparator + "service" + Tools.pathSeparator
				+ projectName;
		this.packageName = packageName;
		this.projectName = projectName;
		this.tableName = tableName;
		this.statement = statement;
	}

	public void createService()
	{
		this.getTableContent();
		Tools.writeFile(filePath, className + "Service.java", createServiceContent());
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
			for (int i = 0; i < columnCount; i++)
			{
				tableContentMap.put(rsmd.getColumnName(i + 1), rsmd.getColumnTypeName(i + 1));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private String createServiceContent()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("package ").append(packageName).append(".service.").append(projectName).append(";")
				.append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".dao.system.ExpressForDelete;").append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".dao.system.ExpressForInsert;").append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".dao.system.ExpressForQuery;").append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".dao.system.ExpressForUpdate;").append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".pojo.system.Page;").append(Tools.lineSeparator);
		sb.append("import org.springframework.beans.factory.annotation.Autowired;").append(Tools.lineSeparator);
		sb.append("import org.springframework.stereotype.Service;").append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".dao.").append(projectName).append(".").append(className)
				.append("Dao").append(";").append(Tools.lineSeparator);
		sb.append("import ").append(packageName).append(".pojo.").append(projectName).append(".").append(className)
				.append(";").append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("/**").append(Tools.lineSeparator);
		sb.append(" * ").append(Tools.lineSeparator);
		sb.append(" * ").append(className).append("Service").append(Tools.lineSeparator);
		sb.append(" * Author:").append(author).append(Tools.lineSeparator);
		sb.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		sb.append(" */").append(Tools.lineSeparator);
		sb.append("@Service").append(Tools.lineSeparator);
		sb.append("public class ").append(className).append("Service").append(Tools.lineSeparator);
		sb.append("{").append(Tools.lineSeparator);
		sb.append("    @Autowired").append(Tools.lineSeparator);
		sb.append("    ").append(className).append("Dao ").append(Tools.smallFirstChar(className)).append("Dao;")
				.append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("    /**").append(Tools.lineSeparator);
		sb.append("     * 获取分页数据").append(Tools.lineSeparator);
		sb.append("     *").append(Tools.lineSeparator);
		sb.append("     * @param cusPage").append(Tools.lineSeparator);
		sb.append("     * @param pageSize").append(Tools.lineSeparator);
		sb.append("     * @param key").append(Tools.lineSeparator);
		sb.append("     * @return").append(Tools.lineSeparator);
		sb.append("     */").append(Tools.lineSeparator);
		sb.append("    public Page<").append(className).append("> listPage(int cusPage, int pageSize, String key)")
				.append(Tools.lineSeparator);
		sb.append("    {").append(Tools.lineSeparator);
		sb.append("        ExpressForQuery ef = new ExpressForQuery(").append(Tools.smallFirstChar(className))
				.append("Dao.defineTableName());").append(Tools.lineSeparator);
		sb.append("        if(key.length() > 0)").append(Tools.lineSeparator);
		sb.append("        {").append(Tools.lineSeparator);

		String fieldName;
		String fieldType;
		for (Entry<String, String> entry : tableContentMap.entrySet())
		{
			fieldName = entry.getKey();
			fieldType = entry.getValue();
			if(Tools.changeFieldType2JavaType(fieldType).equals("String"))
			{
				sb.append("            ef.addLike(\"").append(fieldName).append("\",\"%\"+key+\"%\");").append(Tools.lineSeparator);
			}
		}

		sb.append("            ef.linkAllWithOr();").append(Tools.lineSeparator);
		sb.append("        }").append(Tools.lineSeparator);
		sb.append("        ef.addOrdeBy(\"id\", \"desc\", 9);").append(Tools.lineSeparator);
		sb.append("        return ").append(Tools.smallFirstChar(className))
				.append("Dao.queryForPage(ef, cusPage, pageSize);").append(Tools.lineSeparator);
		sb.append("    }").append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("    /**").append(Tools.lineSeparator);
		sb.append("     * 创建数据").append(Tools.lineSeparator);
		sb.append("     *").append(Tools.lineSeparator);
		sb.append("     * @param ").append(Tools.smallFirstChar(className)).append(Tools.lineSeparator);
		sb.append("     * @return").append(Tools.lineSeparator);
		sb.append("     */").append(Tools.lineSeparator);
		sb.append("    public boolean addNew(").append(className).append(" ").append(Tools.smallFirstChar(className))
				.append(")").append(Tools.lineSeparator);
		sb.append("    {").append(Tools.lineSeparator);
		sb.append("        ExpressForInsert ef = new ExpressForInsert(").append(Tools.smallFirstChar(className))
				.append("Dao.defineTableName(), ").append(Tools.smallFirstChar(className)).append(");")
				.append(Tools.lineSeparator);
		sb.append("        return ").append(Tools.smallFirstChar(className)).append("Dao.addNew(ef) > 0;")
				.append(Tools.lineSeparator);
		sb.append("    }").append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("    /**").append(Tools.lineSeparator);
		sb.append("     * 修改数据").append(Tools.lineSeparator);
		sb.append("     *").append(Tools.lineSeparator);
		sb.append("     * @param ").append(Tools.smallFirstChar(className)).append(Tools.lineSeparator);
		sb.append("     * @return").append(Tools.lineSeparator);
		sb.append("     */").append(Tools.lineSeparator);
		sb.append("    public boolean modify(").append(className).append(" ").append(Tools.smallFirstChar(className))
				.append(")").append(Tools.lineSeparator);
		sb.append("    {").append(Tools.lineSeparator);
		sb.append("        ExpressForUpdate ef = new ExpressForUpdate(").append(Tools.smallFirstChar(className))
				.append("Dao.defineTableName(), ").append(Tools.smallFirstChar(className)).append(");")
				.append(Tools.lineSeparator);
		sb.append("        ef.addEq(\"id\", ").append(Tools.smallFirstChar(className)).append(".getId());")
				.append(Tools.lineSeparator);
		sb.append("        return ").append(Tools.smallFirstChar(className)).append("Dao.modify(ef) > 0;")
				.append(Tools.lineSeparator);
		sb.append("    }").append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("    /**").append(Tools.lineSeparator);
		sb.append("     * 删除数据").append(Tools.lineSeparator);
		sb.append("     *").append(Tools.lineSeparator);
		sb.append("     * @param ids").append(Tools.lineSeparator);
		sb.append("     * @return").append(Tools.lineSeparator);
		sb.append("     */").append(Tools.lineSeparator);
		sb.append("    public boolean deleteByIds(String[] ids)").append(Tools.lineSeparator);
		sb.append("    {").append(Tools.lineSeparator);
		sb.append("        ExpressForDelete ef = new ExpressForDelete(").append(Tools.smallFirstChar(className))
				.append("Dao.defineTableName());").append(Tools.lineSeparator);
		sb.append("        ef.addIn(\"id\", ids);").append(Tools.lineSeparator);
		sb.append("        return ").append(Tools.smallFirstChar(className)).append("Dao.delete(ef) > 0;")
				.append(Tools.lineSeparator);
		sb.append("    }").append(Tools.lineSeparator);
		sb.append(Tools.lineSeparator);
		sb.append("    /**").append(Tools.lineSeparator);
		sb.append("     * 获取单一数据").append(Tools.lineSeparator);
		sb.append("     *").append(Tools.lineSeparator);
		sb.append("     * @param id").append(Tools.lineSeparator);
		sb.append("     * @return").append(Tools.lineSeparator);
		sb.append("     */").append(Tools.lineSeparator);
		sb.append("    public ").append(className).append(" getInfoById(int id)").append(Tools.lineSeparator);
		sb.append("    {").append(Tools.lineSeparator);
		sb.append("        ExpressForQuery ef = new ExpressForQuery(").append(Tools.smallFirstChar(className))
				.append("Dao.defineTableName());").append(Tools.lineSeparator);
		sb.append("        ef.addEq(\"id\", id + \"\");").append(Tools.lineSeparator);
		sb.append("        return (").append(className).append(") ").append(Tools.smallFirstChar(className))
				.append("Dao.getInfo(ef);").append(Tools.lineSeparator);
		sb.append("    }").append(Tools.lineSeparator);
		sb.append("}").append(Tools.lineSeparator);
		return sb.toString();
	}

}
