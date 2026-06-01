package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.User;
import org.example.model.UserDto;
import org.example.model.UserResponseDto;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto create(UserDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
}
