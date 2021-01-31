package by.grodno.pvt.site.webappsample.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private Date datePay;

    @Column
    private String transaction;

    @Column
    private Double sum;


    public Payment(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }




}
