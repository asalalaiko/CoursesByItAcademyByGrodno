package by.grodno.pvt.site.webappsample.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String addressee;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name = "order_id")
    private Order order;


    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "userAddress", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
