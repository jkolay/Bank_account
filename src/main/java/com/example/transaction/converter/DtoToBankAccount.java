package com.example.transaction.converter;

import com.example.transaction.model.BankAccount;
import com.example.transaction.model.Card;
import com.example.transaction.model.dto.BankAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToBankAccount implements Converter<BankAccountDto, BankAccount> {

    ConversionService conversionService;

    /*
     * CAUTION: service must be lazy, because you cannot simply inject  a service that is not yet ready.
     * We are already still building the converters in this step.
     * */
  @Autowired
    public DtoToBankAccount(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public BankAccount convert(BankAccountDto bankAccount) {
        return BankAccount.builder()
                .iban(bankAccount.getIban())
                .currentBalance(bankAccount.getBalance())
                .card(conversionService.convert(bankAccount.getCard(), Card.class))
                .build();
    }
}
