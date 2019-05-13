package com.reporting.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.reporting.demo.entity.common.BaseEntity;
import com.reporting.demo.entity.enumr.Currency;
import com.reporting.demo.entity.enumr.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "TRANSACTIONS")
public class Transactions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACTIONS_ID")
    @SequenceGenerator(name = "SEQ_TRANSACTIONS_ID", sequenceName = "SEQ_TRANSACTIONS_ID", allocationSize = 1, initialValue = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MERCHANT_ID", foreignKey = @ForeignKey(name = "FK_TRANSACTION_MERCHANT"), insertable = false, updatable = false)
    private Merchant merchant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACQUIRER_ID", foreignKey = @ForeignKey(name = "FK_TRANSACTION_ACQUIRER"), insertable = false, updatable = false)
    private Acquirer acquirer;
    
    @Column(name = "AMOUNT")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY")
    private Currency currency;
   

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private TransactionStatus status;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", foreignKey =
    @ForeignKey(name = "FK_TRANSACTION_CUSTOMER"), insertable = false, updatable = false)
    private Customer customer;
    
    @Column(name = "REF_NO")
    private String refNo;
}
