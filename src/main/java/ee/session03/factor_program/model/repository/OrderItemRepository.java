package ee.session03.factor_program.model.repository;

import ee.session03.factor_program.model.common.JpaProvider;
import ee.session03.factor_program.model.entity.OrderItem;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class OrderItemRepository {
    public void save(OrderItem orderItem) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(orderItem);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error saving orderItem", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(OrderItem orderItem) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(orderItem);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error editing orderItem", e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            OrderItem orderItem = entityManager.find(OrderItem.class, id);
            entityManager.remove(orderItem);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error deleting orderItem", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional<OrderItem> findById(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            OrderItem orderItem = entityManager.find(OrderItem.class, id);
            return Optional.ofNullable(orderItem);
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error finding orderItem", e);
        } finally {
            entityManager.close();
        }
    }

    public List<OrderItem> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            TypedQuery<OrderItem> query = entityManager.createNamedQuery(OrderItem.FIND_ALL, OrderItem.class);
            List<OrderItem> orderItemList = query.getResultList();
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding all orderItems", e);
        }
    }


}
