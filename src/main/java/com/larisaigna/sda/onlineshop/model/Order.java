package com.larisaigna.sda.onlineshop.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "customer_address")
    private String customerAddress;

    @OneToMany(mappedBy = "order")
    private List <OrderLine> orderLines;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public Order(Long id, Timestamp creationDate, String deliveryAddress, String customerAddress, List<OrderLine> orderLines, Customer customer, OrderStatus orderStatus, Bill bill) {
        this.id = id;
        this.creationDate = creationDate;
        this.deliveryAddress = deliveryAddress;
        this.customerAddress = customerAddress;
        this.orderLines = orderLines;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.bill = bill;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", orderLines=" + orderLines +
                ", customer=" + customer +
                ", orderStatus=" + orderStatus +
                ", bill=" + bill +
                '}';
    }
}
