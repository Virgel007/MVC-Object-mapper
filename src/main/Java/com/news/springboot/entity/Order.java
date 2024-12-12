package com.news.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;



@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne
    private Customer customer;
    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products;
    private String shippingAddress;
    private Instant orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    //представляет заказ пользователя и содержит информацию о товарах, адресе доставки, стоимости и статусе заказа.
}
