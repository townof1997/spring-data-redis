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
    a，mybatis_config.xml：<setting name="cacheEnabled" value="true">
    b,Mapper对应的sql映射文件中加一个<cache type ="xx.xx.MyRedisCache">
    c,实现序列化接口；
11,实现序列化接口
12,实现 Cache类    实现Redis数据库作为MyBatis的二级缓存
13,finalize方法的理解
    finalize()是Object类里的protected类型的方法，子类可通过覆盖这个方法来实现回收前的资源清理工作，和这个方法相关的流程如下所述
    1，Java虚拟机一旦通过刚才提到的“根可达算法”,判断出某个对象处于可回收状态时，会判断该对象是否重写了Object类的finalize()方法，如果没有，则直接回收；
    2，如果重写了finalize()方法，而且未执行过该方法，则把该对象放入F-Queue队列，另一个线程会定时遍历F-Queue队列，并执行该队列中各对象的finalize()方法。
    3，finalize方法执行完毕后，GC会再次判断该对象是否可被回收，如果可以，则进行回收，如果此刻该对象上有强引用，则该"对象复活"，即处于"不可回收状态"；

    Full GC出现的情况
    1，年老代被写满，
    2，持久代被写满
    3，程序员显式的调用System.gc();    
    根可达算法；
    1，虚拟机栈中引用的对象
    2，方法区中静态属性引用的对象
    3，方法区中常量引用的对象
    4，本地方法栈中引用的对象

14,synchronized 可以锁方法，但不可以锁住业务逻辑
    比如张三登录，取钱，登出，李四在张三登录期间不能登录;
15,内部内中调用外部类的参数或变量，需要加final,因为不能保证内部类运行时，外部类是或否被回收，加上final放在常量池中
16,volatile ,不能保证原子性,不能解决数据不一致的问题,可以保证数据同步
    1,防止指令重排;2,直接从主存中读取数据
    a、保证可见性；
    b、防止指令重排；
    c、但是不保证原子性；
    
17,ThreadLocal

18,ReentrantLock 可重复锁;
    解决了14 可以锁住业务的问题
    acc.lockAccount();
    acc.login();
    acc.add();
    acc.logout();
    acc.unLockAccount();
19,Condition 线程间通讯
20,Semaphore 管理多线程之间的竞争