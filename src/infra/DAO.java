package infra;

import javax.persistence.*;
import java.util.List;

public class DAO<T extends DBEntity> {
    private final static EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final Class<T> tClass;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating entityManagerFactory", e);
        }
    }

    public DAO(){
        this(null);
    }

    public DAO(Class<T> tClass) {
        this.tClass = tClass;
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public DAO<T> openTransaction() {
        this.entityManager.getTransaction().begin();
        return this;
    }

    public DAO<T> closeTransaction() {
        this.entityManager.getTransaction().commit();
        return this;
    }

    public DAO<T> include(T entity) {
        this.entityManager.persist(entity);
        return this;
    }

    public DAO<T> create(T entity) {
        return this.openTransaction().include(entity).closeTransaction();
    }

    public List<T> findAll() {
        if(this.tClass == null) {
            throw new UnsupportedOperationException("Class type not defined");
        }
        return this.entityManager.createQuery("SELECT e FROM " + this.tClass.getName() + " e", this.tClass).getResultList();
    }

    public List<T> findPaginated(int firstResult, int maxResults) {
        if(this.tClass == null) {
            throw new UnsupportedOperationException("Class type not defined");
        }
        return this.entityManager.createQuery("SELECT e FROM " + this.tClass.getName() + " e", this.tClass)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .getResultList();
    }

    public T findById(Long id) {
        if(this.tClass == null) {
            throw new UnsupportedOperationException("Class type not defined");
        }
        return this.entityManager.find(this.tClass, id);
    }

    public List<T> findByName(String name){
        if(this.tClass == null) {
            throw new UnsupportedOperationException("Class type not defined");
        }
        return this.entityManager.createQuery("SELECT e FROM %s e WHERE e.name LIKE :name".formatted(this.tClass.getName()), this.tClass)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    public T update(T entity) {
        if(this.tClass == null) {
            throw new UnsupportedOperationException("Class type not defined");
        }

        T updatedEntity = this.openTransaction().entityManager.merge(entity);
        this.closeTransaction();
        return updatedEntity;
    }

    public void delete(Long id) {
        if(this.tClass == null) {
            throw new UnsupportedOperationException("Class type not defined");
        }

        T entity = this.findById(id);
        if(entity != null) {
            this.openTransaction().entityManager.remove(entity);
            this.closeTransaction();
        }
    }

    public void closeEntityManager() {
        this.entityManager.close();
    }
}
