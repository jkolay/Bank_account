package com.example.transaction.converter;

import com.example.transaction.model.Card;
import com.example.transaction.model.dto.CardDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToCard implements Converter<CardDto, Card> {
    @Override
    public Card convert(CardDto cardDto) {

        return Card.builder()
                .cardType(cardDto.getCardType())
                .cardNumber(cardDto.getNumber())
                .expiryDate(cardDto.getExpiryDate())
                .cvv(cardDto.getCvv())
                .build();
    }
}
