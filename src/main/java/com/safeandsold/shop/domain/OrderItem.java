package com.safeandsold.shop.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(OrderItem.class)
@Table(name = "order_items")
public class OrderItem implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "order_item_quantity")
    private Integer orderItemQuantity;

    public OrderItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(Integer orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }
}
