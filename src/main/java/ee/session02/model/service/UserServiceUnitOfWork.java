package ee.session02.model.service;

import ee.session02.model.entity.User;
import ee.session02.model.repository.UserRepositoryUnitOfWork;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



public class UserServiceUnitOfWork {
    private EntityManager entityManager;
    private UserRepositoryUnitOfWork userRepository;

    public UserServiceUnitOfWork(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.userRepository = new UserRepositoryUnitOfWork(entityManager);
    }
    public void saveUser(User user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            userRepository.save(user);
            entityTransaction.commit();

        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            throw new  RuntimeException("Error saving user", e);
        }
        finally {
            entityManager.close();
        }
    }

}
