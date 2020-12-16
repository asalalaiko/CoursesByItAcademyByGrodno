package by.grodno.pvt.site.webappsample.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;


}
