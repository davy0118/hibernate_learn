#配置文件方式运行Hibernate


## 如何启动
1. 修改`resources/hibernate.cfg.xml`配置文件中的数据库连接信息
2. 在MySQL中运行`resources/ddl.sql`，创建所需表
3. 运行`cn.davy.learn.hibernate.Application`