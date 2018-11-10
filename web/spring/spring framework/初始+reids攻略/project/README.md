版本升级记录，主要记录一个版本中升级的功能点以及对应数据库、配置文件的改变。
每次升级都记录在该文档的最上面，便于查看最近的改变。
---
版本号：Spring_reids_V2.0
时间2018年11月7日 10:31:00
版本说明：
1. spring4.3.14+redis的框架搭建,主要对于初始框架进行版本升级和集成。
2. 封装了redis连接池管理和操作管理；
3. 配置类xml和properties配置文件
4. 提供了对应的测试。
5. 项目是部署在Tomcat8上，jdk8，junit4，jedis2.9
6. 添加maven-compiler-plugin编译插件，解决java compiler和maven编译版本问题。
7. 升级spring3.1.1->4.3.12，已经升到jdk8---解决junit测试问题。