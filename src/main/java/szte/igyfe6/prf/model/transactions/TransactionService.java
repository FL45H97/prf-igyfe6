package szte.igyfe6.prf.model.transactions;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactions();
}