# utils
工具类


#SpringUtils
Spring工具类，用于获取Spring bean，用在spring boot中，需要在main class添加 
`@ComponentScan(basePackages = {"com.hythzx","com.aiyun"})` (注：`com.hythzx`是本地开发项目的package)使用方式：
``` Java
    @Inject
    private SpringUtils springUtils;
    
    CustomerService customerService = springUtils.getBean(CustomerService.class);
    Customer customer = customerService.findOne(1l);
```

#StringUtils
Strign工具类，使用apache-commons-lang3的StringUtils方法


#UUIDGenerator
生成UUID工具类

#RandomUtil
生成随机数


#DateUtils
日期工具类


#ArrayUtils
数组操作工具类<br/>

```Java
ListUtils<Man> list7 = new ListUtilsImpl<>(personList).map(person1 -> manMapper.convertManFromPerson(person1));
List<Man> personList1 =  new ArrayUtilsImpl<>(personList).filter(person1 -> person1.getAge() > 10).map(person1 -> manMapper.convertManFromPerson(person1)).getList().orElse(new ArrayList<>());
```

#ImageUploadUtil
图片上传工具类<br>
```Java
 @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model) throws IOException {
        ArrayUtils<FileInfo> arrayUtils;
        List<FileInfo> fileInfos = ImageUploadUtil.upload(request, imgUploader);
        arrayUtils = new ArrayUtilsImpl<>(fileInfos);
        List<FileInfo> fileInfoList = arrayUtils.map(fileInfo -> {
            fileInfo.setPath("/web/" + fileInfo.getFileName());
            return fileInfo;
        }).getList().orElse(new ArrayList<>());
        model.addAttribute("fileInfos",fileInfoList);
        return "index";
    }
```

#Maven
```XML
<dependency>
  <groupId>com.aiyun</groupId>
  <artifactId>utils</artifactId>
  <version>0.1.2</version>
</dependency>
```