package by.grodno.pvt.site.webappsample.domain;

import by.grodno.pvt.site.webappsample.repo.CategoryRepo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    private List<Product> products;

public Publisher(){

}

public Publisher(String name, String contact){
    this.name=name;
    this.contact=contact;
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
