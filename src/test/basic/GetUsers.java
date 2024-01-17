package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.User;

public class GetUsers {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setMaxResults(9);
        for (User user : query.getResultList()) {
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println("\n....................................................................................\n");
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
