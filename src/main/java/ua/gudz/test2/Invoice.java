package ua.gudz.test2;

import lombok.Data;

import java.util.ArrayList;
import java.util.Random;

@Data
public class Invoice {
    private String type;
    private String wholesale = "wholesale";
    private String retail = "retail";
    int limit = new Random().nextInt(10000);
    Customer myCustomer;
    private ArrayList<Electronics> list;

    public Invoice(String type, ArrayList<Electronics> list, Customer myCustomer) {
        this.type = type;
        this.list = list;
        this.myCustomer = myCustomer;
    }
}

