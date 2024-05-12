package com.example.boot1.service;

import com.example.boot1.DAO.UserDao;
import com.example.boot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImp implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override

    public User findUser(Long id) {
        return userDao.findUser(id);
    }


    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
