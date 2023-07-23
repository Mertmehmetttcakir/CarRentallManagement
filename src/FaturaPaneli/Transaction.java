package FaturaPaneli;

import java.util.Date;

public class Transaction {
    private static double price;
    private Date date;


    public Transaction(double price, Date date) {

        this.price = price;
    }


    public static double getPrice() {

        return price;
    }


    public Date getDate() {
        return date;

    }

    public void setDate(Date date) {
        this.date = date;
    }
}