package ee.session02.model.repository;


import ee.session02.model.entity.User;

import javax.persistence.EntityManager;


public class UserRepositoryUnitOfWork {
    private  EntityManager entityManager;

    public UserRepositoryUnitOfWork(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(User user) {
        entityManager.persist(user);
    }
}
