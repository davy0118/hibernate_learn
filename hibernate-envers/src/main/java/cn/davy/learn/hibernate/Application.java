package cn.davy.learn.hibernate;

import cn.davy.learn.hibernate.entity.User;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("cn.davy.learn.hibernate");
        EntityManager entityManager = sessionFactory.createEntityManager();
        AuditReader reader = AuditReaderFactory.get(entityManager);

        /*
        entityManager.getTransaction().begin();
        User ouser = insert(entityManager);
        entityManager.getTransaction().commit();
        */

        entityManager.getTransaction().begin();
        findVersion(reader, 4L/*ouser.getId()*/, 1);
        entityManager.getTransaction().commit();

        /*
        entityManager.getTransaction().begin();
        update(entityManager, ouser);
        entityManager.getTransaction().commit();
        */

        entityManager.getTransaction().begin();
        findVersion(reader, 4L/*ouser.getId()*/, 2);
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }

    private static void findVersion(AuditReader reader, Long id, int revision) {
        User vuser = reader.find(User.class, id, revision);
        System.err.println("revision " + revision + ": " + vuser);
    }

    private static User insert(EntityManager entityManager) {
        User u = new User("Sara", 4);
        entityManager.persist(u);
        System.err.println(u);
        return u;
    }

    private static void update(EntityManager entityManager, User ouser) {
        ouser.setAge(5);
        entityManager.persist(ouser);
        System.err.println(ouser);
    }
}
