package com.nature.extjs.tools;

/**
 * 创建Extjs 控制文件
 * 
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月5日 下午9:59:33
 */
public class CreateControllerJS extends CreateBase
{
	public CreateControllerJS(String className, String filePath,String author)
	{
		super.author = author;
		super.className = className;
		super.filePath = filePath + Tools.pathSeparator + "app" + Tools.pathSeparator + "controller";
	}

	public void createControllerJs()
	{
		Tools.writeFile(filePath, className + "Ctl.js", createControllerContent());
	}

	/**
	 * 创建控制文件
	 * 
	 * @return
	 * @author 竺志伟
	 * @email tdzr_0606@126.com
	 * @date 2017年3月5日 下午10:04:11
	 */
	private String createControllerContent()
	{
		StringBuffer contentSB = new StringBuffer();
		contentSB.append("/**").append(Tools.lineSeparator);
		contentSB.append(" * ").append(className).append("Ctl 控制文件").append(Tools.lineSeparator);
		contentSB.append(" * Author:").append(author).append(Tools.lineSeparator);
		contentSB.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
		contentSB.append("*/").append(Tools.lineSeparator);
		contentSB.append("Ext.define('wbkj.controller.").append(className).append("Ctl', {")
				.append(Tools.lineSeparator);
		contentSB.append("     extend: 'Ext.app.Controller',").append(Tools.lineSeparator);
		contentSB.append("     stores: [").append(Tools.lineSeparator);
		contentSB.append("          '").append(Tools.smallFirstChar(className)).append(".").append(className)
				.append("Store'").append(Tools.lineSeparator);
		contentSB.append("     ],").append(Tools.lineSeparator);
		contentSB.append("     views: [").append(Tools.lineSeparator);
		contentSB.append("          '").append(Tools.smallFirstChar(className)).append(".").append(className)
				.append("MainView',").append(Tools.lineSeparator);
		contentSB.append("          '").append(Tools.smallFirstChar(className)).append(".").append(className)
				.append("RightMenu',").append(Tools.lineSeparator);
		contentSB.append("          '").append(Tools.smallFirstChar(className)).append(".").append(className)
				.append("Form'").append(Tools.lineSeparator);
		contentSB.append("     ],").append(Tools.lineSeparator);
		contentSB.append("     refs: [").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'grid',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("MainView'").append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              autoCreate: true,").append(Tools.lineSeparator);
		contentSB.append("              ref: 'rightMenu',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("RightMenu',")
				.append(Tools.lineSeparator);
		contentSB.append("              xtype: '").append(className).append("RightMenu'").append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'newMenuitem',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("MainView #new'")
				.append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'newRightitem',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("RightMenu #new'")
				.append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'modifyMenuitem',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("MainView #modify'")
				.append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'modifyRightitem',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("RightMenu #modify'")
				.append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'deleteMenuitem',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("MainView #delete'")
				.append(Tools.lineSeparator);
		contentSB.append("          },").append(Tools.lineSeparator);
		contentSB.append("          {").append(Tools.lineSeparator);
		contentSB.append("              ref: 'deleteRightitem',").append(Tools.lineSeparator);
		contentSB.append("              selector: '").append(className).append("RightMenu #delete'")
				.append(Tools.lineSeparator);
		contentSB.append("          }").append(Tools.lineSeparator);
		contentSB.append("     ],").append(Tools.lineSeparator);
		contentSB.append("     onNewClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("         this.onWinFormNew(\"wbkj.view.").append(Tools.smallFirstChar(className))
				.append(".").append(className).append("Form\",\"新建\",\"new\");").append(Tools.lineSeparator);
		contentSB.append("     },").append(Tools.lineSeparator);
		contentSB.append("     onModifyClick: function(target) {").append(Tools.lineSeparator);
		contentSB.append("         this.onWinFormNew(\"wbkj.view.").append(Tools.smallFirstChar(className))
				.append(".").append(className).append("Form\",\"修改\",\"modify\");").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onDeleteClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        var gridTemp=this.getGrid();").append(Tools.lineSeparator);
		contentSB.append("        var selectRecorder=gridTemp.getSelectionModel().getSelection();").append(
				Tools.lineSeparator);
		contentSB.append("        Ext.MessageBox.buttonText.yes = \"确定\";").append(Tools.lineSeparator);
		contentSB.append("        Ext.MessageBox.buttonText.no = \"取消\";").append(Tools.lineSeparator);
		contentSB.append("        Ext.MessageBox.buttonText.ok = \"确定\";").append(Tools.lineSeparator);
		contentSB.append("        Ext.MessageBox.confirm(\"提示\", \"您是否真的要删除当前数据吗?\", function (btn) {").append(
				Tools.lineSeparator);
		contentSB.append("            if(btn=='yes'){").append(Tools.lineSeparator);
		contentSB.append("                Ext.MessageBox.show({").append(Tools.lineSeparator);
		contentSB.append("                    msg: '正在删除数据,请稍候...',").append(Tools.lineSeparator);
		contentSB.append("                    progressText: '删除中...',").append(Tools.lineSeparator);
		contentSB.append("                    width:300,").append(Tools.lineSeparator);
		contentSB.append("                    wait:true,").append(Tools.lineSeparator);
		contentSB.append("                    waitConfig: {interval:200},").append(Tools.lineSeparator);
		contentSB.append("                    iconHeight: 50").append(Tools.lineSeparator);
		contentSB.append("               });").append(Tools.lineSeparator);
		contentSB.append("               Ext.Ajax.request({").append(Tools.lineSeparator);
		contentSB.append("                    url : '/wbkj/").append(Tools.smallFirstChar(className))
				.append("/delete',").append(Tools.lineSeparator);
		contentSB.append("                    method : 'post',").append(Tools.lineSeparator);
		contentSB.append("                    params : {").append(Tools.lineSeparator);
		contentSB.append("                         id : selectRecorder[0].getId()").append(Tools.lineSeparator);
		contentSB.append("                    },").append(Tools.lineSeparator);
		contentSB.append("                    success : function(response, options) {").append(Tools.lineSeparator);
		contentSB.append("                         Ext.MessageBox.hide();").append(Tools.lineSeparator);
		contentSB.append("                         var result=Ext.JSON.decode(response.responseText);").append(
				Tools.lineSeparator);
		contentSB.append("                         if(result.success){").append(Tools.lineSeparator);
		contentSB.append("                               Ext.Msg.alert('成功', result.message);").append(
				Tools.lineSeparator);
		contentSB.append("                               gridTemp.getStore().load();").append(Tools.lineSeparator);
		contentSB.append("                         }").append(Tools.lineSeparator);
		contentSB.append("                         else{").append(Tools.lineSeparator);
		contentSB.append("                              Ext.Msg.alert('失败', result.message);").append(
				Tools.lineSeparator);
		contentSB.append("                         }").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("              failure : function(response, optionss) {").append(Tools.lineSeparator);
		contentSB.append("                    Ext.Msg.alert('失败', Ext.JSON.decode(response.responseText).message);")
				.append(Tools.lineSeparator);
		contentSB.append("              }").append(Tools.lineSeparator);
		contentSB.append("          });").append(Tools.lineSeparator);
		contentSB.append("       }").append(Tools.lineSeparator);
		contentSB.append("     });").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onRefreshClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("         this.getGrid().getStore().reload();").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onWinForm_okClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("         this.onWinFormSubmit(button, e, eOpts);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onWinForm_cancelClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        button.up('window').close();").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onRightNewClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        this.onNewClick(button, e, eOpts);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onRightModifyClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        this.onModifyClick(button, e, eOpts);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onRightDeleteClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("       this.onDeleteClick(button, e, eOpts);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onRightRefreshClick: function(button, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        this.onRefreshClick(button, e, eOpts);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onGridpanelSelect: function(rowmodel, record, index, eOpts) {").append(
				Tools.lineSeparator);
		contentSB.append("       this.changeMenuStatus(record);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onGridpanelItemContextMenu: function(dataview, record, item, index, e, eOpts) {").append(
				Tools.lineSeparator);
		contentSB.append("       e.preventDefault();").append(Tools.lineSeparator);
		contentSB.append("       this.getRightMenu().showAt(e.getXY());").append(Tools.lineSeparator);
		contentSB.append("       this.changeMenuStatus(record);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onTriggerfieldSearch: function(obj, eventOptions) {").append(Tools.lineSeparator);
		contentSB.append("       var key=obj.getValue();").append(Tools.lineSeparator);
		contentSB.append("       var gird=obj.up(\"").append(className).append("MainView\");")
				.append(Tools.lineSeparator);
		contentSB.append("       var store=gird.getStore();").append(Tools.lineSeparator);
		contentSB.append("       store.getProxy().extraParams={key:key};").append(Tools.lineSeparator);
		contentSB.append("       store.loadPage(1);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onTriggerfieldKeydown: function(textfield, e, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        if(e.getKey()==Ext.EventObject.ENTER){").append(Tools.lineSeparator);
		contentSB.append("            textfield.fireEvent('search',textfield);").append(Tools.lineSeparator);
		contentSB.append("        }").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onPanelBeforeRender: function(component, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        var temp1=Ext.create(").append(Tools.lineSeparator);
		contentSB.append("            \"wbkj.view.").append(Tools.smallFirstChar(className)).append(".")
				.append(className).append("RightMenu\",{").append(Tools.lineSeparator);
		contentSB.append("             panelId:component.panelId").append(Tools.lineSeparator);
		contentSB.append("        });").append(Tools.lineSeparator);
		contentSB.append("        component.getStore().load();").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onPanelBeforeshow: function(component, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        wbkj.controller.MainCtl.rightControl(component);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onRightMenuBeforeShow: function(component, eOpts) {").append(Tools.lineSeparator);
		contentSB.append("        wbkj.controller.MainCtl.rightControl(component);").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    changeMenuStatus: function(record) {").append(Tools.lineSeparator);
		contentSB.append("        this.getRightMenu();").append(Tools.lineSeparator);
		contentSB.append("        this.getModifyMenuitem().setDisabled(true);").append(Tools.lineSeparator);
		contentSB.append("        this.getModifyRightitem().setDisabled(true);").append(Tools.lineSeparator);
		contentSB.append("        this.getDeleteMenuitem().setDisabled(true);").append(Tools.lineSeparator);
		contentSB.append("        this.getDeleteRightitem().setDisabled(true);").append(Tools.lineSeparator);
		contentSB.append("        if(record){").append(Tools.lineSeparator);
		contentSB.append("            this.getModifyMenuitem().setDisabled(false);").append(Tools.lineSeparator);
		contentSB.append("            this.getModifyRightitem().setDisabled(false);").append(Tools.lineSeparator);
		contentSB.append("            this.getDeleteMenuitem().setDisabled(false);").append(Tools.lineSeparator);
		contentSB.append("            this.getDeleteRightitem().setDisabled(false);").append(Tools.lineSeparator);
		contentSB.append("       }").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onWinFormNew: function(formClass, title, actionDo) {").append(Tools.lineSeparator);
		contentSB.append("        var temp=Ext.create(formClass,{title:title,actionDo:actionDo});").append(
				Tools.lineSeparator);
		contentSB.append("        temp.show();").append(Tools.lineSeparator);
		contentSB.append("        if(actionDo==\"modify\"){").append(Tools.lineSeparator);
		contentSB.append("           var selectRecord=this.getGrid().getSelectionModel().getSelection()[0];").append(
				Tools.lineSeparator);
		contentSB.append("           temp.down('form').getForm().load({").append(Tools.lineSeparator);
		contentSB.append("                url:'/wbkj/").append(Tools.smallFirstChar(className)).append("/data',")
				.append(Tools.lineSeparator);
		contentSB.append("                params:{id: selectRecord.data.id}").append(Tools.lineSeparator);
		contentSB.append("           });").append(Tools.lineSeparator);
		contentSB.append("        }").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    onWinFormSubmit: function(button, event, eventOption) {").append(Tools.lineSeparator);
		contentSB.append("        var gridTemp=this.getGrid();").append(Tools.lineSeparator);
		contentSB.append("        var selectRecord=this.getGrid().getSelectionModel().getSelection()[0];").append(
				Tools.lineSeparator);
		contentSB.append("        var actionDo=button.up('window').actionDo;").append(Tools.lineSeparator);
		contentSB.append("        var formPanel=button.up('window').down('form');").append(Tools.lineSeparator);
		contentSB.append("        Ext.MessageBox.show({").append(Tools.lineSeparator);
		contentSB.append("            msg: '正在保存数据,请稍候...',").append(Tools.lineSeparator);
		contentSB.append("            progressText: '保存中...',").append(Tools.lineSeparator);
		contentSB.append("            width:300,").append(Tools.lineSeparator);
		contentSB.append("            wait:true,").append(Tools.lineSeparator);
		contentSB.append("            waitConfig: {interval:200},").append(Tools.lineSeparator);
		contentSB.append("            iconHeight: 50").append(Tools.lineSeparator);
		contentSB.append("        });").append(Tools.lineSeparator);
		contentSB.append("        formPanel.getForm().submit({").append(Tools.lineSeparator);
		contentSB.append("           clientValidation: true,").append(Tools.lineSeparator);
		contentSB.append("           url: '/wbkj/").append(Tools.smallFirstChar(className)).append("/'+actionDo,")
				.append(Tools.lineSeparator);
		contentSB.append("           params: { actionDo:actionDo },").append(Tools.lineSeparator);
		contentSB.append("           submitEmptyText:false,").append(Tools.lineSeparator);
		contentSB.append("           success: function(form, action) {").append(Tools.lineSeparator);
		contentSB.append("               Ext.MessageBox.hide();").append(Tools.lineSeparator);
		contentSB.append("               Ext.Msg.alert('提示', action.result.message);").append(Tools.lineSeparator);
		contentSB.append("               gridTemp.getStore().load();").append(Tools.lineSeparator);
		contentSB.append("               button.up('window').close();").append(Tools.lineSeparator);
		contentSB.append("           },").append(Tools.lineSeparator);
		contentSB.append("           failure: function(form, action) {").append(Tools.lineSeparator);
		contentSB.append("               Ext.MessageBox.hide();").append(Tools.lineSeparator);
		contentSB.append("               switch (action.failureType) {").append(Tools.lineSeparator);
		contentSB.append("                   case Ext.form.action.Action.CLIENT_INVALID:").append(Tools.lineSeparator);
		contentSB.append("                          Ext.MessageBox.alert('失败', '有不符合要求的表单数据');").append(Tools.lineSeparator);
		contentSB.append("                          break;").append(Tools.lineSeparator);
		contentSB.append("                   case Ext.form.action.Action.CONNECT_FAILURE:").append(Tools.lineSeparator);
		contentSB.append("                          Ext.MessageBox.alert('失败', 'Ajax提交失败');").append(Tools.lineSeparator);
		contentSB.append("                          break;").append(Tools.lineSeparator);
		contentSB.append("                   case Ext.form.action.Action.SERVER_INVALID:").append(Tools.lineSeparator);
		contentSB.append("                          Ext.MessageBox.alert('失败', action.result.message);").append(Tools.lineSeparator);
		contentSB.append("               }").append(Tools.lineSeparator);
		contentSB.append("           }").append(Tools.lineSeparator);
		contentSB.append("       });").append(Tools.lineSeparator);
		contentSB.append("    },").append(Tools.lineSeparator);
		contentSB.append("    init: function(application) {").append(Tools.lineSeparator);
		contentSB.append("        this.control({").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("MainView #new\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onNewClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("MainView #modify\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onModifyClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("MainView #delete\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onDeleteClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("MainView #refresh\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onRefreshClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("Form #myForm_ok\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onWinForm_okClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("Form #myForm_cancel\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onWinForm_cancelClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("RightMenu #new\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onRightNewClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("RightMenu #modify\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onRightModifyClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("RightMenu #delete\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onRightDeleteClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("RightMenu #refresh\": {").append(Tools.lineSeparator);
		contentSB.append("                 click: this.onRightRefreshClick").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("MainView\": {").append(Tools.lineSeparator);
		contentSB.append("                 select: this.onGridpanelSelect,").append(Tools.lineSeparator);
		contentSB.append("                 itemcontextmenu: this.onGridpanelItemContextMenu,").append(Tools.lineSeparator);
		contentSB.append("                 beforerender: this.onPanelBeforeRender,").append(Tools.lineSeparator);
		contentSB.append("                 beforeshow: this.onPanelBeforeshow").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("MainView #search\": {").append(Tools.lineSeparator);
		contentSB.append("                 search: this.onTriggerfieldSearch,").append(Tools.lineSeparator);
		contentSB.append("                 keydown: this.onTriggerfieldKeydown").append(Tools.lineSeparator);
		contentSB.append("              },").append(Tools.lineSeparator);
		contentSB.append("             \"").append(className).append("RightMenu\": {").append(Tools.lineSeparator);
		contentSB.append("                 beforeshow: this.onRightMenuBeforeShow").append(Tools.lineSeparator);
		contentSB.append("              }").append(Tools.lineSeparator);
		contentSB.append("       });").append(Tools.lineSeparator);
		contentSB.append("    }").append(Tools.lineSeparator);
		contentSB.append(" });").append(Tools.lineSeparator);
		return contentSB.toString();
	}
}
