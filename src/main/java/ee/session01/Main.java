package ee.session01;

import lombok.extern.slf4j.Slf4j;
import ee.session01.model.entity.User;
import ee.session01.model.service.UserService;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

//@Slf4j
public class Main {
    public static void main(String[] args) {

EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager entityManager=factory.createEntityManager();
        EntityTransaction entitytransaction=entityManager.getTransaction();
        entitytransaction.begin();
        User user1 = User
                .builder()
                .username("Mobina")
                .password("mbyna")
                .build();
        UserService userService=new UserService();
        userService.saveUser(user1);


    }
}
