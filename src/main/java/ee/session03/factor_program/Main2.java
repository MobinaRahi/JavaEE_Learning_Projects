package ee.session03.factor_program;

import ee.session03.factor_program.model.entity.Role;
import ee.session03.factor_program.model.entity.User;
import ee.session03.factor_program.model.repository.RoleRepository;
import ee.session03.factor_program.model.repository.UserRepository;
import ee.session03.factor_program.model.service.RoleService;
import ee.session03.factor_program.model.service.UserService;

public class Main2 {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        RoleRepository roleRepository = new RoleRepository();
        Role role =
                Role
                        .builder()
                        .code("Test")
                        .displayName("Test")
                        .build();
        RoleService roleService = new RoleService();
      roleService.saveRole(role);
        User user =
                User
                        .builder()
                        .username("Test")
                        .password("Test")
                        .role(role)
                        .build();
        UserService userService = new UserService();
        userService.saveUser(user);

    }
}
