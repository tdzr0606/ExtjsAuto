package com.nature.extjs.tools;

import java.util.Map;
import java.util.Map.Entry;

/**
 * 创建View js
 * 
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月5日 下午6:02:38
 */
public class CreateViewJS extends CreateBase
{
	public CreateViewJS(String className, String filePath, String author)
	{
		super.author = author;
		super.className = className;
		super.filePath = filePath + Tools.pathSeparator + "app" + Tools.pathSeparator + "view" + Tools.pathSeparator
				+ Tools.smallFirstChar(className);
	}

	public void createViewJs(Map<String, String> tableContent)
	{
		Tools.writeFile(filePath, className + "MainView.js", createMainView(tableContent));
		Tools.writeFile(filePath, className + "RightMenu.js", createRightMenuView());
		Tools.writeFile(filePath, className + "Form.js", createFormView(tableContent));
	}

	/**
	 * 创建Form表单
	 * 
	 * @param tableContent
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午9:16:41
	 */
	private String createFormView(Map<String, String> tableContent)
	{
		StringBuffer formSB = new StringBuffer();
		formSB.append("/**").append(Tools.lineSeparator);
		formSB.append(" * ").append(className).append("Form 表单").append(Tools.lineSeparator);
		formSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		formSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		formSB.append("*/").append(Tools.lineSeparator);
		formSB.append("Ext.define('wbkj.view.").append(Tools.smallFirstChar(className)).append(".").append(className)
				.append("Form', {").append(Tools.lineSeparator);
		formSB.append("     extend: 'Ext.window.Window',").append(Tools.lineSeparator);
		formSB.append("     alias: 'widget.").append(className).append("Form',").append(Tools.lineSeparator);
		formSB.append("     requires: [").append(Tools.lineSeparator);
		formSB.append("         'Ext.form.Panel',").append(Tools.lineSeparator);
		formSB.append("         'Ext.form.field.Hidden',").append(Tools.lineSeparator);
		formSB.append("         'Ext.form.field.Text',").append(Tools.lineSeparator);
		formSB.append("         'Ext.toolbar.Toolbar',").append(Tools.lineSeparator);
		formSB.append("         'Ext.toolbar.Fill',").append(Tools.lineSeparator);
		formSB.append("         'Ext.button.Button',").append(Tools.lineSeparator);
		formSB.append("         'Ext.toolbar.TextItem'").append(Tools.lineSeparator);
		formSB.append("    ],").append(Tools.lineSeparator);
		formSB.append("    minHeight: 400,").append(Tools.lineSeparator);
		formSB.append("    minWidth: 600,").append(Tools.lineSeparator);
		formSB.append("    layout: 'fit',").append(Tools.lineSeparator);
		formSB.append("    title: '表单',").append(Tools.lineSeparator);
		formSB.append("    modal: true,").append(Tools.lineSeparator);
		formSB.append("    initComponent: function() {").append(Tools.lineSeparator);
		formSB.append("         var me = this;").append(Tools.lineSeparator);
		formSB.append("         Ext.applyIf(me, {").append(Tools.lineSeparator);
		formSB.append("              items: [").append(Tools.lineSeparator);
		formSB.append("              	{").append(Tools.lineSeparator);
		formSB.append("             		xtype: 'form',").append(Tools.lineSeparator);
		formSB.append("             		border: false,").append(Tools.lineSeparator);
		formSB.append("             		itemId: 'myFrom',").append(Tools.lineSeparator);
		formSB.append("             		bodyBorder: false,").append(Tools.lineSeparator);
		formSB.append("             		bodyPadding: 10,").append(Tools.lineSeparator);
		formSB.append("             		layout: {").append(Tools.lineSeparator);
		formSB.append("             				type: 'vbox',").append(Tools.lineSeparator);
		formSB.append("             				align: 'stretch'").append(Tools.lineSeparator);
		formSB.append("             		},").append(Tools.lineSeparator);
		formSB.append("             		items: [").append(Tools.lineSeparator);
		formSB.append(createFormFieldContent(tableContent)).append(Tools.lineSeparator);
		formSB.append("              		]").append(Tools.lineSeparator);
		formSB.append("              	}").append(Tools.lineSeparator);
		formSB.append("              ],").append(Tools.lineSeparator);
		formSB.append("             dockedItems: [").append(Tools.lineSeparator);
		formSB.append("                   {").append(Tools.lineSeparator);
		formSB.append("                         xtype: 'toolbar',").append(Tools.lineSeparator);
		formSB.append("                         dock: 'bottom',").append(Tools.lineSeparator);
		formSB.append("                         border: 1,").append(Tools.lineSeparator);
		formSB.append("                         items: [").append(Tools.lineSeparator);
		formSB.append("                               { xtype: 'tbfill',width: 200 },").append(Tools.lineSeparator);
		formSB.append("                               {").append(Tools.lineSeparator);
		formSB.append("                                     xtype: 'button',").append(Tools.lineSeparator);
		formSB.append("                                     height: 25,").append(Tools.lineSeparator);
		formSB.append("                                     itemId: 'myForm_ok',").append(Tools.lineSeparator);
		formSB.append("                                     minWidth: 60,").append(Tools.lineSeparator);
		formSB.append("                                     arrowAlign: 'bottom',").append(Tools.lineSeparator);
		formSB.append("                                     text: '确定'").append(Tools.lineSeparator);
		formSB.append("                              },").append(Tools.lineSeparator);
		formSB.append("                              {").append(Tools.lineSeparator);
		formSB.append("                                     xtype: 'button',").append(Tools.lineSeparator);
		formSB.append("                                     height: 25,").append(Tools.lineSeparator);
		formSB.append("                                     itemId: 'myForm_cancel',").append(Tools.lineSeparator);
		formSB.append("                                     minWidth: 60,").append(Tools.lineSeparator);
		formSB.append("                                     arrowAlign: 'bottom',").append(Tools.lineSeparator);
		formSB.append("                                     text: '取消'").append(Tools.lineSeparator);
		formSB.append("                               },").append(Tools.lineSeparator);
		formSB.append("                               { xtype: 'tbtext', text: '      '}").append(Tools.lineSeparator);
		formSB.append("                         ]").append(Tools.lineSeparator);
		formSB.append("                   }").append(Tools.lineSeparator);
		formSB.append("             ]").append(Tools.lineSeparator);
		formSB.append("     });").append(Tools.lineSeparator);
		formSB.append("     me.callParent(arguments);").append(Tools.lineSeparator);
		formSB.append("   }").append(Tools.lineSeparator);
		formSB.append("});").append(Tools.lineSeparator);
		return formSB.toString();
	}

