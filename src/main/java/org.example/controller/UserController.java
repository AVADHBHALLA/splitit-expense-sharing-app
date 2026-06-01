package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.model.UserDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createuser(@RequestBody UserDto dto){
        if(dto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            User user = userService.create(dto);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
