package com.olehedza.reviews.service.impl;

import com.olehedza.reviews.model.User;
import com.olehedza.reviews.repository.UserRepository;
import com.olehedza.reviews.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {
    private final UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }
}
