1引入mybatis-generator-dev.jar

2. 添加依赖

<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.7</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <scope>test</scope>
</dependency>
3
创建generatorConfig.xml
详情看generatorConfig.xml

4
写main方法 详情看 GeneratorUtil.java
 public void generator() throws Exception{

    List<String> warnings = new ArrayList();
    boolean overwrite = true;
    File configFile = new File("src/test/resources/generatorConfig.xml");
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