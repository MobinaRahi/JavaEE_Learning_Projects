package ee.session03.ee2;

import ee.session03.ee2.model.common.JpaProvider;
import ee.session03.ee2.model.entity.Role;
import ee.session03.ee2.model.entity.User;

import javax.persistence.*;


public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Role role =
                Role
                        .builder()
                        .code("Programmer")
                        .displayName("Programmer")
                        .build();
        entityManager.persist(role);

        User user =
                User
                        .builder()
                        .name("mobina")
                        .password("mobina")
                        .role(role)
                        .username("mobina")
                        .family("Rahi")
                        .build();

        entityManager.persist(user);

        User user1 =
                User
                        .builder()
                        .name("zeynabb")
                        .password("zeynab2")
                        .role(role)
                        .username("zeynab2")
                        .family("eshaghi")
                        .build();
        entityManager.persist(user1);

       role.addUser(user);
       role.addUser(user1);
        entityManager.merge(role);

        transaction.commit();
        entityManager.close();
        JpaProvider.getInstance().close();


    }
}
