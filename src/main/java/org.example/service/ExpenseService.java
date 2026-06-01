package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Expense;
import org.example.entity.User;
import org.example.model.ExpenseDto;
import org.example.repository.ExpenseRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public Expense createExpense(ExpenseDto dto){

        User payer = userRepository
                .findById(dto.getPayerId())
                .orElseThrow(
                        () -> new RuntimeException(
                                "Payer not found"
                        )
                );

        List<User> participants =
                userRepository.findAllById(
                        dto.getParticipantIds());

        Expense expense = new Expense();

        expense.setDescription(
                dto.getDescription());

        expense.setTotalAmount(
                dto.getAmount());

        expense.setPayer(payer);

        expense.setParticipants(
                participants);

        return expenseRepository.save(expense);
    }
}
