package ee.session03.ee1;

import ee.session03.ee1.model.common.JpaProvider;

import ee.session03.ee1.model.entity.User;
import ee.session03.ee1.model.service.UserService;


import javax.persistence.*;


//@Slf4j
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

// test1
//        User user =
//                User
//                        .builder()
//                        .username("username3")
//                        .password("password3")
//                        .name("name")
//                        .family("family")
//                        .build();
//
//       entityManager.persist(user);
//       user.setUsername("edited");

        //test2
//        User user = entityManager.find(User.class, 1);
//        user.setPassword("edited");

        //test3
//        TypedQuery<User> query = entityManager.createQuery("select u from userEntity03 u where u.name =:username", User.class);
//        query.setParameter("username", "name");

//        System.out.println(query.getSingleResult());

        //test4
//        System.out.println(query.getResultList());

        //test5
//        List<User> list = query.getResultList();
//        System.out.println((list.isEmpty()?"not found":list.get(0)));

        //test6
        TypedQuery<User> query = entityManager.createNamedQuery(User.FIND_BY_NAME_QUERY, User.class);
        System.out.println(query.setParameter("name", "name").getResultList());
        transaction.commit();
        entityManager.close();
        JpaProvider.getInstance().close();


    }
}
