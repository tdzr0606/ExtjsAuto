package com.nature.extjs.tools;

import java.util.Map;
import java.util.Map.Entry;
/**
 * 创建Extjs 数据模板文件
 * 
 * @author 竺志伟
 * @email  tdzr_0606@126.com
 * @date   2017年3月5日 下午4:04:50
 */
public class CreateModelJS extends CreateBase
{

	public CreateModelJS(String className, String filePath,String author)
	{
		super.author = author;
		super.className = className;
		super.filePath = filePath + Tools.pathSeparator+"app"+Tools.pathSeparator+"model";
	}

	public void createModelJS(Map<String, String> tableContent)
	{
		Tools.writeFile(filePath,className + "Model.js", this.createFileContent(tableContent));
	}

	/**
	 * 创建model js文件
	 * 
	 * @param tableContent
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午3:43:09
	 */
	private String createFileContent(Map<String, String> tableContent)
	{
		StringBuffer fileContentSB = new StringBuffer();
		fileContentSB.append("/**").append(Tools.lineSeparator);
		fileContentSB.append(" * ").append(className).append("Model 数据模板").append(Tools.lineSeparator);
		fileContentSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		fileContentSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		fileContentSB.append("*/").append(Tools.lineSeparator);
		fileContentSB.append(Tools.lineSeparator);
		fileContentSB.append("Ext.define('wbkj.model.").append(className).append("Model', {")
				.append(Tools.lineSeparator);
		fileContentSB.append("      extend: 'Ext.data.Model',").append(Tools.lineSeparator);
		fileContentSB.append("      requires: [").append(Tools.lineSeparator);
		fileContentSB.append("            'Ext.data.Field'").append(Tools.lineSeparator);
		fileContentSB.append("      ],").append(Tools.lineSeparator);
		fileContentSB.append("      fields: [").append(Tools.lineSeparator);
		fileContentSB.append(createPrpertyContent(tableContent));
		fileContentSB.append("      ]").append(Tools.lineSeparator);
		fileContentSB.append("});").append(Tools.lineSeparator);
		return fileContentSB.toString();
	}

	/**
	 * 创建属性内容
	 * 
	 * @param tableContent
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午3:49:11
	 */
	private String createPrpertyContent(Map<String, String> tableContent)
	{
		int count = tableContent.size();
		int index = 0;
		StringBuffer propertySB = new StringBuffer();
		String fieldName;
		String fieldType;
		for (Entry<String, String> entry : tableContent.entrySet())
		{
			fieldName = entry.getKey();
			fieldType = entry.getValue();

			propertySB.append("            {").append(Tools.lineSeparator);
			propertySB.append("                 name:'").append(Tools.changeFieldName2JavaPropertyFieldName(fieldName))
					.append("',").append(Tools.lineSeparator);
			propertySB.append("                 type:'").append(Tools.changeFieldType2ExtjsModelType(fieldType).toLowerCase()).append("'")
					.append(Tools.lineSeparator);
			if(Tools.changeFieldType2ExtjsModelType(fieldType).toLowerCase().equals("date"))
			{
				propertySB.append("                 ,format:'Y-m-d' ").append(Tools.lineSeparator);
			}
			else if(Tools.changeFieldType2ExtjsModelType(fieldType).toLowerCase().equals("datetime"))
			{
				propertySB.append("                 ,format:'Y-m-d H:i:s' ").append(Tools.lineSeparator);
			}
			index++;
			if(index < count)
			{
				propertySB.append("            },").append(Tools.lineSeparator);
			}
			else
			{
				propertySB.append("            }").append(Tools.lineSeparator);
			}
		}
		return propertySB.toString();
	}

}
