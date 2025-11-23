package ee.session03.factor_program.model.repository;

import ee.session03.factor_program.model.common.JpaProvider;
import ee.session03.factor_program.model.entity.Role;
import ee.session03.factor_program.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class RoleRepository {
    public void save(Role role) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        EntityTransaction entitytransaction = entityManager.getTransaction();
        entitytransaction.begin();
        entityManager.persist(role);
        entitytransaction.commit();
        try {
            entitytransaction.begin();
            entityManager.persist(role);
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

    public void update(Role role) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        EntityTransaction entitytransaction = entityManager.getTransaction();
        entitytransaction.begin();
        entityManager.persist(role);
        entitytransaction.commit();
        try {
            entitytransaction.begin();
            entityManager.merge(role);
            entitytransaction.commit();
        } catch (Exception e) {
            if (entitytransaction.isActive()) {
                entitytransaction.rollback();
            }
            throw new RuntimeException("Error update user", e);
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
            entityManager.remove(user);
            entitytransaction.commit();
        } catch (Exception e) {
            if (entitytransaction.isActive()) {
                entitytransaction.rollback();
            }
            throw new RuntimeException("Error delete user", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional findById(Integer id) {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        EntityTransaction entitytransaction = entityManager.getTransaction();
        try {
            entitytransaction.begin();
            User user = entityManager.find(User.class, id);
            return Optional.ofNullable(user);
        } finally {
            entityManager.close();
        }
    }

    public List<Role> findAll() {
        EntityManager entityManager = JpaProvider.instance.getEntityManager();
        try {
            TypedQuery<Role> query = entityManager.createNamedQuery(Role.FIND_ALL, Role.class);
            List<Role> roleList = query.getResultList();
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

}
