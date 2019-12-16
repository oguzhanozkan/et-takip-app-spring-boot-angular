package com.ettakip.EtTakip.service.impl;

import com.ettakip.EtTakip.entity.User;
import com.ettakip.EtTakip.repository.UserRepository;
import com.ettakip.EtTakip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> getByUserId(Long userId) {
        return null;
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }
}
