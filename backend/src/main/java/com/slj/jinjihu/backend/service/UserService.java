package com.slj.jinjihu.backend.service;

import com.slj.jinjihu.backend.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserEntity saveUser(UserEntity user);

    List<UserEntity> findByCondition(Map<String, String> params);

    UserEntity findUserById(Long id);
}
