# Mosoteach Helper admin
 云班课高效助手（mosoteach-helper）的后台管理系统

## About

该项目是用于学习 Spring 全家桶 、MyBatis 、Redis  ... 后端框架、技术 的 **个人练手项目**。

### **项目意义**

以学习和积累知识技术为目的，不断拓宽技术栈，尝试深挖技术点；
对于新技术新知识，即学即用，以练促学，以学助练；
技术与业务场景结合，自主寻找并深挖业务场景，尝试结合使用现有知识实现业务功能；
锻炼自主分析和解决问题的能力，注重思维的培养。



----

## 相关项目

- [Mosoteach-Helper](https://github.com/AOFNH/mosoteach-helper)
- [Mosoteach Helper admin](https://github.com/AOFNH/mosoteach-helper-admin)
- [Mosoteach-Helper-Admin React App](https://github.com/AOFNH/mst-helper-admin-react)
- [Mosoteach-Helper-Admin react-electron App](https://github.com/AOFNH/mst-helper-admin-react-electron)



-----



## Notes

### Backend 技术栈

+ [Spring](https://spring.io/)
+ SpringBoot  
+ [Spring Security](https://spring.io/projects/spring-security)
+ [Swagger2](https://swagger.io/)
+ JWT  
+ MySQL 
+ [MyBatis](https://mybatis.org/mybatis-3/)
+ [MyBatis Generator](http://mybatis.org/generator/index.html)
+ [MyBatis Dynamic SQL](https://mybatis.org/mybatis-dynamic-sql/docs/introduction.html)

----

### Front-End 技术栈

- *[React](https://reactjs.org/)、React Hooks*
- *[Ant Design](https://ant.design/)*
- *[Axios](https://github.com/axios/axios)*
- *[ECharts](https://echarts.apache.org/en/index.html)*
- *[echarts-for-react](https://github.com/hustcc/echarts-for-react)*

----

### Date类型的使用

向数据传Date数据时，应该使用`Date`类型
而从数据库中取出Date类型的属性，使用SimpleDateFormat转成String，方便操作，实际上Date传到前端就成了String

数据中日期查询要转成字符串

----

### POJO、PO、DTO、VO、BO

[什么是JavaBean、bean? 什么是POJO、PO、DTO、VO、BO ? 什么是EJB、EntityBean？](#什么是JavaBean、bean? 什么是POJO、PO、DTO、VO、BO ? 什么是EJB、EntityBean？)

----

### MyBatis Generator + MyBatis Dynamic SQL

[MyBatis Generator](https://mybatis.org/generator/index.html)

[MyBatis Dynamic SQL Usage Notes](https://mybatis.org/generator/generatedobjects/dynamicSqlV2.html#)

-----

### MyBatis Dynamic SQL - Stand Alone Where Clauses(独立的where子句【注解形式】)

[MyBatis Dynamic SQL](https://mybatis.org/mybatis-dynamic-sql/docs/introduction.html)

[Stand Alone Where Clauses](https://mybatis.org/mybatis-dynamic-sql/docs/whereClauses.html)



----

### Mysql按日、周、月进行分组统计

[Mysql按日、周、月进行分组统计](https://blog.csdn.net/lz_peter/article/details/78722976)

[mysql 查询当天、本周，本月，上一个月的数据](https://juejin.im/post/6844904046176763912)

[MySQL DATE_FORMAT() 函数](https://www.w3school.com.cn/sql/func_date_format.asp)

[MySQL month()函数](https://www.yiibai.com/mysql/month.html)

-----

### Map 四种获取 key 和 value 值的方法，以及对 map 中的元素排序

https://blog.csdn.net/u011314442/article/details/70255577

通过 map.entrySet() 方法来取值：后者则直接将 key 和 value 的键值对直接取出来，**只用查询一次。**



-----

### Spring中使用@Autowired注解静态变量

[Spring中使用@Autowired注解静态变量](http://jessehzx.top/2018/03/18/spring-autowired-static-field/)



----

### DELETE请求（伪装的POST）

因为delete请求使用了“请求伪装”（我也不知道学名叫什么）的方法，***用post方法发送请求***，但是在参数里面加`_method=DELETE`来告诉Springboot其实这是一个Delete请求，既使用了POST方法的`body->param`转换，又不会因为方法不匹配被拒绝请求

----

### Spring Boot统一异常处理

[Spring Boot统一异常处理](https://juejin.im/post/6844903762071388167)

[SpringBoot 对 controller 层捕获全局异常并处理的方法（@ControllerAdvice 和 @ExceptionHandler）](https://blog.csdn.net/Colton_Null/article/details/84592748)

[Spring Boot 全局异常处理](https://www.cnblogs.com/fishpro/p/spring-boot-study-throwable.html)

[SpringBoot图文教程15—项目异常怎么办？「跳转404错误页面」「全局异常捕获」](https://cloud.tencent.com/developer/article/1606782)

-----

### Axios 跨域请求（CORS）

1. 完善服务端接口及跨域响应部首

   在跨域请求中，若服务端返回了正确的跨域响应部首：`Access-Control-Allow-Origin`、`Access-Control-Allow-Method`、`Access-Control-Allow-Headers`, 则跨域请求能正常获取数据。

   + 在服务器端，controller方法中添加（局部，还有其他配置方法，[**服务器端跨域请求方案**](https://juejin.im/post/6844903991558537223)

     ```java
     @RequestMapping(value = "/saveOrUpdateUsePost", method = RequestMethod.POST)
     public String saveOrUpdateUsePost( ..., HttpServletResponse response) {
     	...
         response.addHeader("Access-Control-Allow-Origin", "*");
         ...
     
     }
     ```

     

2. 将 `POST` 预检请求转换为 ***简单请求***

   请求部首的 `Content-Type` 设为 `application/x-www-form-urlencoded`

   处理 `POST` 请求数据，方式有以下两种：

   - 通过 `URLSearchParams` 生成`POST` 请求的数据
   - 使用 `qs` 库的 `stringify` api 对请求数据进行转换（**若请求数据中某个字段的值为引用类型，需要先通过 JSON.stringify 处理，以防止服务端无法识别**）

   **axios 中以`application/x-www-form-urlencoded`格式发送数据时，对应以上两种方式的用法**

   [Axios 文档：Using application/x-www-form-urlencoded format](https://github.com/axios/axios#using-applicationx-www-form-urlencoded-format)

   ```js
   // Send a POST request
   axios({
       method: 'post',
       url: urlPost,
       data: qs.stringify({id:1}),
       headers: {
           'Content-Type': 'application/x-www-form-urlencoded'
       }
   
   });
   ```



**Ref**

[axios 跨域请求详解](https://juejin.im/post/6844903850684465159)  
[详解SpringBoot应用跨域访问解决方案](https://juejin.im/post/6844903991558537223)

----



### SpringBoot + Swagger + SpringSecurity + Jwt做登陆认证

[SpringBoot + Swagger + SpringSecurity + Jwt做登陆认证](https://www.jianshu.com/p/e26a1ef65edb)

-----



### 解决 Mixed Content 混和内容访问问题

解决在HTTPS页面里通过AJAX的方式请求HTTP资源，造成Mixed Content 混和内容访问问题

#### **从前端入手**

[https页面加载http资源（混合内容）的解决方法](https://www.liudaima.com/a/108.html)

[https 页面中引入 http 资源的解决方式](https://segmentfault.com/q/1010000005872734)

#### **从服务器端入手**

[springboot配置ssl证书指南](https://juejin.im/post/6844903966271242248)

必要条件：**域名、DNS解析、Nginx配置SSL实现HTTPS**



#### 踩坑出坑过程

+ Nginx 配置SSL不正确 
+ 80端口需要备案使用  
+ 服务器防火墙拦截了端口
+ 443端口 服务器内部可访问，外网不可访问
+ 使用CDN实现HTTPS
+ CDN 存在端口限制（80，443 依旧不可用， 于是使用可用的8443端口代替）【使用 nginx 转发8443 到  8001】
+ springboot 配置HTTPS， 为了兼容HTTP访问，将HTTP请求重定向到HTTPS  (如：http-port : 8081  =redirect=>  https-port : 8001)



[一篇文章讲透CDN HTTPS安全加速基本概念、解决方案及优化实践](https://segmentfault.com/a/1190000011810698)



----

### Spring Boot 项目安装SSL数字证书以支持HTTPS

注意 **PFX** 格式证书的 Type：`server.ssl.key-store-type = PKCS12`

[Spring Boot 支持 HTTPS 如此简单，So easy！](https://segmentfault.com/a/1190000019740145)
[一文教你将 SpringBoot 网站升级为 HTTPS](https://juejin.im/post/6844903636271644686)
[Spring Boot Java安装SSL数字证书](https://zhuanlan.zhihu.com/p/34616746)

----

### 改变 Swagger2 的 base URL

[how to change base path for swagger 2.0](https://github.com/springfox/springfox/issues/1443)

----

### Spring @Value：读取Properties配置文件

[Spring @Value：读取Properties配置文件](https://blog.csdn.net/fly910905/article/details/81155630)