package by.grodno.pvt.site.webappsample.domain;


import by.grodno.pvt.site.webappsample.domain.OrderList;
import by.grodno.pvt.site.webappsample.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "user_address_id")
    private UserAddress userAddress;

    @Column
    private Date dateOrder;

    @Column
    private Boolean statePlayment = false;;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderList> orderLists = new ArrayList<>();

    @Column
    private Double sumOrder;


    public Order(){

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Boolean getStatePlayment() {
        return statePlayment;
    }

    public void setStatePlayment(Boolean statePlayment) {
        this.statePlayment = statePlayment;
    }

    public Double getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(Double sumOrder) {
        this.sumOrder = sumOrder;
    }


    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public List<OrderList> getOrderLists() {
        return orderLists;
    }

    public void setOrderLists(List<OrderList> orderLists) {
        this.orderLists = orderLists;
    }
}
