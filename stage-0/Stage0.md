**Stage0 - Java EE Standard Architecture（Java EE 标准架构）**

------

### HomeWork

###### Week01

- [x] 通过自研 Web MVC 框架实现（可以自己实现）一个用户注册，forward 到一个成功的页面（JSP 用法）/register

- [x] 通过 Controller -> Service -> Repository 实现（数据库实现）

  [入口-UserRegisterController](https://github.com/qxf-Carl/Evo/stage-0/user-platform/user-web/src/main/java/org/geektimes/projects/user/web/controller/UserRegisterController.java)

- [ ] （非必须）JNDI 的方式获取数据库源（DataSource），在获取 Connection

### 概念

###### JSR

JSR（Java Specification Requests - Java 规范提案）指向 JCP（Java Community Process）提出新增一个标准化技术规范的正式请求。任何人都可以提交 JSR以向Java平台增添新的API和服务。JSR已成为Java界的一个重要标准。简单的说，jsr是java开发者以及授权者指定的标准，而java开发者以及授权者形成一个jcp国际组织，其职能是指定java标准。



###### Servlet

> 官方API文档解释为**Serv**er App**let**（服务端小程序），Servlet通常通过HTTP（超文本传输协议）接收和响应来自Web客户端的请求。

个人觉得官方释义并不准确，应该理解为处理请求的业务逻辑。通过**Web服务器**（将某个主机上的资源映射为一个URL供外界访问）访问资源必须经过三个过程，接收请求、处理请求、响应请求。其中接收请求和响应请求是共性功能，且没有差异性，所以就把这两个步骤抽取成Web服务器；但处理请求的逻辑是不同的，因此抽取出来做成Servlet，交给程序员自己编写。

tomcat = web服务器 + Servlet容器

###### Java SPI

###### JDBC


### Reference

[Java 的 JSR 规范](https://www.cnblogs.com/mintsd/p/14339998.html)

[servlet的本质是什么，它是如何工作的](https://www.zhihu.com/question/21416727/answer/690289895)

[Java Servlet技术概述](https://www.oracle.com/java/technologies/servlet-technology.html)

[Servlet API](https://docs.oracle.com/javaee/7/api/javax/servlet/Servlet.html)