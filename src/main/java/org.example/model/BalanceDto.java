package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BalanceDto {

    private String userName;

    private Double owedByOthers;

    private Double owesOthers;
}
