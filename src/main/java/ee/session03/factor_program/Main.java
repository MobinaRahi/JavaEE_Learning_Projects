package ee.session03.factor_program;


import ee.session03.factor_program.model.common.JpaProvider;
import ee.session03.factor_program.model.entity.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;

@Slf4j
public class Main {
    public static void main(String[] args) {
        EntityManager entityManager= JpaProvider.getInstance().getEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Role role=
                Role
                        .builder()
                        .code("programmer")
                        .displayName("java")
                        .build();
        entityManager.persist(role);
        User user=
                User
                        .builder()
                        .username("mobina")
                        .password("mobina")
                        .role(role)
                        .build();
        entityManager.persist(user);

        Product product1=
                Product
                        .builder()
                        .name("product")
                        .build();
        entityManager.persist(product1);
        Product product2=
                Product
                        .builder()
                        .name("product")
                        .build();
        entityManager.persist(product2);
        Product product3=
                Product
                        .builder()
                        .name("product")
                        .build();
        entityManager.persist(product3);
        OrderItem orderItem1=
                OrderItem
                        .builder()
                        .product(product1)
                        .quantity(3)
                        .price(100)
                        .build();
        entityManager.persist(orderItem1);
        OrderItem orderItem2=
                OrderItem
                        .builder()
                        .product(product2)
                        .quantity(3)
                        .price(200)
                        .build();
        entityManager.persist(orderItem2);
        OrderItem orderItem3=
                OrderItem
                        .builder()
                        .product(product3)
                        .quantity(3)
                        .price(300)
                        .build();
        entityManager.persist(orderItem3);
        Order order1=
                Order
                        .builder()
                        .total(100)
                        .customer(user)
                        .title("title1")
                        .orderTime(LocalDateTime.now())
                        .build();

        order1.addOrderItem(orderItem1);
        order1.addOrderItem(orderItem2);
        order1.addOrderItem(orderItem3);
        entityManager.persist(order1);
        orderItem1.setOrder(order1);
        orderItem2.setOrder(order1);
        orderItem3.setOrder(order1);


        entityTransaction.commit();
        entityManager.close();
        JpaProvider.getInstance().close();

    }
}
