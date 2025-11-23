package ee.session03.factor_program.model.service;

import ee.session03.factor_program.model.entity.User;
import ee.session03.factor_program.model.repository.UserRepository;

import java.util.List;
import java.util.Optional;


public class UserService {
    public void saveUser(User user) {
        UserRepository userRepository = new UserRepository();
        userRepository.save(user);
    }

    public void editUser(User user) {
        UserRepository userRepository = new UserRepository();
        userRepository.update(user);
    }

    public void deleteUserById(Integer id) {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteById(id);
    }

    public Optional getUserById(Integer id) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<User> getAllUsers() {
        UserRepository userRepository = new UserRepository();
        return userRepository.findAll();
    }
}
