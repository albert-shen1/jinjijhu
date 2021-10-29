package com.slj.jinjihu.backend.controller;

import com.slj.jinjihu.backend.dto.ResultDTO;
import com.slj.jinjihu.backend.entity.UserEntity;
import com.slj.jinjihu.backend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResultDTO saveUser(@RequestBody UserEntity user) {
        try {
            UserEntity newUser = userService.saveUser(user);
            return new ResultDTO(ResultDTO.SUCCESS_CODE, "", newUser);
        } catch (Exception e) {
            return new ResultDTO(ResultDTO.FAIl_CODE, "", null);
        }
    }

    @GetMapping("/user")
    public ResultDTO findUserByCondition(@RequestParam(name = "userName", required = false) String userName) {
        Map<String, String> params = new HashMap<>();
        if (StringUtils.isNotBlank(userName)) {
            params.put("userName", userName);
        }
        try {
            List<UserEntity> users = userService.findByCondition(params);
            return new ResultDTO(ResultDTO.SUCCESS_CODE, "", users);
        } catch (Exception e) {
            return new ResultDTO(ResultDTO.FAIl_CODE, "", null);
        }
    }

    @GetMapping("/user/{id}")
    public ResultDTO findUserById(@PathVariable("id") Long id) {
        try {
            UserEntity user = userService.findUserById(id);
            return new ResultDTO(ResultDTO.SUCCESS_CODE, "", user);
        } catch (Exception e) {
            return new ResultDTO(ResultDTO.FAIl_CODE, "", null);
        }
    }

    @PostMapping("/user/login")
    public ResultDTO login(@RequestBody UserEntity user) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", user.getUserName());
        params.put("password", DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        params.put("limit", "1");
        try {
            List<UserEntity> newUser = userService.findByCondition(params);
            if (newUser.isEmpty()) {
                return new ResultDTO(ResultDTO.FAIl_CODE, "", null);
            }
            String token = UUID.randomUUID().toString();
            Map response = new HashMap();
            response.put("token", token);
            response.put("userName", newUser.get(0).getUserName());
            response.put("id", newUser.get(0).getId());
            return new ResultDTO(ResultDTO.SUCCESS_CODE, "", response);
        } catch (Exception e) {
            return new ResultDTO(ResultDTO.FAIl_CODE, "", null);
        }
    }
}
