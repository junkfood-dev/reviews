package _2024_10_03.bank;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private int accountId;
    private TransactionType transactionType;
    private BigDecimal amount;
    private Timestamp date;

    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER
    }

    public Transaction(TransactionType transactionType, BigDecimal amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }
}