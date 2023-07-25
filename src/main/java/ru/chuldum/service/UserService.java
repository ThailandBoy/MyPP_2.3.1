package ru.chuldum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuldum.entity.User;
import ru.chuldum.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceIntr{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new RuntimeException("User not found for id: " + id);
        }
        return user;
    }

    @Transactional
    @Override
    public void deleteViaId(long id) {
        userRepository.deleteById(id);
    }
}
