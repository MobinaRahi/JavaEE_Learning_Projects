package ee.session03.factor_program.model.repository;

import ee.session03.factor_program.model.common.JpaProvider;
import ee.session03.factor_program.model.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;




public class ProductRepository {
    public void save(Product product) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(product);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error saving product", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(Product product) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(product);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error editing product", e);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error deleting product", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional<Product> findById(Integer id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Product product = entityManager.find(Product.class, id);
            return Optional.ofNullable(product);
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new RuntimeException("Error finding product", e);
        } finally {
            entityManager.close();
        }
    }

    public List<Product> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_ALL, Product.class);
            List<Product> productList = query.getResultList();
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding all products", e);
        }
    }

    public Optional<Product> findByName(String name) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            TypedQuery<Product> query = entityManager.createNamedQuery("Product.findByName", Product.class);
            query.setParameter("name", name);
            List<Product> productList = query.getResultList();
            return productList.isEmpty() ? Optional.empty() : Optional.of(productList.get(0));
        } finally {
            entityManager.close();
        }
    }


}
