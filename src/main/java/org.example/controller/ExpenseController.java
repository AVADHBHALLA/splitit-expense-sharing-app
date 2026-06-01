package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Expense;
import org.example.model.ExpenseDto;
import org.example.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDto dto){
        if(dto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Expense expense = expenseService.createExpense(dto);
            return new ResponseEntity<>(expense,HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
