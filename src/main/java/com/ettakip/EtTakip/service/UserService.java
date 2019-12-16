package com.ettakip.EtTakip.service;

import com.ettakip.EtTakip.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getByUserId(Long userId);

    Boolean delete(User user);
}
