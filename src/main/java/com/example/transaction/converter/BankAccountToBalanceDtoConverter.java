package com.example.transaction.converter;

import com.example.transaction.model.BankAccount;
import com.example.transaction.model.dto.BalanceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BankAccountToBalanceDtoConverter implements Converter<BankAccount, BalanceDto> {

    @Override
    public BalanceDto convert(BankAccount bankAccount) {
        return BalanceDto.builder()
                .bankAccountId(bankAccount.getId())
                .currentBalance(bankAccount.getCurrentBalance())
                .build();
    }

}
