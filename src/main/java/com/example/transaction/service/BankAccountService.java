package com.example.transaction.service;

import com.example.transaction.exceptions.BankAccountManagerException;
import com.example.transaction.model.BankAccount;
import com.example.transaction.model.Card;
import com.example.transaction.model.User;
import com.example.transaction.repository.BankAccountRepository;
import com.example.transaction.repository.CardRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    public BankAccountRepository bankAccountRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserService userService;

    private static final String MESSAGE_FORMAT_NO_BANK_ACCOUNT = "No bankAccount found  by bankAccountId: %s";

    public List<BankAccount> getBankAccountList(){
        return  bankAccountRepository.findAll();
    }

    public BankAccount getBankAccount(Long bankAccountId) {
        Preconditions.checkNotNull(bankAccountId, MESSAGE_FORMAT_NO_BANK_ACCOUNT, bankAccountId);

        return bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> BankAccountManagerException.to(MESSAGE_FORMAT_NO_BANK_ACCOUNT, bankAccountId));
    }

    public BankAccount addBankAccount(Long userId, BankAccount bankAccount) {
        Preconditions.checkNotNull(bankAccount, "bankAccount can not be null");
        Preconditions.checkNotNull(bankAccount.getCurrentBalance(), "currentBalance can not be null");
        Preconditions.checkArgument(bankAccount.getCurrentBalance().compareTo(BigDecimal.ZERO) > -1, "CurrentBalance can not be negative");

        User user = userService.getUser(userId);
        bankAccount.setUser(user);

        Card card = bankAccount.getCard();
        card.setName(user.getFirstName()+" "+user.getLastName());

        // a workaround
        bankAccount.setCard(null);

        Date today=new Date();
        bankAccount.setCreatedAt(today);
        bankAccount.setUpdatedAt(today);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        //LOG.info("A bank account saved for customer: {}", customerId);

        card.setBankAccount(savedBankAccount);
        card.setCreatedAt(today);
        card.setUpdatedAt(today);
        cardRepository.save(card);

        return savedBankAccount;
    }
}
