package ee.session02plus.model.repository;

import ee.session02plus.model.common.JpaProvider;
import ee.session02plus.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


// =============================================
// User Repository + CRUD + Queries
// =============================================
public class UserRepository {

    //    ========================== CREATE ==========================
    public void save(User user) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Failed to save user", e);
        } finally {
            entityManager.close();
        }
    }

    //    ========================== UPDATE ==========================
    public void update(User user) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Failed to update user", e);
        } finally {
            entityManager.close();
        }
    }

    //    ========================== DELETE ==========================
    public void deleteById(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
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
        } finally {
            entityManager.close();
        }
    }

    //    ========================== READ : Single ==========================
    public Optional<User> findById(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();

        try {
            User user = entityManager.find(User.class, id);
            return Optional.ofNullable(user);
        } finally {
            entityManager.close();
        }
    }

    public Optional<User> findByUsername(String username) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            String jpql = "select u from userEntity02Plus u where u.username=:username";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            query.setParameter("username", username);
            List<User> list = query.getResultList();
            return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
        } finally {
            entityManager.close();
        }

    }

    //    ========================== READ : List ==========================

    public List<User> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            String jpql = "select u from userEntity02Plus u ";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            List<User> userList = query.getResultList();
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

//    public List<User> findByFamily(String family) {
//        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
//        try {
//            String jpql = "select u from userEntity u where u.family=:family";
//            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
//            query.setParameter("family", family);
//            return query.getResultList();
//        } finally {
//            entityManager.close();
//        }
//    }

    //    ========================== UTILS ==========================
    public boolean existsByUsername(String username) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from userEntity02Plus u where u.username=:username", Long.class);
        query.setParameter("username", username);
        return query.getSingleResult() > 0;
    }
}
