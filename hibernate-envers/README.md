# Envers(版本记录)方式运行Hibernate


## 如何启动
1. 修改`resources/META-INF/persistence.xml`配置文件中的数据库连接信息
2. 在MySQL中运行`resources/ddl.sql`，创建所需表（新增了两张表）
3. 运行`cn.davy.learn.hibernate.Application`
4. 与JPA的主要区别：
   * Entity类标记为`@Audited`
   * 新增加了两张表