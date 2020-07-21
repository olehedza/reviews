package com.olehedza.reviews.repository;

import com.olehedza.reviews.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u.profileName from User u order by u.reviews.size desc")
    Page<String> getAll(Pageable pageable);
}
