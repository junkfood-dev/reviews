package _2024_10_03.bank;

import java.math.BigDecimal;

public class Account {
    private int accountId;
    private int customerId;
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }
}