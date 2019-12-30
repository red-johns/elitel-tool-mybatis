package com.elitel.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 根据配置生成对应表的 实体 与 Mapper
 *
 * @author h-vk
 * @see <a href="http://www.mybatis.org/generator/running/runningWithJava.html">
 * Running MyBatis Generator With Java
 * </a>
 * @since 2019-12-30
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        File configFile = new File("src/main/resources/generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(configFile);
        DefaultShellCallback defaultShellCallback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, defaultShellCallback, warnings);
        myBatisGenerator.generate(null);

        System.out.println("✌️ 代码生成成功 >>>>>>");
    }
}
