package com.slj.jinjihu.backend.service.impl;

import com.slj.jinjihu.backend.dao.UserDao;
import com.slj.jinjihu.backend.dao.UserNativeDao;
import com.slj.jinjihu.backend.entity.UserEntity;
import com.slj.jinjihu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    private UserNativeDao userNativeDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userDao.save(user);
    }

    @Override
    public List<UserEntity> findByCondition(Map<String, String> params) {
        List<UserEntity> users = new ArrayList<>();
        List records = userNativeDao.findUserByCondition(params);
        records.stream().forEach(record -> {
            HashMap temp = (HashMap) record;
            UserEntity user = new UserEntity();
            String id = String.valueOf(temp.get("id"));
            user.setId(Long.parseLong(id));
            user.setUserName((String) temp.get("userName"));
            users.add(user);
        });
        return users;
    }

    @Override
    public UserEntity findUserById(Long id) {
        Optional<UserEntity> optional = userDao.findById(id);
        return optional.get();
    }
}
