package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Expense;
import org.example.model.ExpenseDto;
import org.example.model.ExpenseResponseDto;
import org.example.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseDto dto){
        if(Objects.isNull(dto)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            ExpenseResponseDto response = expenseService.createExpense(dto);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
