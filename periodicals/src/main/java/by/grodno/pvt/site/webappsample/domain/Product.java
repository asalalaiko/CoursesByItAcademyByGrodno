package by.grodno.pvt.site.webappsample.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer type_id;

    private Integer period_id;

    private Integer day_id;

    private Integer publisher_id;

    private String issn;

    @OneToMany(mappedBy = "cover")
    private List<Cover> cover;



}
