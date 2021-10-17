package ua.gudz.test2;

import lombok.Data;
import ua.gudz.test2.electronics.Electronics;
import ua.gudz.test2.services.PersonService;
import ua.gudz.test2.services.ShopService;

import java.util.ArrayList;
import java.util.Random;

@Data
public
class Invoice {
    private String type;
    private int limit = new Random().nextInt(20000);
    Customer myCustomer;
    private ArrayList<Electronics> list;

    public Invoice(String type, ArrayList<Electronics> list, Customer myCustomer) {
        this.type = type;
        this.list = list;
        this.myCustomer = myCustomer;
    }

    public Invoice() {
    }

    public Invoice createInvoice(ArrayList<Electronics> in) {
        Invoice invoice = new Invoice();
        ShopService service = new ShopService();
        int whatType = service.sum(in);
        invoice.setType(whatType > limit ? "wholesale" : "retail");
        invoice.setList(in);
        invoice.setMyCustomer(new Customer(new PersonService()));
        return invoice;
    }
}