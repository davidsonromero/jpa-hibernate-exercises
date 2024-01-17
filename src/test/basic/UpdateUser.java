package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class UpdateUser {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 2L);
        System.out.println("Updated user: " + user.getName());

        user.setEmail("test@gmail.com");

        entityManager.merge(user);

        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();
    }
}
