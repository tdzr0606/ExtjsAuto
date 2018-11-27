package com.nature.extjs.tools;

/**
 * 创建Extjs 数据源
 * 
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月5日 下午4:05:05
 */
public class CreateStoreJS extends CreateBase
{
	public CreateStoreJS( String className,String filePath,String author)
	{
		super.author = author;
		super.filePath = filePath + Tools.pathSeparator + "app" + Tools.pathSeparator + "store" + Tools.pathSeparator
				+ Tools.smallFirstChar(className);
		super.className = className;
	}

	public void createStoreJs()
	{
		Tools.writeFile(super.filePath, super.className + "Store.js", this.createFileContent());
	}

	/**
	 * 创建Extjs 数据源 文件内容
	 * 
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午4:08:40
	 */
	private String createFileContent()
	{
		StringBuffer fileContentSB = new StringBuffer();
		fileContentSB.append("/**").append(Tools.lineSeparator);
		fileContentSB.append(" * ").append(className).append("Store 数据源").append(Tools.lineSeparator);
		fileContentSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		fileContentSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		fileContentSB.append("*/").append(Tools.lineSeparator);
		fileContentSB.append(Tools.lineSeparator);
		fileContentSB.append("Ext.define('wbkj.store.").append(Tools.smallFirstChar(className)).append(".")
				.append(className).append("Store', {").append(Tools.lineSeparator);
		fileContentSB.append("      extend: 'Ext.data.Store',").append(Tools.lineSeparator);
		fileContentSB.append("      requires: [").append(Tools.lineSeparator);
		fileContentSB.append("             'wbkj.model.").append(className).append("Model',")
				.append(Tools.lineSeparator);
		fileContentSB.append("             'Ext.data.proxy.Ajax',").append(Tools.lineSeparator);
		fileContentSB.append("             'Ext.data.reader.Json'").append(Tools.lineSeparator);
		fileContentSB.append("      ],").append(Tools.lineSeparator);
		fileContentSB.append("     constructor: function(cfg) {").append(Tools.lineSeparator);
		fileContentSB.append("           var me = this;").append(Tools.lineSeparator);
		fileContentSB.append("           cfg = cfg || {};").append(Tools.lineSeparator);
		fileContentSB.append("           me.callParent([Ext.apply({").append(Tools.lineSeparator);
		fileContentSB.append("                 autoLoad: false,").append(Tools.lineSeparator);
		fileContentSB.append("                 model: 'wbkj.model.").append(className).append("Model',")
				.append(Tools.lineSeparator);
		fileContentSB.append("                 storeId: '").append(Tools.smallFirstChar(className)).append(".")
				.append(className).append("Store',").append(Tools.lineSeparator);
		fileContentSB.append("                 pageSize: 40,").append(Tools.lineSeparator);
		fileContentSB.append("                 proxy: {").append(Tools.lineSeparator);
		fileContentSB.append("                       type: 'ajax',").append(Tools.lineSeparator);
		fileContentSB.append("                       limitParam: 'pageSize',").append(Tools.lineSeparator);
		fileContentSB.append("                       pageParam: 'cusPage',").append(Tools.lineSeparator);
		fileContentSB.append("                       url: '/wbkj/").append(Tools.smallFirstChar(className)).append("/list',").append(Tools.lineSeparator);
		fileContentSB.append("                       reader: {").append(Tools.lineSeparator);
		fileContentSB.append("                            type: 'json',").append(Tools.lineSeparator);
		fileContentSB.append("                            root: 'result',").append(Tools.lineSeparator);
		fileContentSB.append("                            totalProperty: 'totalCount'").append(Tools.lineSeparator);
		fileContentSB.append("                      }").append(Tools.lineSeparator);
		fileContentSB.append("                 }").append(Tools.lineSeparator);
		fileContentSB.append("          }, cfg)]);").append(Tools.lineSeparator);
		fileContentSB.append("     }").append(Tools.lineSeparator);
		fileContentSB.append("});").append(Tools.lineSeparator);
		return fileContentSB.toString();
	}

}
