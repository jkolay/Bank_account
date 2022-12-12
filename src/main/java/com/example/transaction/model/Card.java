package com.example.transaction.model;

import com.example.transaction.model.type.CardTpe;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "card_details")
@EntityListeners(AuditingEntityListener.class)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="card_generator")
    @SequenceGenerator(name="card_generator", sequenceName="card_generator", allocationSize=1,initialValue = 1015)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardTpe cardType;

    @NotNull
    @Column(name = "card_number")
    private String cardNumber;

    @NotNull
    @Column(name = "holder_name")
    private String name;

    @NotNull
    @Column(name = "expiry_date")
    private String expiryDate;

    @NotNull
    @Column(name = "cvv")
    private String cvv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    private BankAccount bankAccount;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;


}
