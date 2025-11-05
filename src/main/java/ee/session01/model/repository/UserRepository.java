package ee.session01.model.repository;

import ee.session01.model.common.JpaProvider;
import ee.session01.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    public void save(User user){
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        EntityTransaction entitytransaction = entityManager.getTransaction();
        try {
            entitytransaction.begin();
            entityManager.persist(user);
            entitytransaction.commit();
        } catch (Exception e) {
            if (entitytransaction.isActive()) {
                entitytransaction.rollback();
            }
            throw new RuntimeException("Error saving user", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(User user) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        EntityTransaction entitytransaction = entityManager.getTransaction();
        try {
            entitytransaction.begin();
            entityManager.merge(user);
            entitytransaction.commit();
        } catch (Exception e) {
            if (entitytransaction.isActive()) {
                entitytransaction.rollback();
            }
            throw new RuntimeException("Error saving user", e);
        } finally {
            entityManager.close();
        }
    }

    public void deleteById(Integer id) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        EntityTransaction entitytransaction = entityManager.getTransaction();
        try {
            entitytransaction.begin();
            User user = entityManager.find(User.class, id);
            entityManager.merge(user);
            entitytransaction.commit();
        } catch (Exception e) {
            if (entitytransaction.isActive()) {
                entitytransaction.rollback();
            }
            throw new RuntimeException("Error saving user", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional findById(Integer id) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();

        try {
            User user = entityManager.find(User.class, id);
            return Optional.ofNullable(user);
        } finally {
            entityManager.close();
        }
    }

    public Optional findByUsername(String username) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();

        try {
            String jpql = "select u from userEntity u where u.username=:username";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            query.setParameter("username", username);
            List<User> userList = query.getResultList();
            return userList.isEmpty() ? Optional.empty() : Optional.of(userList.get(0));
        } finally {
            entityManager.close();
        }
    }

    public Optional findByUsernameAndPassword(String username, String password) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();

        try {
            String jpql = "select u from userEntity u where u.username=:username and u.password=:password";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<User> userList = query.getResultList();
            return userList.isEmpty() ? Optional.empty() : Optional.of(userList.get(0));
        } finally {
            entityManager.close();
        }
    }

    public List<User> findAll() {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();

        try {
            String jpql = "select u from userEntity u ";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            List<User> userList = query.getResultList();
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
