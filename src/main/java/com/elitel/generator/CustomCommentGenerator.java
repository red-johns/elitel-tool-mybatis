package com.elitel.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * TODO: 自定义生成的注解
 *
 * @author h-vk
 * @since 2019-12-30
 */
public class CustomCommentGenerator extends EmptyCommentGenerator {
    private Properties properties;

    public CustomCommentGenerator() {
        this.properties = new Properties();
    }


    /**
     * TODO: 添加生成类的注释格式
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 获取配置中的 author 属性
        String author = properties.getProperty("author", "elitel");
        // 获取配置中的 dateFormat 属性
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        // 获取数据表的注释
        String remarks = introspectedTable.getRemarks();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * TODO: " + remarks);
        topLevelClass.addJavaDocLine(" * ");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @since " + simpleDateFormat.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

    /**
     * TODO: 添加生成类中字段注释格式
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取数据表中的字段注释
        String remarks = introspectedColumn.getRemarks();
        if (!"".equals(remarks)) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + remarks);
            field.addJavaDocLine(" */");
        }
    }
}
