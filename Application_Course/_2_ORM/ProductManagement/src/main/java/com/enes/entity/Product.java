package com.enes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "products__customers", joinColumns = @JoinColumn(name = "productid"), inverseJoinColumns = @JoinColumn(name = "custemerid"))
    private List<Customer> customers;
}
