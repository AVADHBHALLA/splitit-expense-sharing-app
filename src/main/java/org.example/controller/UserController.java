package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.model.BalanceDto;
import org.example.model.UserDto;
import org.example.model.UserResponseDto;
import org.example.service.ExpenseService;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createuser(@RequestBody UserDto dto){
        if(Objects.isNull(dto)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            UserResponseDto response = userService.create(dto);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/balances")
    public ResponseEntity<BalanceDto> getBalance(@PathVariable UUID id){
        try{
            BalanceDto balance = expenseService.getBalance(id);
            return new ResponseEntity<>(balance, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
