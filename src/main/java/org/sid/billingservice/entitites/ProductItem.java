package org.sid.billingservice.entitites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.billingservice.model.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductItem{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private long productID;
        private double price;
        private double quantity;
        private double subPrice;
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @ManyToOne
        private Bill bill;
        @Transient
        private Product product;
        @Transient
        private String productName;
        @Transient
        private String productRef;

}
