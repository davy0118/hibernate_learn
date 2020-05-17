# Annotation方式运行Hibernate


## 如何启动
1. 修改`resources/hibernate.cfg.xml`配置文件中的数据库连接信息
2. 在MySQL中运行`resources/ddl.sql`，创建所需表
3. 运行`cn.davy.learn.hibernate.Application`
4. 与配置文件的主要区别：
   * 不需要mapping file（`User.hbm.xml`），有`User.java`中的Annotation替代
   * config文件（`hibernate.cfg.xml`）中的`<mapping resource="User.hbm.xml" />`修改为`<mapping class="cn.davy.learn.hibernate.entity.User" />`