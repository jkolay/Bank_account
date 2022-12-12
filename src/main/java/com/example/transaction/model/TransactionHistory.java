package com.example.transaction.model;

import com.example.transaction.model.type.TransactionStatus;
import com.example.transaction.model.type.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_history")
@EntityListeners(AuditingEntityListener.class)
public class TransactionHistory {
    @Id
    @GenericGenerator(name = "transaction_generator", strategy = "increment")
    @GeneratedValue(generator = "transaction_generator")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Long customerId;

    private Long bankAccountId;

    private Long cardId;

    private BigDecimal amount;

    private BigDecimal fee;

    private BigDecimal totalAmount;

    private BigDecimal beforeBalance;

    private BigDecimal afterBalance;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private String failingReason;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
