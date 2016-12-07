# utils
艾云信息工具类


#SpringUtils
Spring工具类，用于获取Spring bean，用在spring boot中，需要在main class添加 @ComponentScan(basePackages = {"com.hythzx","com.aiyun"}) (注：com.hythzx是本地开发项目的package)使用方式：
    
    @Inject
    private SpringUtils springUtils;
    
    CustomerService customerService = springUtils.getBean(CustomerService.class);
    Customer customer = customerService.findOne(1l);


#StringUtils
Strign工具类，使用apache-commons-lang3的StringUtils方法


#UUIDGenerator
生成UUID工具类
