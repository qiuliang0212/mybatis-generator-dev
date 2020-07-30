package org.mybatis.generator.plugins;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 */
public class GeneratorUtil {

    public void generator() throws Exception{

        List<String> warnings = new ArrayList();
        boolean overwrite = true;
        File configFile = new File("src/test/resources/generatorConfig.xml");
        //替换ConfigurationParser
        ConfigurationParserOverride cp = new ConfigurationParserOverride(warnings);
        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    public static void main(String[] args) throws Exception {
        try {
            GeneratorUtil generator = new GeneratorUtil();
            generator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}