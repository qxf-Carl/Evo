package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.sql.LocalTransactional;
import org.geektimes.projects.user.validator.bean.validation.UserValid;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.validation.Validator;

public class UserServiceImpl implements UserService {

    @Resource(name = "bean/EntityManager")
    private EntityManager entityManager;

    @Resource(name = "bean/Validator")
    private Validator validator;

    /**
     * 默认需要事务
     *
     * @param user 用户对象
     * @return
     */
    @Override
    public boolean register(@UserValid User user) {
        entityManager.persist(user);
        return true;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    @LocalTransactional
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
