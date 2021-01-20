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
   private Double price;


    @Column
    private String filename;

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

    public Release(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

