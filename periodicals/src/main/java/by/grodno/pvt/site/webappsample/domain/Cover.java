package by.grodno.pvt.site.webappsample.domain;

import javax.persistence.*;

@Entity
public class Cover {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String picture;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Cover cover;


}
