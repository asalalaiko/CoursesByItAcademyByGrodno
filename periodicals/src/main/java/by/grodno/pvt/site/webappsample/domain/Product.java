package by.grodno.pvt.site.webappsample.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String isin;

    @Column()
    private Date date_first_available;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Release> releases;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
