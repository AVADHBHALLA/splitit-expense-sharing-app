package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.User;
import org.example.model.UserDto;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User create(UserDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return userRepository.save(user);
    }
}
