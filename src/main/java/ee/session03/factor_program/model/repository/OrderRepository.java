package ee.session03.factor_program.model.repository;

import ee.session03.factor_program.model.common.JpaProvider;
import ee.session03.factor_program.model.entity.Order;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;



public class OrderRepository {
    public void save(Order order) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(order);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error saving order", e);
        } finally {
            entityManager.close();
        }
    }
    public void update(Order order) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(order);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error editing order", e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Order order = entityManager.find(Order.class, id);
            entityManager.remove(order);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error deleting order", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional<Order> findById(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Order order = entityManager.find(Order.class, id);
            return Optional.ofNullable(order);
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error finding order", e);
        } finally {
            entityManager.close();
        }
    }

    public List<Order> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            TypedQuery<Order> query = entityManager.createNamedQuery(Order.FIND_ALL, Order.class);
            List<Order> orderList = query.getResultList();
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding all orders", e);
        }
    }

    public Optional<Order> findByTitle(String title) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            TypedQuery<Order> query = entityManager.createNamedQuery(Order.FIND_BY_TITLE, Order.class);
            query.setParameter("title", title);
            List<Order> orderList = query.getResultList();
            return orderList.isEmpty() ? Optional.empty() : Optional.of(orderList.get(0));
        } finally {
            entityManager.close();
        }
    }


}
