package infra;

import javax.persistence.*;

public class DAO<T extends DBEntity> {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating entityManagerFactory", e);
        }
    }

    DAO() {
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }//Teste
}
