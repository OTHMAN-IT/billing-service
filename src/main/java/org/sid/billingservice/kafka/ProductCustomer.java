package org.sid.billingservice.kafka;

import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class ProductCustomer {
    @Bean
    public Consumer<List<Product>> productConsumer(){
        System.out.println("Tessst");
        return (input)->{
            System.out.println("---------------");
            System.out.println(input.toString());
            System.out.println("----------------");
        };
    }



    @Bean
    public Consumer<List<Customer>> consumerConsumer(){
        System.out.println("Tessst");
        return (input)->{
            System.out.println("---------------");
            System.out.println(input.toString());
            System.out.println("----------------");
            //System.out.println(input.getName());
        };
    }

   /* @Bean
    public Consumer<String> productConsumer(){
        System.out.println("Tessst");
        return (input)->{
            System.out.println("---------------");
            System.out.println(input);
            System.out.println("----------------");

        };
    }*/
}
