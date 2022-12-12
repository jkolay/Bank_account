package com.example.transaction.service;

import com.example.transaction.exceptions.BankAccountManagerException;
import com.example.transaction.model.User;
import com.example.transaction.repository.UserRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final String MESSAGE_FORMAT_NO_CUSTOMER = "No customer by customerId: %d";

    @Autowired
    private UserRepository userRepository;
    public User getUser(Long userId) {
        Preconditions.checkNotNull(userId, MESSAGE_FORMAT_NO_CUSTOMER, userId);

        return userRepository.findById(userId)
                .orElseThrow(() -> BankAccountManagerException.to(MESSAGE_FORMAT_NO_CUSTOMER, userId));
    }
}
