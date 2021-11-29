package org.sid.billingservice.feign;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface InventoryServiceClient {
    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable("id") Long id);

    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts();
}
