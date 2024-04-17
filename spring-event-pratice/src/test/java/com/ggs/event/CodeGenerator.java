package com.ggs.event;

import java.io.File;
import java.sql.Types;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/17 15:32
 */
public class CodeGenerator {

    @Test
    public void test() {
        String url = "jdbc:mysql://8.134.177.106:3306/practice_demo?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "starbug-docker-mysql";
        File file = new File("");
        String javaFilePath = "\\src\\main\\java";
        String resourcesFilePath = "\\src\\main\\resources";
        String basePath = file.getAbsolutePath();
        String javaPackagePath = "\\com\\ggs\\event";
        System.out.println(basePath + javaFilePath + javaPackagePath);
        System.out.println(basePath + resourcesFilePath + "\\mappers");
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("lhh") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(basePath + javaFilePath); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.ggs.event") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, basePath + resourcesFilePath + "\\mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("s_file") // 设置需要生成的表名
                            .addTablePrefix("s_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
