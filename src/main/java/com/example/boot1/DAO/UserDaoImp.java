package com.example.boot1.DAO;

import com.example.boot1.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
        log.info("Add user");
    }

    @Override
    public void removeUser(User user) {
        User managedUser = entityManager.merge(user);
        entityManager.remove(managedUser);
        log.info("remove user");
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u ", User.class).getResultList();
    }

    @Override
    public User findUser(Long id) {
        return entityManager.find(User.class, id);

    }


    @Override
    public void updateUser(User updatedUser) {
        User existingUser = entityManager.find(User.class, updatedUser.getId());
        entityManager.merge(existingUser);
        log.info("Update user");
    }
}
