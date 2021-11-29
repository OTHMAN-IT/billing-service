package org.sid.billingservice.web;

import org.sid.billingservice.entitites.Bill;
import org.sid.billingservice.feign.CustomerServiceClient;
import org.sid.billingservice.feign.InventoryServiceClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repo.BillRepository;
import org.sid.billingservice.repo.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

    BillRepository billRepository;
    ProductItemRepository productItemRepository;
    CustomerServiceClient customerServiceClient;
    InventoryServiceClient inventoryServiceClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerServiceClient customerServiceClient, InventoryServiceClient inventoryServiceClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceClient = customerServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    @GetMapping(path = "/FullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceClient.findCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            Product product = inventoryServiceClient.findProductById(pi.getProductID());
            //pi.setProduct(product);
            pi.setProductName(product.getName());
            pi.setProductRef(product.getReference());
        });
        // bill.getCustomerID();


        return bill;
    }
}
