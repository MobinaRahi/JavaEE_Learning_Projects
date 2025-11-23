package ee.session02.ee2;

import ee.session02.ee2.model.entity.User;
import ee.session02.ee2.model.service.UserService;

//@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {

        User user = User
                .builder()
                .username("Mobina")
                .password("mbyna")
                .family("rahi")
                .name("mobina")
                .build();

        UserService userService=new UserService();
        userService.saveUser(user);


    }
}
