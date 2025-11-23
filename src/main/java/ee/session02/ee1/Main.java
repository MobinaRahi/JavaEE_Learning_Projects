package ee.session02.ee1;


import ee.session02.ee1.model.common.JpaProvider;
import ee.session02.ee1.model.entity.User;
import ee.session02.ee1.model.service.UserServiceUnitOfWork;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;


@Slf4j
public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        UserServiceUnitOfWork userServiceUnitOfWork = new UserServiceUnitOfWork(entityManager);
        User user1 = User
                .builder()
                .username("zeynab")
                .password("mbyna")
                .build();

        userServiceUnitOfWork.saveUser(user1);
        JpaProvider.getInstance().close();


    }
}
