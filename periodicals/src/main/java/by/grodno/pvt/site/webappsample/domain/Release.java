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

    public Release(Integer id) {
        this.id = id;
    }
}
