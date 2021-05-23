package szte.igyfe6.prf.model.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void addTransaction(Transaction ta) {
        this.transactionRepository.save(ta);
    }

    @Override
    public List<Transaction> getTransactions() {
        return this.transactionRepository.findAll();
    }
    
}
