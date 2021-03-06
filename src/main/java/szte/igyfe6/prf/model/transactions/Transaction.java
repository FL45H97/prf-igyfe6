package szte.igyfe6.prf.model.transactions;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int productID;
    private String date;
    private int price;
    private int quantity;

    public Transaction() {
    }

    public Transaction(int id, int productID, int price, int quantity) {
        this.id = id;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.date = LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
