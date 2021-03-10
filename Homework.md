
### HomeWork

###### Week01

- [x] 通过自研 Web MVC 框架实现（可以自己实现）一个用户注册，forward 到一个成功的页面（JSP 用法）/register
- [x] 通过 Controller -> Service -> Repository 实现（数据库实现）

  [入口-UserRegisterController](https://github.com/qxf-Carl/Evo/blob/main/stage-0/user-platform/user-web/src/main/java/org/geektimes/projects/user/web/controller/UserRegisterController.java)
- [ ] （非必须）JNDI 的方式获取数据库源（DataSource），在获取 Connection

###### Week02

- [x] 通过课堂上的简易版依赖注入和依赖查找，实现用户注册功能

- [x] 通过 UserService 实现用户注册注册用户需要校验
  - Id：必须大于 0 的整数
  - 密码：6-32 位 
  - 电话号码: 采用中国大陆方式（11 位校验）