	/**
	 * 创建表单字段属性
	 * 
	 * @param tableContent
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午9:46:39
	 */
	private String createFormFieldContent(Map<String, String> tableContent)
	{
		int count = tableContent.size();
		int index = 0;
		StringBuffer propertySB = new StringBuffer();
		String fieldName;
		for (Entry<String, String> entry : tableContent.entrySet())
		{
			fieldName = entry.getKey();
			propertySB.append("		                       {").append(Tools.lineSeparator);
			propertySB.append("		                             xtype: 'textfield',").append(Tools.lineSeparator);
			propertySB.append(" 		                             border: 0,").append(Tools.lineSeparator);
			propertySB.append("		                             fixed: true,").append(Tools.lineSeparator);
			propertySB.append(" 		                             fieldLabel: '标题',").append(Tools.lineSeparator);
			propertySB.append(" 		                             labelAlign: 'right',").append(Tools.lineSeparator);
			propertySB.append(" 		                             labelWidth: 100,").append(Tools.lineSeparator);
			propertySB.append(" 		                             allowBlank:false,").append(Tools.lineSeparator);
			propertySB.append(" 		                             name: '")
					.append(Tools.changeFieldName2JavaPropertyFieldName(fieldName)).append("'")
					.append(Tools.lineSeparator);
			index++;
			if(index < count)
			{
				propertySB.append("                       			},").append(Tools.lineSeparator);
			}
			else
			{
				propertySB.append("                     		  	 }").append(Tools.lineSeparator);
			}
		}
		return propertySB.toString();
	}

