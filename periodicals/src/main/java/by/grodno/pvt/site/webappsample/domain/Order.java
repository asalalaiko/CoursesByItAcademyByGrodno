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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    @JoinColumn(name = "address_id")
    private UserAddress userAddress;

    @Column
    private Date dateOrder;

    @Column(columnDefinition = "boolean default false")
    private Boolean statePlayment;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderList> orderLists = new ArrayList<>();

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

    public Integer getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(Integer sumOrder) {
        this.sumOrder = sumOrder;
    }

    @Column
    private Integer sumOrder;

}
