package com.react.form.services;

import com.react.form.models.User;
import com.react.form.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    // Just the bare minimun x2
    public User createUser(User user) {
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        if (user.getActive() == null) {
            user.setActive(Boolean.TRUE);
        }
        return userRepository.save(user);
    }

}
