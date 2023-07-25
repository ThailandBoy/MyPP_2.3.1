package ru.chuldum.service;

import ru.chuldum.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceIntr {
    public void save(User user);

    public List<User> getAllUser();

    public User getById(long id) ;

    public void deleteViaId(long id);
}
