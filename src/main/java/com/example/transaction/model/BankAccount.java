package com.example.transaction.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="iban")
    private String iban;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy = "bankAccount")
    private Card card;


    @NotNull
    @Min(value = 0,message = "Balance can not be Negative")
    @Column(name="current_balance")
    private Double currentBalance;

    @Column(name="created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name="updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
