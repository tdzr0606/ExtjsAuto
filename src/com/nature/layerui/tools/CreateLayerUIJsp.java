package com.nature.layerui.tools;

import com.nature.extjs.tools.Tools;

import java.util.Map;

/**
 * ExtjsAuto
 * CreateLayerUIJsp
 *
 * @Author: 竺志伟
 * @Date: 2017-11-14 14:44
 */
public class CreateLayerUIJsp extends CreateBase
{

    public CreateLayerUIJsp(String filePath, String author, String className, String jspPath)
    {
        super.author = author;
        super.className = className;
        super.filePath = filePath + Tools.pathSeparator + "jsp" + Tools.pathSeparator + jspPath;
    }


    /**
     * 创建jsp页面
     *
     * @param tableContent
     */
    public void createLayuiJsp(Map<String, String> tableContent)
    {
        Tools.writeFile(filePath, Tools.smallFirstChar(className) + "Info.jsp", createJspContent(tableContent));
    }


    /**
     * 创建jsp内容
     *
     * @return
     */
    private String createJspContent(Map<String, String> tableContent)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<%--").append(Tools.lineSeparator);
        sb.append("   ").append(Tools.smallFirstChar(className)).append(Tools.lineSeparator);
        sb.append("   User:").append(author).append(Tools.lineSeparator);
        sb.append("   Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        sb.append("--%>").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>").append(Tools.lineSeparator);
        sb.append("<!DOCTYPE html>").append(Tools.lineSeparator);
        sb.append("<jsp:include page=\"../inc/head.jsp\" flush=\"true\"/>").append(Tools.lineSeparator);
        sb.append("<body>").append(Tools.lineSeparator);
        sb.append("<div class=\"layui-layout layui-layout-admin\">").append(Tools.lineSeparator);
        sb.append("    <jsp:include page=\"../inc/menu.jsp\" />").append(Tools.lineSeparator);
        sb.append("    <div class=\"layui-body\" style=\"padding:10px;min-height:600px;\">").append(Tools.lineSeparator);
        sb.append("        <fieldset class=\"layui-elem-field layui-field-title\"><legend>菜单</legend></fieldset>")
                .append(Tools.lineSeparator);
        sb.append("        <div id=\"").append(Tools.smallFirstChar(className))
                .append("MenuBar\"> " + "<!--将所有的菜单聚集在一起.一块进行监听-->").append(Tools.lineSeparator);
        sb.append("            <div class=\"layui-row\">").append(Tools.lineSeparator);
        sb.append("                <div class=\"layui-col-xs6\">").append(Tools.lineSeparator);
        sb.append("                    <div class=\"layui-btn-group\">").append(Tools.lineSeparator);
        sb.append("                <button class=\"layui-btn\" data-method=\"new\">新建</button>").append(Tools.lineSeparator);
        sb.append("                <button class=\"layui-btn\" data-method=\"modify\">修改</button>").append(Tools.lineSeparator);
        sb.append("                <button class=\"layui-btn\" data-method=\"delete\">删除</button>").append(Tools.lineSeparator);
        sb.append("                    </div>").append(Tools.lineSeparator);
        sb.append("               </div>").append(Tools.lineSeparator);
        sb.append("           <div class=\"layui-col-xs6\" style=\"text-align:right\">").append(Tools.lineSeparator);
        sb.append("               <div class=\"layui-inline\" style=\"width:70%\">").append(Tools.lineSeparator);
        sb.append("                  <input class=\"layui-input\" name=\"key\" id=\"searchKey\" " +
                "autocomplete=\"off\" style=\"width:100%;\">").append(Tools.lineSeparator);
        sb.append("                    <i class=\"layui-icon\" id=\"keyDelete\" ").append(Tools.lineSeparator);
        sb.append("                        style=\"position: absolute;right: 10px;top: 12px;cursor: pointer;display: " +
                "none\">&#x1006;</i> ").append(Tools.lineSeparator);
        sb.append("               </div>").append(Tools.lineSeparator);
        sb.append("               <button class=\"layui-btn\" data-method=\"search\" id=\"searchBtn\">搜索</button>")
                .append(Tools.lineSeparator);
        sb.append("           </div>").append(Tools.lineSeparator);
        sb.append("       </div>").append(Tools.lineSeparator);
        sb.append("     </div>").append(Tools.lineSeparator);
        sb.append("     <table class=\"layui-hidden\" id=\"").append(Tools.smallFirstChar(className))
                .append("Table\" " + "lay-filter=\"").append(Tools.smallFirstChar(className)).append("Table\"></table>")
                .append(Tools.lineSeparator);
        sb.append("  </div>").append(Tools.lineSeparator);
        sb.append("</div>").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append(createFormContent(tableContent));
        sb.append(Tools.lineSeparator);
        sb.append("<jsp:include page=\"../inc/foot.jsp\" />").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append(createJavaScriptContent(tableContent));
        sb.append(Tools.lineSeparator);
        sb.append("</body>").append(Tools.lineSeparator);
        sb.append("</html>").append(Tools.lineSeparator);
        return sb.toString();
    }

    /**
     * 创建Form表单内容
     *
     * @param tableContent
     * @return
     */
    private String createFormContent(Map<String, String> tableContent)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<form class=\"layui-form\" id=\"").append(Tools.smallFirstChar(className))
                .append("Form\" " + "style=\"display:none;" + "padding:10px 40px " + "10px " + "0px; \">")
                .append(Tools.lineSeparator);
        for(Map.Entry<String, String> entry : tableContent.entrySet())
        {
            sb.append("   <div class=\"layui-form-item\">").append(Tools.lineSeparator);
            sb.append("       <label class=\"layui-form-label\">字段名</label>").append(Tools.lineSeparator);
            sb.append("       <div class=\"layui-input-block\">").append(Tools.lineSeparator);
            sb.append("           <input type=\"text\" name=\"")
                    .append(Tools.changeFieldName2JavaPropertyFieldName(entry.getKey()))
                    .append("\" required " + "lay-verify=\"required\" placeholder=\"请输入字段名\" " +
                            "autocomplete=\"off\" class=\"layui-input\">").append(Tools.lineSeparator);
            sb.append("       </div>").append(Tools.lineSeparator);
            sb.append("   </div>").append(Tools.lineSeparator);
        }
        sb.append("   <input type=\"hidden\" name=\"id\" id=\"id\" value=\"0\"/>").append(Tools.lineSeparator);
        sb.append("   <input type=\"hidden\" name=\"actionUrl\" id=\"actionUrl\" value=\"\"/>").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("   <div class=\"layui-form-item\">").append(Tools.lineSeparator);
        sb.append("       <div class=\"layui-input-block\">").append(Tools.lineSeparator);
        sb.append("          <button class=\"layui-btn\" lay-submit lay-filter=\"").append(Tools.smallFirstChar(className))
                .append("Form\">确定</button>").append(Tools.lineSeparator);
        sb.append(
                "          <button type=\"reset\" class=\"layui-btn layui-btn-primary\" onclick=\"layer.closeAll()\">取消</button>")
                .append(Tools.lineSeparator);
        sb.append("       </div>").append(Tools.lineSeparator);
        sb.append("   </div>").append(Tools.lineSeparator);
        sb.append("</form>").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        return sb.toString();
    }


    /**
     * 创建javascirpt内容
     *
     * @param tableContent
     * @return
     */
    private String createJavaScriptContent(Map<String, String> tableContent)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">").append(Tools.lineSeparator);
        sb.append("  layui.use(['element', 'table', 'layer', 'form'], function () {").append(Tools.lineSeparator);
        sb.append("     var $ = layui.jquery;").append(Tools.lineSeparator);
        sb.append("     var table = layui.table;").append(Tools.lineSeparator);
        sb.append("     var layer = layui.layer;").append(Tools.lineSeparator);
        sb.append("     var form = layui.form;").append(Tools.lineSeparator);
        sb.append("     var ").append(Tools.smallFirstChar(className)).append("Table = table.render({")
                .append(Tools.lineSeparator);
        sb.append("        elem: '#").append(Tools.smallFirstChar(className)).append("Table'").append(Tools.lineSeparator);
        sb.append("        , id: '").append(Tools.smallFirstChar(className)).append("Table'").append(Tools.lineSeparator);
        sb.append("        , url: '/web/").append(Tools.smallFirstChar(className)).append("/list'")
                .append(Tools.lineSeparator);
        sb.append("        , cols: [[").append(Tools.lineSeparator);
        sb.append("           {checkbox: true, fixed: true}").append(Tools.lineSeparator);
        sb.append("           , {field: 'id', title: 'ID', width: 80, sort: true, fixed: true}").append(Tools.lineSeparator);
        for(Map.Entry<String, String> entry : tableContent.entrySet())
        {
            sb.append("           , {field: '").append(Tools.changeFieldName2JavaPropertyFieldName(entry.getKey()))
                    .append("', title: '字段名', width: 80, sort: true}").append(Tools.lineSeparator);
        }
        sb.append("       ]]").append(Tools.lineSeparator);
        sb.append("       , height: 'full-200'").append(Tools.lineSeparator);
        sb.append("       , limit: 40").append(Tools.lineSeparator);
        sb.append("       , page: true").append(Tools.lineSeparator);
        sb.append("     });").append(Tools.lineSeparator);
        sb.append("     //触发事件").append(Tools.lineSeparator);
        sb.append("     var active = {").append(Tools.lineSeparator);
        sb.append("         search: function () {").append(Tools.lineSeparator);
        sb.append("             var keyValue = $('#searchKey').val();").append(Tools.lineSeparator);
        sb.append("             ").append(Tools.smallFirstChar(className))
                .append("Table.reload({where: {key: " + "keyValue},page:{curr:1}});").append(Tools.lineSeparator);
        sb.append("         }").append(Tools.lineSeparator);
        sb.append("         , new: function () {").append(Tools.lineSeparator);
        sb.append("              $('#").append(Tools.smallFirstChar(className)).append("Form')[0].reset();")
                .append(Tools.lineSeparator);
        sb.append("              $('#actionUrl').val(\"new\");").append(Tools.lineSeparator);
        sb.append("              $('#id').val('0');").append(Tools.lineSeparator);
        sb.append("              layer.open({").append(Tools.lineSeparator);
        sb.append("                 type: 1").append(Tools.lineSeparator);
        sb.append("                 , title: \"新建\"").append(Tools.lineSeparator);
        sb.append("                 , closeBtn: 1").append(Tools.lineSeparator);
        sb.append("                 , area: '650px;'").append(Tools.lineSeparator);
        sb.append("                 , shade: 0.2").append(Tools.lineSeparator);
        sb.append("                 , shadeClose: false").append(Tools.lineSeparator);
        sb.append("                 , id: '").append(Tools.smallFirstChar(className)).append("FormWindow'")
                .append(Tools.lineSeparator);
        sb.append("                 , moveType: 1 ").append(Tools.lineSeparator);
        sb.append("                 , content: $('#").append(Tools.smallFirstChar(className)).append("Form')")
                .append(Tools.lineSeparator);
        sb.append("             });").append(Tools.lineSeparator);
        sb.append("        }").append(Tools.lineSeparator);
        sb.append("        , modify: function () {").append(Tools.lineSeparator);
        sb.append("             var checkStatus = table.checkStatus('").append(Tools.smallFirstChar(className))
                .append("Table'), data =" + " checkStatus" + ".data;").append(Tools.lineSeparator);
        sb.append("             if (data.length < 1){").append(Tools.lineSeparator);
        sb.append("                layer.msg('您必须选中一条需要修改的记录');").append(Tools.lineSeparator);
        sb.append("                return false;").append(Tools.lineSeparator);
        sb.append("             }").append(Tools.lineSeparator);
        sb.append("             else if (data.length > 1){").append(Tools.lineSeparator);
        sb.append("                layer.msg('您在修改的时候,不能选中多条记录');").append(Tools.lineSeparator);
        sb.append("                return false;").append(Tools.lineSeparator);
        sb.append("             }").append(Tools.lineSeparator);
        sb.append("             else {").append(Tools.lineSeparator);
        sb.append("                var id = data[0].id;").append(Tools.lineSeparator);
        sb.append("                $.ajax({").append(Tools.lineSeparator);
        sb.append("                    type: 'get',").append(Tools.lineSeparator);
        sb.append("                    url: '/web/").append(Tools.smallFirstChar(className))
                .append("/info?id=' + id + '&sessionId='+new Date().getTime(),").append(Tools.lineSeparator);
        sb.append("                    success: function (json) {").append(Tools.lineSeparator);
        sb.append("                       if (json.success){").append(Tools.lineSeparator);
        sb.append("                           form.loadData(json.data, '").append(Tools.smallFirstChar(className))
                .append("Form');").append(Tools.lineSeparator);
        sb.append("                           $('#actionUrl').val(\"modify\"); ").append(Tools.lineSeparator);
        sb.append("                           form.render();").append(Tools.lineSeparator);
        sb.append("                           layer.open({").append(Tools.lineSeparator);
        sb.append("                               type: 1").append(Tools.lineSeparator);
        sb.append("                               , title: \"修改\"").append(Tools.lineSeparator);
        sb.append("                               , closeBtn: 1").append(Tools.lineSeparator);
        sb.append("                               , area: '650px;'").append(Tools.lineSeparator);
        sb.append("                               , shade: 0.2").append(Tools.lineSeparator);
        sb.append("                               , shadeClose: false").append(Tools.lineSeparator);
        sb.append("                               , id: '").append(Tools.smallFirstChar(className)).append("FormWindow'")
                .append(Tools.lineSeparator);
        sb.append("                               , moveType: 1").append(Tools.lineSeparator);
        sb.append("                               , content: $('#").append(Tools.smallFirstChar(className)).append("Form')")
                .append(Tools.lineSeparator);
        sb.append("                               , success: function (layero) {").append(Tools.lineSeparator);
        sb.append("                               }").append(Tools.lineSeparator);
        sb.append("                           });").append(Tools.lineSeparator);
        sb.append("                       }").append(Tools.lineSeparator);
        sb.append("                       else {").append(Tools.lineSeparator);
        sb.append("                           layer.msg(json.msg);").append(Tools.lineSeparator);
        sb.append("                       }").append(Tools.lineSeparator);
        sb.append("                    },").append(Tools.lineSeparator);
        sb.append("                    error: function (json) {").append(Tools.lineSeparator);
        sb.append("                       layer.alert(\"未知的错误！\", {closeBtn: 0}, function () {").append(Tools.lineSeparator);
        sb.append("                           layer.closeAll();").append(Tools.lineSeparator);
        sb.append("                       });").append(Tools.lineSeparator);
        sb.append("                    }").append(Tools.lineSeparator);
        sb.append("                });").append(Tools.lineSeparator);
        sb.append("             }").append(Tools.lineSeparator);
        sb.append("        }").append(Tools.lineSeparator);
        sb.append("        , delete: function () {").append(Tools.lineSeparator);
        sb.append("             var checkStatus = table.checkStatus('").append(Tools.smallFirstChar(className))
                .append("Table'), data =" + " checkStatus" + ".data;").append(Tools.lineSeparator);
        sb.append("             if (data.length < 1){").append(Tools.lineSeparator);
        sb.append("                layer.msg('您必须最少选中一条需要删除的记录');").append(Tools.lineSeparator);
        sb.append("                return false;").append(Tools.lineSeparator);
        sb.append("             }").append(Tools.lineSeparator);
        sb.append("             layer.open({").append(Tools.lineSeparator);
        sb.append("                 type: 1").append(Tools.lineSeparator);
        sb.append("                 , id: '").append(Tools.smallFirstChar(className)).append("DeleteAccept'")
                .append(Tools.lineSeparator);
        sb.append("                 , content: '<div style=\"padding: 20px 30px;\">是否真的要删除选中的记录?</div>'")
                .append(Tools.lineSeparator);
        sb.append("                 , btn: ['确定', '取消']").append(Tools.lineSeparator);
        sb.append("                 , btnAlign: 'c' ").append(Tools.lineSeparator);
        sb.append("                 , shade: 0.2 ").append(Tools.lineSeparator);
        sb.append("                 , yes: function () {").append(Tools.lineSeparator);
        sb.append("                      layer.closeAll();").append(Tools.lineSeparator);
        sb.append("                      var idArray = new Array();").append(Tools.lineSeparator);
        sb.append("                      for (var i = 0; i < data.length; i++){").append(Tools.lineSeparator);
        sb.append("                          idArray[i] = data[i].id;").append(Tools.lineSeparator);
        sb.append("                      }").append(Tools.lineSeparator);
        sb.append("                      $.ajax({").append(Tools.lineSeparator);
        sb.append("                          type: 'post',").append(Tools.lineSeparator);
        sb.append("                          data: {ids: idArray.toString()},").append(Tools.lineSeparator);
        sb.append("                          url: '/web/").append(Tools.smallFirstChar(className)).append("/delete',")
                .append(Tools.lineSeparator);
        sb.append("                          success: function (json) {").append(Tools.lineSeparator);
        sb.append("                              if (json.success) {").append(Tools.lineSeparator);
        sb.append("                                  layer.alert(json.msg, {closeBtn: 0}, function () {")
                .append(Tools.lineSeparator);
        sb.append("                                      layer.closeAll();").append(Tools.lineSeparator);
        sb.append("                                      ").append(Tools.smallFirstChar(className))
                .append("Table" + ".reload(); ").append(Tools.lineSeparator);
        sb.append("                                  });").append(Tools.lineSeparator);
        sb.append("                              }").append(Tools.lineSeparator);
        sb.append("                              else {").append(Tools.lineSeparator);
        sb.append("                                  layer.alert(json.msg);").append(Tools.lineSeparator);
        sb.append("                              }").append(Tools.lineSeparator);
        sb.append("                          },").append(Tools.lineSeparator);
        sb.append("                          error: function (json) {").append(Tools.lineSeparator);
        sb.append("                             layer.alert(\"登录超时,请重新登录！\", {closeBtn: 0}, function () {")
                .append(Tools.lineSeparator);
        sb.append("                                  layer.closeAll();").append(Tools.lineSeparator);
        sb.append("                                  window.location.reload();").append(Tools.lineSeparator);
        sb.append("                              });").append(Tools.lineSeparator);
        sb.append("                          }").append(Tools.lineSeparator);
        sb.append("                      });").append(Tools.lineSeparator);
        sb.append("                      return false;").append(Tools.lineSeparator);
        sb.append("                 }").append(Tools.lineSeparator);
        sb.append("             });").append(Tools.lineSeparator);
        sb.append("       }").append(Tools.lineSeparator);
        sb.append("     };").append(Tools.lineSeparator);
        sb.append("     //总体上调用,是那个按钮激活哪个").append(Tools.lineSeparator);
        sb.append("     $('#").append(Tools.smallFirstChar(className))
                .append("MenuBar .layui-btn').on('click', " + "function () {").append(Tools.lineSeparator);
        sb.append("           var othis = $(this), method = othis.data('method');").append(Tools.lineSeparator);
        sb.append("           active[method] ? active[method].call(this, othis) : '';").append(Tools.lineSeparator);
        sb.append("     });").append(Tools.lineSeparator);

        sb.append("     // 搜索框 回车键触发  ").append(Tools.lineSeparator);
        sb.append("     $('#searchKey').on('keydown',function (e){ ").append(Tools.lineSeparator);
        sb.append("       if(e.keyCode == 13) { ").append(Tools.lineSeparator);
        sb.append("            $('#searchBtn').click(); ").append(Tools.lineSeparator);
        sb.append("       }").append(Tools.lineSeparator);
        sb.append("     });").append(Tools.lineSeparator);

        sb.append("     $('#searchKey').on('keyup', function (e) {").append(Tools.lineSeparator);
        sb.append("         if ($(this).val()) { $('#keyDelete').show(); } ").append(Tools.lineSeparator);
        sb.append("         else { $('#keyDelete').hide(); } ").append(Tools.lineSeparator);
        sb.append("     });").append(Tools.lineSeparator);
        sb.append("     if ($('#searchKey').val()) { $('#keyDelete').show(); } ").append(Tools.lineSeparator);

        sb.append("     $('#keyDelete').on('click', function (){ ").append(Tools.lineSeparator);
        sb.append("         $('#keyDelete').hide(); ").append(Tools.lineSeparator);
        sb.append("         $('#searchKey').val(''); ").append(Tools.lineSeparator);
        sb.append("         $('#searchBtn').click(); ").append(Tools.lineSeparator);
        sb.append("     }); ").append(Tools.lineSeparator);

        sb.append("     //form submit新建修改事件提交").append(Tools.lineSeparator);
        sb.append("     form.on('submit(").append(Tools.smallFirstChar(className)).append("Form)', function (data) {")
                .append(Tools.lineSeparator);
        sb.append("        var actionUrl = \"/web/").append(Tools.smallFirstChar(className))
                .append("/\" + $" + "('#actionUrl').val();").append(Tools.lineSeparator);
        sb.append("        $.ajax({").append(Tools.lineSeparator);
        sb.append("            type: 'post',").append(Tools.lineSeparator);
        sb.append("            data: $('#").append(Tools.smallFirstChar(className)).append("Form').serialize(),")
                .append(Tools.lineSeparator);
        sb.append("            url: actionUrl,").append(Tools.lineSeparator);
        sb.append("            success: function (json) {").append(Tools.lineSeparator);
        sb.append("               if (json.success) {").append(Tools.lineSeparator);
        sb.append("                  layer.alert(json.msg, {closeBtn: 0}, function () {").append(Tools.lineSeparator);
        sb.append("                      layer.closeAll();").append(Tools.lineSeparator);
        sb.append("                      ").append(Tools.smallFirstChar(className)).append("Table.reload(); ")
                .append(Tools.lineSeparator);
        sb.append("                  });").append(Tools.lineSeparator);
        sb.append("               }").append(Tools.lineSeparator);
        sb.append("               else {").append(Tools.lineSeparator);
        sb.append("                  layer.alert(json.msg);").append(Tools.lineSeparator);
        sb.append("               }").append(Tools.lineSeparator);
        sb.append("            },").append(Tools.lineSeparator);
        sb.append("            error: function (json) {").append(Tools.lineSeparator);
        sb.append("               layer.alert(\"登录超时,请重新登录！\", {closeBtn: 0}, function () {").append(Tools.lineSeparator);
        sb.append("                  layer.closeAll();").append(Tools.lineSeparator);
        sb.append("                  window.location.reload();").append(Tools.lineSeparator);
        sb.append("               });").append(Tools.lineSeparator);
        sb.append("            }").append(Tools.lineSeparator);
        sb.append("          });").append(Tools.lineSeparator);
        sb.append("          return false;").append(Tools.lineSeparator);
        sb.append("        });").append(Tools.lineSeparator);
        sb.append("     });").append(Tools.lineSeparator);
        sb.append("</script>").append(Tools.lineSeparator);
        return sb.toString();
    }
}
