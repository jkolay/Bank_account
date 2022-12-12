package com.example.transaction.controller;

import com.example.transaction.model.BankAccount;
import com.example.transaction.model.dto.BalanceDto;
import com.example.transaction.model.dto.BankAccountDto;
import com.example.transaction.service.BankAccountService;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor(onConstructor_ = {@Autowired})
@RestController
@RequestMapping(BankAccountController.SERVICE_PATH)
public class BankAccountController {

    public static final String SERVICE_PATH = "api/bank/account";
    private static final String METHOD_GET_BALANCE_WITH_PARAM = "/balance/{bankAccountId}";
    public static final String METHOD_GET_BALANCE_ALL = "/balance/all";

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    ConversionService conversionService;


    @GetMapping(value = METHOD_GET_BALANCE_ALL)
    public List<BalanceDto> getBalanceByAccountId() {
        //LOG.info("/{}{} called", SERVICE_PATH, METHOD_GET_BALANCE_ALL);

        return bankAccountService.getBankAccountList().stream().map(bankAccount -> conversionService.convert(bankAccount, BalanceDto.class)).collect(Collectors.toList());
    }

    @GetMapping(value = METHOD_GET_BALANCE_WITH_PARAM)
    public BalanceDto getBalance(@PathVariable(name = "bankAccountId") Long bankAccountId) {
        // LOG.info("/{}{}/{} called", SERVICE_PATH, METHOD_GET_BALANCE, bankAccountId);

        BankAccount bankAccount = bankAccountService.getBankAccount(bankAccountId);
        return conversionService.convert(bankAccount, BalanceDto.class);
    }


    @PutMapping(value = "{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveAccount(@PathVariable(name = "customerId") Long customerId,
                             @RequestBody BankAccountDto bankAccountDto) {
        //LOG.info("/{}/{} called with bankAccountDto: {}", SERVICE_PATH, customerId, bankAccountDto);
        // we used checkArgument instead of checkNotNull because we want an IllegalArgumentException
        Preconditions.checkArgument(bankAccountDto != null, "bankAccountDto can not be null");
        Preconditions.checkArgument(bankAccountDto.getCard() != null, "bankAccountDto.card can not be null");
        BankAccount bankAccount = conversionService.convert(bankAccountDto, BankAccount.class);
        bankAccountService.addBankAccount(customerId, bankAccount);
    }
}
