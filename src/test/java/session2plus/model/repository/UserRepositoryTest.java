package session2plus.model.repository;


import com.github.javafaker.Faker;
import ee.session02.ee2.model.common.JpaProvider;
import ee.session02.ee2.model.repository.UserRepository;
import ee.session02.ee2.model.entity.User;
import org.junit.jupiter.api.*;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    public static UserRepository userRepository;

    @BeforeAll
    public static void setUp() {
        userRepository = new UserRepository();
    }
    Locale locale = new Locale("fa", "IR");
    Faker faker = new Faker(locale);

    @Test
    @Order(1)
    @DisplayName("User must be exists after save")
    public void saveUser() {
        User user =
                User
                        .builder()
                        .username("ahmad")
                        .family("ahmad")
                        .name("ahmad")
                        .password("ahmad")
                        .build();
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(user.getId());
        assertTrue(foundUser.isPresent(),"User not found");
        assertEquals("ahmad",foundUser.get().getUsername(),"user name not found");
        assertEquals("ahmad", foundUser.get().getName(), "user name not found");
    }

    @Test
    @Order(2)
    @DisplayName("User must be exists after update")
    public void updateUser() {
        Optional<User>foundUser=userRepository.findByUsername("ahmad");
        assertTrue(foundUser.isPresent(),"User not found");
        User user =foundUser.get();
        user.setName("ali");
        userRepository.update(user);
        foundUser = userRepository.findById(user.getId());
        assertTrue(foundUser.isPresent(),"User not found");
        assertEquals("ali",foundUser.get().getName(),"user name not found");

    }
    @AfterAll
    public static void tearDown() {
        JpaProvider.getInstance().close();
    }
}
