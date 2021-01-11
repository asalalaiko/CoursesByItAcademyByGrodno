package by.grodno.pvt.site.webappsample.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String link_cover;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Release() {}

    public Release(Integer id) {
        this.id = id;
    }

//    public Release(Integer id, String name, String description) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//    }

    public Release(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink_cover() {
        return link_cover;
    }

    public void setLink_cover(String link_cover) {
        this.link_cover = link_cover;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

