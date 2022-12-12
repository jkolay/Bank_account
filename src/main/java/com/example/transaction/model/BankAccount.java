package com.example.transaction.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_account")
@Builder
@Entity
//@EntityListeners(AuditingEntityListener.class)
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bank_account_generator")
    @SequenceGenerator(name="bank_account_generator", sequenceName="bank_account_generator", allocationSize=1,initialValue = 1015)
    @Column(name = "id")
    private Long id;


    @Column(name = "iban")
    private String iban;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy = "bankAccount")
    private Card card;



    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
