package com.nature.extjs;

import java.util.Date;

import com.nature.extjs.dao.DaoConnect;
import com.nature.extjs.tools.CreateController;
import com.nature.extjs.tools.CreateControllerJS;
import com.nature.extjs.tools.CreateDao;
import com.nature.extjs.tools.CreateModelJS;
import com.nature.extjs.tools.CreateService;
import com.nature.extjs.tools.CreateStoreJS;
import com.nature.extjs.tools.CreateVO;
import com.nature.extjs.tools.CreateViewJS;

/**
 * 主进程
 *
 * @author 竺志伟
 * @email tdzr_0606@126.com
 * @date 2017年3月5日 下午1:56:26
 */
public class ExtjsAutoMain
{
    public static void main(String[] args)
    {
        // 文件路径
        String filePath = "/Users/apple/Desktop/extjs";
        // 数据库连接路径
        String sqlUrl = "jdbc:mysql://192.168.68.201:3306/km_jobs2018?useUnicode=true&characterEncoding=utf-8";
        // 数据库 用户名
        String sqlUser = "wbkj";
        // 数据库 密码
        String sqlPwd = "wbkj";
        // 数据表名
        String tableName = "job_user_report_activiti";
        // 类名
        String className = "UserReportActiviti";
        // 项目名,一般和数据表名的前缀相同
        String projectName = "job";
        // 类的基础包名
        String packageName = "com.redare.jet";
        // 创建人
        String author = "竺志伟";

        Date startDate = new Date();
        System.out.println("文件创建开始");

        System.out.println("------数据库连接开始------");
        DaoConnect daoConnect = new DaoConnect(sqlUrl, sqlUser, sqlPwd);
        System.out.println("------数据库连接结束------");

        /** Java文件创建 **/
        System.out.println("------VO文件创建开始------");
        CreateVO createVO =
                new CreateVO(daoConnect.getStatement(), tableName, className, packageName, filePath, projectName,
                        author);
        createVO.createVo();
        System.out.println("------VO文件创建结束------");

        System.out.println("------Dao文件创建开始------");
        CreateDao createDao = new CreateDao(className, tableName, packageName, filePath, projectName, author);
        createDao.createDao();
        System.out.println("------Dao文件创建结束------");

        System.out.println("------Service文件创建开始------");
        CreateService createService =
                new CreateService(daoConnect.getStatement(), tableName, className, filePath, packageName,
                        projectName, author);
        createService.createService();
        System.out.println("------Service文件创建结束------");

        System.out.println("------Controller文件创建开始------");
        CreateController createController =
                new CreateController(className, filePath, packageName, projectName, author);
        createController.createController();
        System.out.println("------Controller文件创建结束------");


        /** ExtJS 文件创建 **/
        System.out.println("------ModelJs文件创建开始------");
        CreateModelJS createModelJS = new CreateModelJS(className, filePath, author);
        createModelJS.createModelJS(createVO.getTableContentMap());
        System.out.println("------ModelJs文件创建结束------");

        System.out.println("------StoreJs文件创建开始------");
        CreateStoreJS createStoreJS = new CreateStoreJS(className, filePath, author);
        createStoreJS.createStoreJs();
        System.out.println("------StoreJs文件创建结束------");

        System.out.println("------ViewJs文件创建开始------");
        CreateViewJS createViewJS = new CreateViewJS(className, filePath, author);
        createViewJS.createViewJs(createVO.getTableContentMap());
        System.out.println("------ViewJs文件创建结束------");

        System.out.println("------ControllerJs文件创建开始------");
        CreateControllerJS createControllerJS = new CreateControllerJS(className, filePath, author);
        createControllerJS.createControllerJs();
        System.out.println("------ControllerJs文件创建结束------");


        daoConnect.close();
        Date endDate = new Date();
        System.out.println("文件创建完成,共用时:" + (endDate.getTime() - startDate.getTime()) + "微秒");

    }
}
