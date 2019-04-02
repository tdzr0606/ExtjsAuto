package com.nature.layerui.tools;

import com.nature.extjs.tools.CreateBase;
import com.nature.extjs.tools.Tools;

/**
 * 创建 java 控制
 *
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月6日 下午10:21:54
 */
public class CreateController extends CreateBase
{
    private String packageName;
    private String projectName;
    private String jspPath;

    public CreateController(String className, String filePath, String packageName, String projectName, String author,
                            String jspPath)
    {
        super.author = author;
        super.className = className;
        super.filePath = filePath + Tools.pathSeparator + "java" + Tools.pathSeparator + "controller" + Tools.pathSeparator +
                projectName;
        this.packageName = packageName;
        this.projectName = projectName;
        this.jspPath = jspPath;
    }

    public void createController()
    {
        Tools.writeFile(filePath, className + "Controller.java", createControllerContent());
    }

    /**
     * 创建文件内容
     *
     * @return
     * @author 竺志伟
     * @email tdzr_0606@126.com
     * @date 2017年3月6日 下午10:27:16
     */
    private String createControllerContent()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(packageName).append(".controller.").append(projectName).append(";")
                .append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("import javax.servlet.http.HttpServletRequest;").append(Tools.lineSeparator);
        sb.append("import ").append(packageName).append(".controller.system.BaseController;").append(Tools.lineSeparator);
        sb.append("import ").append(packageName).append(".pojo.system.CommonResult;").append(Tools.lineSeparator);
        sb.append("import ").append(packageName).append(".pojo.system.Page;").append(Tools.lineSeparator);
        sb.append("import org.springframework.beans.factory.annotation.Autowired;").append(Tools.lineSeparator);
        sb.append("import org.springframework.stereotype.Controller;").append(Tools.lineSeparator);
        sb.append("import org.springframework.web.bind.annotation.RequestMapping;").append(Tools.lineSeparator);
        sb.append("import org.springframework.web.bind.annotation.RequestMethod;").append(Tools.lineSeparator);
        sb.append("import org.springframework.web.bind.annotation.RequestParam;").append(Tools.lineSeparator);
        sb.append("import org.springframework.web.bind.annotation.ResponseBody;").append(Tools.lineSeparator);
        sb.append("import ").append(packageName).append(".service.").append(projectName).append(".").append(className)
                .append("Service").append(";").append(Tools.lineSeparator);
        sb.append("import ").append(packageName).append(".pojo.").append(projectName).append(".").append(className).append(";")
                .append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("/**").append(Tools.lineSeparator);
        sb.append(" * ").append(Tools.lineSeparator);
        sb.append(" * ").append(className).append("控制").append(Tools.lineSeparator);
        sb.append(" * ").append(className).append("Controller").append(Tools.lineSeparator);
        sb.append(" * Author:").append(author).append(Tools.lineSeparator);
        sb.append(" * Date:").append(Tools.getNowDateTime()).append(Tools.lineSeparator);
        sb.append(" */").append(Tools.lineSeparator);
        sb.append("@Controller").append(Tools.lineSeparator);
        sb.append("public class ").append(className).append("Controller extends BaseController").append(Tools.lineSeparator);
        sb.append("{").append(Tools.lineSeparator);
        sb.append("    @Autowired").append(Tools.lineSeparator);
        sb.append("    HttpServletRequest request;").append(Tools.lineSeparator);
        sb.append("    @Autowired").append(Tools.lineSeparator);
        sb.append("    ").append(className).append("Service ").append(Tools.smallFirstChar(className)).append("Service;")
                .append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("    private final Integer borderId = 0;");
        sb.append(Tools.lineSeparator);
        sb.append("    /**").append(Tools.lineSeparator);
        sb.append("      * 进入页面").append(Tools.lineSeparator);
        sb.append("      *").append(Tools.lineSeparator);
        sb.append("      * @return").append(Tools.lineSeparator);
        sb.append("      */").append(Tools.lineSeparator);
        sb.append("    @RequestMapping(value=\"/web/").append(Tools.smallFirstChar(className)).append("/toPage\")")
                .append(Tools.lineSeparator);
        sb.append("    public String toPage()").append(Tools.lineSeparator);
        sb.append("    {").append(Tools.lineSeparator);
        sb.append("       return \"").append(jspPath).append("/").append(Tools.smallFirstChar(className)).append("Info_jsp\";")
                .append(Tools.lineSeparator);
        sb.append("    }").append(Tools.lineSeparator);
        sb.append("    /**").append(Tools.lineSeparator);
        sb.append("     * 获取分页信息").append(Tools.lineSeparator);
        sb.append("     *").append(Tools.lineSeparator);
        sb.append("     * @param page").append(Tools.lineSeparator);
        sb.append("     * @param limit").append(Tools.lineSeparator);
        sb.append("     * @param key").append(Tools.lineSeparator);
        sb.append("     * @return").append(Tools.lineSeparator);
        sb.append("     */").append(Tools.lineSeparator);
        sb.append("    @RequestMapping(value = \"/web/").append(Tools.smallFirstChar(className)).append("/list\")")
                .append(Tools.lineSeparator);
        sb.append("    @ResponseBody").append(Tools.lineSeparator);
        sb.append("    public Page<").append(className).append("> findPage(").append(Tools.lineSeparator);
        sb.append("            @RequestParam(value = \"page\", required = true, defaultValue = \"1\") Integer " + "page,")
                .append(Tools.lineSeparator);
        sb.append("            @RequestParam(value = \"limit\", required = true, defaultValue = \"40\") Integer " + "limit,")
                .append(Tools.lineSeparator);
        sb.append("            @RequestParam(value = \"key\", required = false, defaultValue = \"\") String key)")
                .append(Tools.lineSeparator);
        sb.append("    {").append(Tools.lineSeparator);
        sb.append("        return ").append(Tools.smallFirstChar(className)).append("Service.listPage(page, limit, key);")
                .append(Tools.lineSeparator);
        sb.append("    }").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("    /**").append(Tools.lineSeparator);
        sb.append("     * 添加信息").append(Tools.lineSeparator);
        sb.append("     *").append(Tools.lineSeparator);
        sb.append("     * @param ").append(Tools.smallFirstChar(className)).append(Tools.lineSeparator);
        sb.append("     * @return").append(Tools.lineSeparator);
        sb.append("     */").append(Tools.lineSeparator);
        sb.append("    @RequestMapping(value = \"/web/").append(Tools.smallFirstChar(className)).append("/new\")")
                .append(Tools.lineSeparator);
        sb.append("    @ResponseBody").append(Tools.lineSeparator);
        sb.append("    public CommonResult add(").append(className).append(" ").append(Tools.smallFirstChar(className))
                .append(")").append(Tools.lineSeparator);
        sb.append("    {").append(Tools.lineSeparator);
        sb.append("        return resultBoolWrapper(").append(Tools.smallFirstChar(className)).append("Service.addNew(")
                .append(Tools.smallFirstChar(className)).append("), \"信息创建成功\", \"信息创建失败\", null);")
                .append(Tools.lineSeparator);
        sb.append("    }").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("    /**").append(Tools.lineSeparator);
        sb.append("     * 修改信息").append(Tools.lineSeparator);
        sb.append("     *").append(Tools.lineSeparator);
        sb.append("     * @param ").append(Tools.smallFirstChar(className)).append(Tools.lineSeparator);
        sb.append("     * @return").append(Tools.lineSeparator);
        sb.append("     */").append(Tools.lineSeparator);
        sb.append("    @RequestMapping(value = \"/web/").append(Tools.smallFirstChar(className)).append("/modify\")")
                .append(Tools.lineSeparator);
        sb.append("    @ResponseBody").append(Tools.lineSeparator);
        sb.append("    public CommonResult modify(").append(className).append(" ").append(Tools.smallFirstChar(className))
                .append(")").append(Tools.lineSeparator);
        sb.append("    {").append(Tools.lineSeparator);
        sb.append("        return resultBoolWrapper(").append(Tools.smallFirstChar(className)).append("Service.modify(")
                .append(Tools.smallFirstChar(className)).append("), \"信息修改成功\", \"信息修改失败\", null);")
                .append(Tools.lineSeparator);
        sb.append("    }").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("    /**").append(Tools.lineSeparator);
        sb.append("     * 删除信息").append(Tools.lineSeparator);
        sb.append("     *").append(Tools.lineSeparator);
        sb.append("     * @param ids").append(Tools.lineSeparator);
        sb.append("     * @return").append(Tools.lineSeparator);
        sb.append("     */").append(Tools.lineSeparator);
        sb.append("    @RequestMapping(value = \"/web/").append(Tools.smallFirstChar(className)).append("/delete\")")
                .append(Tools.lineSeparator);
        sb.append("    @ResponseBody").append(Tools.lineSeparator);
        sb.append("    public CommonResult delete(").append(Tools.lineSeparator);
        sb.append("            @RequestParam(value = \"ids\", required = true, defaultValue = \"0\") String ids)")
                .append(Tools.lineSeparator);
        sb.append("    {").append(Tools.lineSeparator);
        sb.append("        return resultBoolWrapper(").append(Tools.smallFirstChar(className))
                .append("Service.deleteByIds(ids.split(\",\")), \"信息删除成功\", \"信息删除失败\", null);").append(Tools.lineSeparator);
        sb.append("    }").append(Tools.lineSeparator);
        sb.append(Tools.lineSeparator);
        sb.append("    /**").append(Tools.lineSeparator);
        sb.append("     * 根据id 获取信息").append(Tools.lineSeparator);
        sb.append("     *").append(Tools.lineSeparator);
        sb.append("     * @param id").append(Tools.lineSeparator);
        sb.append("     * @return").append(Tools.lineSeparator);
        sb.append("     */").append(Tools.lineSeparator);
        sb.append("    @RequestMapping(value = \"/web/").append(Tools.smallFirstChar(className)).append("/info\")")
                .append(Tools.lineSeparator);
        sb.append("    @ResponseBody").append(Tools.lineSeparator);
        sb.append("    public CommonResult get").append(className).append("ById(").append(Tools.lineSeparator);
        sb.append("            @RequestParam(value = \"id\", required = true, defaultValue = \"0\") Integer id)")
                .append(Tools.lineSeparator);
        sb.append("    {").append(Tools.lineSeparator);
        sb.append("        return resultBoolWrapper(true, \"信息装载成功\", \"信息装载失败\", ").append(Tools.smallFirstChar(className))
                .append("Service.getInfoById(id));").append(Tools.lineSeparator);
        sb.append("    }").append(Tools.lineSeparator);
        sb.append("}").append(Tools.lineSeparator);
        return sb.toString();
    }
}