	/**
	 * 创建右键菜单
	 * 
	 * @param tableContent
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午8:56:05
	 */
	private String createRightMenuView()
	{
		StringBuffer rightMenuViewSB = new StringBuffer();
		rightMenuViewSB.append("/**").append(Tools.lineSeparator);
		rightMenuViewSB.append(" * ").append(className).append("RightMenu 右键菜单").append(Tools.lineSeparator);
		rightMenuViewSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		rightMenuViewSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		rightMenuViewSB.append("*/").append(Tools.lineSeparator);
		rightMenuViewSB.append("Ext.define('wbkj.view.").append(Tools.smallFirstChar(className)).append(".")
				.append(className).append("RightMenu', {").append(Tools.lineSeparator);
		rightMenuViewSB.append("      extend: 'Ext.menu.Menu',").append(Tools.lineSeparator);
		rightMenuViewSB.append("      alias: 'widget.").append(className).append("RightMenu',")
				.append(Tools.lineSeparator);
		rightMenuViewSB.append("      requires: [").append(Tools.lineSeparator);
		rightMenuViewSB.append("          'Ext.menu.Separator'").append(Tools.lineSeparator);
		rightMenuViewSB.append("      ],").append(Tools.lineSeparator);
		rightMenuViewSB.append("      hidden: false,").append(Tools.lineSeparator);
		rightMenuViewSB.append("      itemId: 'rightMenu',").append(Tools.lineSeparator);
		rightMenuViewSB.append("      initComponent: function() {").append(Tools.lineSeparator);
		rightMenuViewSB.append("           var me = this;").append(Tools.lineSeparator);
		rightMenuViewSB.append("           Ext.applyIf(me, {").append(Tools.lineSeparator);
		rightMenuViewSB.append("                items: [").append(Tools.lineSeparator);
		rightMenuViewSB.append("                    {").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        xtype: 'menuitem',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        rightCode: '',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        itemId: 'new',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        iconCls: 'new-button',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        hidden:false,").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        text: '新建'").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   },").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   {").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        xtype: 'menuitem',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        rightCode: '',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        itemId: 'modify',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        iconCls: 'modify-button',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        hidden:false,").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        disabled: true,").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        text: '修改'").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   },").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   {").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        xtype: 'menuitem',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        rightCode: '',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        itemId: 'delete',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        iconCls: 'delete-button',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        hidden:false,").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        disabled: true,").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        text: '删除'").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   },").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   { xtype: 'menuseparator' },").append(Tools.lineSeparator);
		rightMenuViewSB.append("                   {").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        xtype: 'menuitem',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        itemId: 'refresh',").append(Tools.lineSeparator);
		rightMenuViewSB.append("                        text: '刷新'").append(Tools.lineSeparator);
		rightMenuViewSB.append("                    }").append(Tools.lineSeparator);
		rightMenuViewSB.append("               ]").append(Tools.lineSeparator);
		rightMenuViewSB.append("          });").append(Tools.lineSeparator);
		rightMenuViewSB.append("          me.callParent(arguments);").append(Tools.lineSeparator);
		rightMenuViewSB.append("     }").append(Tools.lineSeparator);
		rightMenuViewSB.append("});").append(Tools.lineSeparator);
		return rightMenuViewSB.toString();
	}

	/**
	 * 创建主页面 js
	 * 
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午6:21:42
	 */
	private String createMainView(Map<String, String> tableContent)
	{
		StringBuffer mainViewSB = new StringBuffer();
		mainViewSB.append("/**").append(Tools.lineSeparator);
		mainViewSB.append(" * ").append(className).append("主页面").append(Tools.lineSeparator);
		mainViewSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		mainViewSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		mainViewSB.append("*/").append(Tools.lineSeparator);
		mainViewSB.append("Ext.define('wbkj.view.").append(Tools.smallFirstChar(className)).append(".")
				.append(className).append("MainView', {").append(Tools.lineSeparator);
		mainViewSB.append("       extend: 'Ext.grid.Panel',").append(Tools.lineSeparator);
		mainViewSB.append("       alias: 'widget.").append(className).append("MainView',").append(Tools.lineSeparator);
		mainViewSB.append("       requires: [").append(Tools.lineSeparator);
		mainViewSB.append("             'wbkj.view.ux.SearchTrigger',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.grid.RowNumberer',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.grid.View',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.button.Button',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.toolbar.Separator',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.form.Label',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.form.field.Trigger',").append(Tools.lineSeparator);
		mainViewSB.append("             'Ext.toolbar.Paging'").append(Tools.lineSeparator);
		mainViewSB.append("      ],").append(Tools.lineSeparator);
		mainViewSB.append("      border: false,").append(Tools.lineSeparator);
		mainViewSB.append("      columnLines: false,").append(Tools.lineSeparator);
		mainViewSB.append("      store: '").append(Tools.smallFirstChar(className)).append(".").append(className)
				.append("Store',").append(Tools.lineSeparator);
		mainViewSB.append("      initComponent: function() {").append(Tools.lineSeparator);
		mainViewSB.append("              var me = this;").append(Tools.lineSeparator);
		mainViewSB.append("              Ext.applyIf(me, {").append(Tools.lineSeparator);
		mainViewSB.append("                    columns: [").append(Tools.lineSeparator);
		mainViewSB.append(createMainFieldContent(tableContent)).append(Tools.lineSeparator);
		mainViewSB.append("                    ],").append(Tools.lineSeparator);
		mainViewSB.append("             viewConfig: {").append(Tools.lineSeparator);
		mainViewSB.append("                    itemId: 'gridView'").append(Tools.lineSeparator);
		mainViewSB.append("             },").append(Tools.lineSeparator);
		mainViewSB.append("             dockedItems: [").append(Tools.lineSeparator);
		mainViewSB.append("                 {").append(Tools.lineSeparator);
		mainViewSB.append("                       xtype: 'toolbar',").append(Tools.lineSeparator);
		mainViewSB.append("                       dock: 'top',").append(Tools.lineSeparator);
		mainViewSB.append("                       itemId: 'toolBar',").append(Tools.lineSeparator);
		mainViewSB.append("                       items: [").append(Tools.lineSeparator);
		mainViewSB.append("                           {").append(Tools.lineSeparator);
		mainViewSB.append("                                xtype: 'button',").append(Tools.lineSeparator);
		mainViewSB.append("                                rightCode: '',").append(Tools.lineSeparator);
		mainViewSB.append("                                itemId: 'new',").append(Tools.lineSeparator);
		mainViewSB.append("                                iconCls: 'new-button',").append(Tools.lineSeparator);
		mainViewSB.append("                                hidden:false,").append(Tools.lineSeparator);
		mainViewSB.append("                                text: '新建'").append(Tools.lineSeparator);
		mainViewSB.append("                          },").append(Tools.lineSeparator);
		mainViewSB.append("                          {").append(Tools.lineSeparator);
		mainViewSB.append("                               xtype: 'button',").append(Tools.lineSeparator);
		mainViewSB.append("                               rightCode: '',").append(Tools.lineSeparator);
		mainViewSB.append("                               itemId: 'modify',").append(Tools.lineSeparator);
		mainViewSB.append("                               iconCls: 'modify-button',").append(Tools.lineSeparator);
		mainViewSB.append("                               hidden:false,").append(Tools.lineSeparator);
		mainViewSB.append("                               disabled: true,").append(Tools.lineSeparator);
		mainViewSB.append("                               text: '修改'").append(Tools.lineSeparator);
		mainViewSB.append("                          },").append(Tools.lineSeparator);
		mainViewSB.append("                          {").append(Tools.lineSeparator);
		mainViewSB.append("                                xtype: 'button',").append(Tools.lineSeparator);
		mainViewSB.append("                                rightCode: '',").append(Tools.lineSeparator);
		mainViewSB.append("                                itemId: 'delete',").append(Tools.lineSeparator);
		mainViewSB.append("                                iconCls: 'delete-button',").append(Tools.lineSeparator);
		mainViewSB.append("                                hidden:false,").append(Tools.lineSeparator);
		mainViewSB.append("                                disabled: true,").append(Tools.lineSeparator);
		mainViewSB.append("                                text: '删除'").append(Tools.lineSeparator);
		mainViewSB.append("                          },").append(Tools.lineSeparator);
		mainViewSB.append("                          {  xtype: 'tbseparator' },").append(Tools.lineSeparator);
		mainViewSB.append("                          {").append(Tools.lineSeparator);
		mainViewSB.append("                                 xtype: 'button',").append(Tools.lineSeparator);
		mainViewSB.append("                                 itemId: 'refresh',").append(Tools.lineSeparator);
		mainViewSB.append("                                 text: '刷新'").append(Tools.lineSeparator);
		mainViewSB.append("                          },").append(Tools.lineSeparator);
		mainViewSB.append("                          {  xtype: 'tbfill' },").append(Tools.lineSeparator);
		mainViewSB.append("                          { xtype: 'uxsearchtrigger1',itemId: 'search'} ")
				.append(Tools.lineSeparator);
		mainViewSB.append("                    ]").append(Tools.lineSeparator);
		mainViewSB.append("               },").append(Tools.lineSeparator);
		mainViewSB.append("              {").append(Tools.lineSeparator);
		mainViewSB.append("                  xtype: 'pagingtoolbar',").append(Tools.lineSeparator);
		mainViewSB.append("                  dock: 'bottom',").append(Tools.lineSeparator);
		mainViewSB.append("                  itemId: 'pageBar',").append(Tools.lineSeparator);
		mainViewSB.append("                  afterPageText: '页-{0}',").append(Tools.lineSeparator);
		mainViewSB.append("                  beforePageText: '当前',").append(Tools.lineSeparator);
		mainViewSB.append("                  displayInfo: true,").append(Tools.lineSeparator);
		mainViewSB.append("                  displayMsg: '正在显示{0} - {1} of {2}',").append(Tools.lineSeparator);
		mainViewSB.append("                  emptyMsg: '没有显示的记录',").append(Tools.lineSeparator);
		mainViewSB.append("                  firstText: '第一页',").append(Tools.lineSeparator);
		mainViewSB.append("                  lastText: '最后一页',").append(Tools.lineSeparator);
		mainViewSB.append("                  nextText: '下一页',").append(Tools.lineSeparator);
		mainViewSB.append("                  prevText: '上一页',").append(Tools.lineSeparator);
		mainViewSB.append("                  refreshText: '刷新',").append(Tools.lineSeparator);
		mainViewSB.append("                  store: '").append(Tools.smallFirstChar(className)).append(".")
				.append(className).append("Store'").append(Tools.lineSeparator);
		mainViewSB.append("           }").append(Tools.lineSeparator);
		mainViewSB.append("        ]").append(Tools.lineSeparator);
		mainViewSB.append("     });").append(Tools.lineSeparator);
		mainViewSB.append("     me.callParent(arguments);").append(Tools.lineSeparator);
		mainViewSB.append("  }").append(Tools.lineSeparator);
		mainViewSB.append("});").append(Tools.lineSeparator);
		return mainViewSB.toString();
	}

	/**
	 * 主页面 字段属性
	 * 
	 * @param tableContent
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午8:27:27
	 */
	private String createMainFieldContent(Map<String, String> tableContent)
	{
		int count = tableContent.size();
		int index = 0;
		StringBuffer propertySB = new StringBuffer();
		propertySB.append("                                { xtype: 'rownumberer', width: 35 },")
				.append(Tools.lineSeparator);
		String fieldName;
		String fieldType;
		for (Entry<String, String> entry : tableContent.entrySet())
		{
			fieldName = entry.getKey();
			fieldType = entry.getValue();
			propertySB.append("                                {").append(Tools.lineSeparator);
			if(Tools.changeFieldType2JavaType(fieldType).equals("Date")
					|| Tools.changeFieldType2JavaType(fieldType).equals("Timestamp"))
			{
				propertySB.append("                                      xtype: 'datecolumn',")
						.append(Tools.lineSeparator);
				propertySB.append("                                      format:'Y-m-d',").append(Tools.lineSeparator);
			}
			else
			{
				propertySB.append("                                      xtype: 'gridcolumn',")
						.append(Tools.lineSeparator);
			}

			if(Tools.changeFieldType2JavaType(fieldType).equals("String"))
			{

				propertySB
						.append("                                      renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {")
						.append(Tools.lineSeparator);
				propertySB
						.append("                                         var searchValue=store.getProxy().extraParams.key;")
						.append(Tools.lineSeparator);
				propertySB.append("                                         if( searchValue){")
						.append(Tools.lineSeparator);
				propertySB
						.append("                                             return value.replace(searchValue,\"<span style=background-color:yellow>\"+searchValue+\"</span>\");")
						.append(Tools.lineSeparator);
				propertySB.append("                                         }").append(Tools.lineSeparator);
				propertySB.append("                                         else{").append(Tools.lineSeparator);
				propertySB.append("                                             return value;")
						.append(Tools.lineSeparator);
				propertySB.append("                                         }").append(Tools.lineSeparator);
				propertySB.append("                                       },").append(Tools.lineSeparator);
			}
			propertySB.append("                                      dataIndex: '")
					.append(Tools.changeFieldName2JavaPropertyFieldName(fieldName)).append("',")
					.append(Tools.lineSeparator);
			if(Tools.changeFieldType2JavaType(fieldType).equals("String"))
			{
				propertySB.append("                                      text: '<font color=red>标题</font>',")
						.append(Tools.lineSeparator);
			}
			else
			{
				propertySB.append("                                      text: '标题',").append(Tools.lineSeparator);
			}
			propertySB.append("                                      tooltip: '标题',").append(Tools.lineSeparator);
			propertySB.append("                                      flex: 1").append(Tools.lineSeparator);

			index++;
			if(index < count)
			{
				propertySB.append("                                },").append(Tools.lineSeparator);
			}
			else
			{
				propertySB.append("                                }").append(Tools.lineSeparator);
			}
		}
		return propertySB.toString();
	}

}
