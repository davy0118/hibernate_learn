package cn.davy.learn.hibernate;

import cn.davy.learn.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            select(session);

            session.getTransaction().commit();
            session.close();
        } catch(Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void insert(Session session) {
        User u = new User("Davy", 34);
        session.save(u);
        System.err.println(u);
    }

    private static void select(Session session) {
        List<User> userList = session.createQuery("from User").list();

        for(User u : userList) {
            System.err.println(u);
        }
    }
}
