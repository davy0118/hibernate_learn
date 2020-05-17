package cn.davy.learn.hibernate;

import cn.davy.learn.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("cn.davy.learn.hibernate");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // insert(entityManager);
        select(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();
    }

    private static void insert(EntityManager entityManager) {
        User u = new User("Sofia", 6);
        entityManager.persist(u);
        System.err.println(u);
    }

    private static void select(EntityManager entityManager) {
        List<User> userList = entityManager.createQuery("from User", User.class).getResultList();

        for(User u : userList) {
            System.err.println(u);
        }
    }
}
