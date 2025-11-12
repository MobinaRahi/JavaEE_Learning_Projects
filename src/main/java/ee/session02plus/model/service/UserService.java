package ee.session02plus.model.service;

import ee.session02plus.exception.DuplicateUsernameException;
import ee.session02plus.model.entity.User;
import ee.session02plus.model.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    public void saveUser(User user) throws Exception {
        UserRepository userRepository = new UserRepository();
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateUsernameException("Duplicate Username " + user.getUsername());
        }
        userRepository.save(user);
    }

    public void editUser(User user) throws Exception {
        UserRepository userRepository = new UserRepository();
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateUsernameException("Duplicate Username " + user.getUsername());
        }
        userRepository.update(user);
    }

    public void deleteUserById(Integer id) {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Integer id) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findById(id);
    }

    public Optional<User> getByUsername(String username) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUser() {
        UserRepository userRepository = new UserRepository();
        return userRepository.findAll();
    }
}
