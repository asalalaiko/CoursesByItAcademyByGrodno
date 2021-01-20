package by.grodno.pvt.site.webappsample.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Date dateFirstAvailable;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Release> releases;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Product() {}

   public Product(String name, String isin, Date dateFirstAvailable) {
        this.name = name;
        this.isin = isin;
        this.dateFirstAvailable = dateFirstAvailable;
    }
    public Product(String name, String isin, Date dateFirstAvailable, Publisher publisher) {
        this.name = name;
        this.isin = isin;
        this.dateFirstAvailable = dateFirstAvailable;
        this.publisher = publisher;
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

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Date getDateFirstAvailable() {
        return dateFirstAvailable;
    }

    public void setDateFirstAvailable(Date dateFirstAvailable) {
        
        this.dateFirstAvailable = dateFirstAvailable;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
