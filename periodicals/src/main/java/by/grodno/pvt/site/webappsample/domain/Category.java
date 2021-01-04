package by.grodno.pvt.site.webappsample.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Category(){

    }

    public Category(String name) {
        this.name=name;
    }

}
