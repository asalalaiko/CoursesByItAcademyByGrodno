package by.grodno.pvt.site.webappsample.domain;

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

}
