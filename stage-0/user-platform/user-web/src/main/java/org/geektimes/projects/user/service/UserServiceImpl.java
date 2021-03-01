package org.geektimes.projects.user.service;

import org.apache.commons.lang.StringUtils;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        userRepository = new DatabaseUserRepository(dbConnectionManager);
    }

    @Override
    public boolean register(User user) {
        if (StringUtils.isEmpty(user.getName())
                || StringUtils.isEmpty(user.getPassword()))return false;
        return userRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
