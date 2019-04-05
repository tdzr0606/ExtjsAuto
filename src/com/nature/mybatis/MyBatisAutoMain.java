package com.nature.mybatis;

import com.nature.layerui.dao.DaoConnect;
import com.nature.mybatis.tools.*;

import java.util.Date;

/**
 * ExtjsAuto
 * LayerUIAutoMain
 *
 * @Author: 竺志伟
 * @Date: 2017-11-14 14:18
 */
public class MyBatisAutoMain
{
    public static void main(String args[])
    {
        // 文件路径
        String filePath = "/Users/apple/Desktop/layui";
        // 数据库连接路径
        String sqlUrl = "jdbc:mysql://127.0.0.1:3306/yn_auction?useUnicode=true&characterEncoding=utf-8";
        // 数据库 用户名
        String sqlUser = "root";
        // 数据库 密码
        String sqlPwd = "root";
        // 数据表名
        String tableName = "auc_goods_type";
        // 类名
        String className = "GoodsType";
        // 项目名,一般和数据表名的前缀相同
        String projectName = "web";
        // 类的基础包名
        String packageName = "com.nature.jet";
        // 创建人
        String author = "竺志伟";
        // jsp子文件夹
        String jspPath = "web";

        Date startDate = new Date();
        System.out.println("文件创建开始");

        System.out.println("------数据库连接开始------");
        DaoConnect daoConnect = new DaoConnect(sqlUrl, sqlUser, sqlPwd);
        System.out.println("------数据库连接结束------");

        /** Java文件创建 **/
        System.out.println("------VO文件创建开始------");
        //        CreateVO createVO =
        //                new CreateVO(daoConnect.getStatement(), tableName, className, packageName, filePath, projectName, author);
        //        createVO.createVo();
        CreateLombokSpringBootVO createVO =
                new CreateLombokSpringBootVO(daoConnect.getStatement(), tableName, className, packageName, filePath, projectName, author);
        createVO.createVo();
        System.out.println("------VO文件创建结束------");

        System.out.println("------Mapper文件创建开始------");
        CreateMapper createMapper = new CreateMapper(className, tableName, packageName, filePath, projectName, author);
        createMapper.createDao();
        System.out.println("------Mapper文件创建结束------");

        System.out.println("------MapperXml文件创建开始------");
        CreateMapperXml createMapperXml =
                new CreateMapperXml(daoConnect.getStatement(), tableName, className, packageName, filePath, projectName,
                        author);
        createMapperXml.createMapperXml();
        System.out.println("------MapperXml文件创建结束------");

        System.out.println("------Service文件创建开始------");
        CreateService createService =
                new CreateService(daoConnect.getStatement(), tableName, className, filePath, packageName, projectName, author);
        createService.createService();
        System.out.println("------Service文件创建结束------");

        System.out.println("------Controller文件创建开始------");
        CreateController createController =
                new CreateController(className, filePath, packageName, projectName, author, jspPath);
        createController.createController();
        System.out.println("------Controller文件创建结束------");


        /** vm文件创建 **/
        System.out.println("-------页面文件创建开始-------");
//        CreateLayerUIVm createLayerUIJsp = new CreateLayerUIVm(filePath, author, className, jspPath);
//        createLayerUIJsp.createLayuiJsp(createVO.getTableContentMap());
        CreateLayerUIThymeleaf createLayerUIThymeleaf = new CreateLayerUIThymeleaf(filePath, author, className, jspPath);
        createLayerUIThymeleaf.createLayuiJsp(createVO.getTableContentMap());
        System.out.println("-------页面文件创建结束-------");


        daoConnect.close();
        Date endDate = new Date();
        System.out.println("文件创建完成,共用时:" + (endDate.getTime() - startDate.getTime()) + "微秒");
    }
}
