package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Expense;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;
import org.example.model.BalanceDto;
import org.example.model.ExpenseDto;
import org.example.model.ExpenseResponseDto;
import org.example.repository.ExpenseRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseResponseDto createExpense(ExpenseDto dto){

        User payer = userRepository
                .findById(dto.getPayerId())
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Payer not found with id : "
                                        + dto.getPayerId()));

        List<User> participants = userRepository.findAllById(dto.getParticipantIds());

        Expense expense = new Expense();

        expense.setDescription(dto.getDescription());
        expense.setTotalAmount(dto.getAmount());
        expense.setPayer(payer);
        expense.setParticipants(participants);

        Expense savedExpense = expenseRepository.save(expense);

        return new ExpenseResponseDto(
                savedExpense.getId(),
                savedExpense.getDescription(),
                savedExpense.getTotalAmount()
        );
    }

    public BalanceDto getBalance(UUID userId){

        User currentUser = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : "
                                        + userId));

        double owesOthers = 0;
        double owedByOthers = 0;
        List<Expense> expenses = expenseRepository.findAll();
        for(Expense expense : expenses){
            List<User> participants = expense.getParticipants();
            double share = expense.getTotalAmount() / participants.size();
            User payer = expense.getPayer();
            if(payer.getId().equals(userId)){
                for(User participant : participants){
                    if(!participant.getId().equals(userId)){
                        owedByOthers += share;
                    }
                }
            }
            else{
                for(User participant : participants){
                    if(participant.getId().equals(userId)){
                        owesOthers += share;
                    }
                }
            }
        }
        return new BalanceDto(
                currentUser.getName(),
                owedByOthers,
                owesOthers
        );
    }
}
