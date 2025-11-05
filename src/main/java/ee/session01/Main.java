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


        EntityManager entityManager=factory.createEntityManager();
        EntityTransaction entitytransaction=entityManager.getTransaction();
        entitytransaction.begin();
//        User user = User
//                .builder()
//                .id(1)
//                .username("Mobina")
//                .password("mbyna")
//                .build();

        //save
//        entityManager.persist(user);

        //Update
//        entityManager.merge(user);

        //DELETE
//       User user= entityManager.find(User.class, 1);
//        entityManager.remove(user);

        //findById
//        User user=entityManager.find(User.class, 2);
//        System.out.println(user);

        //findAll
        TypedQuery<User> query=entityManager.createQuery("select u from userEntity u",User.class);
        List<User> list=query.getResultList();



        entitytransaction.commit();
        entityManager.close();


//            UserService userService = new UserService();
//            userService.saveUser(user);
////            log.info("user has been saved");
    }
}
