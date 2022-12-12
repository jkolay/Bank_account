package com.example.transaction.model.dto;

import com.example.transaction.model.type.CardTpe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private CardTpe cardType;
    private String number;
    private String expiryDate;
    private String cvv;

}

