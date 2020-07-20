package com.olehedza.reviews.service;

import com.olehedza.reviews.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User addUser(User user);

    Page<String> getAll(Pageable pageable);
}
