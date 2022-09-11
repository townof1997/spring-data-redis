1,读取properties的内容
    a,通过Environment来读 例如:environment.getProperty("db.username")
    b,通过@Value注解来读 如
        @Value("${db.username}") private String username;
        @RequestMapping("/getParamFromValue")
            public String getParamFromValue() {
                return "db.username is:" + username + ",db.pwd is" + pwd;
            }
2,RequestMapping的produces属性返回JSON格式的对象，如AccountController,或者从server层获取数据
3,banner.txt日志文件的配置，如果要禁掉banner.txt日志的内容,在启动类中配置
        SpringApplication app = new SpringApplication(SpringDataRedisApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
4,配置文件@Configuration的作用,aa包下的测试
测试地址：
    localhost:8888/hello
    localhost:8888/getParam
    localhost:8888/getParamFromValue
5,Jedis访问本地的Redis数据库
6,JedisPool访问本地的数据库
7,ClassPathXmlApplicationContext配置bean访问本地的数据库
8,WeakPreference 可以用在网面文章的存储缓存，用户对象的优惠券过期无效等
9,一般都在Server层做缓存，不在Dao层做缓存；
10,用Redis存储数据要序列化

使用Redis作为mybatis的二级缓存
1，mybatis_config.xml：<setting name="cacheEnabled" value="true">
2,Mapper对应的sql映射文件中加一个<cache type ="xx.xx.MyRedisCache">
3,实现序列化接口；