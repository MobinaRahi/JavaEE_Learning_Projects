package session2plus.model.entity;


import ee.session02.ee2.model.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserValidationTest {
    private Validator validator;

    @BeforeAll
    public void setUp(){
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        validator=factory.getValidator();
    }

    @Test
    @DisplayName("valid User name should be have between 3 and 16 character")
    public void validUsernamePasses(){
        User user=
                User
                        .builder()
                        .username("username")
                        .password("password")
                        .name("name")
                        .family("family")
                        .build();

        Set<ConstraintViolation<User>>error=validator.validate(user);
        assertTrue(error.isEmpty(),"valid user should have no errors");
    }
    @Test
    @DisplayName("valid User name should be have between 3 and 16 character")
    public void invalidUsernamePasses(){
        User user=
                User
                        .builder()
                        .username("@username")
                        .password("password")
                        .name("name")
                        .family("family")
                        .build();

        Set<ConstraintViolation<User>>error=validator.validate(user);
        assertTrue(!error.isEmpty(),"invalid user should have  errors");
    }




}
