package ee.session01.model.service;

import ee.session01.model.entity.User;
import ee.session01.model.repository.UserRepository;

import java.sql.SQLException;
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

    public Optional<User> getByUsername(String username) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findByUsername(username);
    }

    public Optional<User> getByUsernameAndPassword(String username, String password) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<User> getAllUser() {
        UserRepository userRepository = new UserRepository();
        return userRepository.findAll();
    }
}
