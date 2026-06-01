package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ExpenseDto {

    private UUID payerId;

    private Double amount;

    private String description;

    private List<UUID> participantIds;
}
