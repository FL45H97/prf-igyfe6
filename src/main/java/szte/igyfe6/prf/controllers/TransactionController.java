package szte.igyfe6.prf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import szte.igyfe6.prf.model.transactions.Transaction;
import szte.igyfe6.prf.model.transactions.TransactionService;
import szte.igyfe6.prf.model.products.ProductService;

/**
 * This class is used for operating with transactions.
 * You can list or add transactions.
 */
@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class TransactionController {

    ProductService pService;
    TransactionService tService;

    @Autowired
    public TransactionController(TransactionService tService, ProductService pService) {
        this.tService = tService;
        this.pService = pService;
    }

    /**
     * Get all transactions
     * @return List of transactions
     */
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        try {
            return this.tService.getTransactions();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Create new transaction
     * @param trx the new transaction that should be added
     * @return A message on operation outcome.
     */
    @PostMapping(path="/transaction", consumes = "application/json")
    public String addTransaction(@RequestBody Transaction trx) {
        try {
            this.tService.addTransaction(trx);
            this.pService.sellProduct(trx.getId());
            return "Transaction was created.";
        } catch (Exception e) {
            System.out.println(e);
            return "Error! Could not create transaction!";
        }
    }


}