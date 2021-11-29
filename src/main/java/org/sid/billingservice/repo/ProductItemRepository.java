package org.sid.billingservice.repo;

import org.sid.billingservice.entitites.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    public List<ProductItem> findByBillId(Long id);

    @Query(value = "SELECT quantity * price FROM ProductItem ")
    public double totalPrice();

}
