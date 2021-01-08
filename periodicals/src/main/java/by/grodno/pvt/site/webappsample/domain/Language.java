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

public Language(){

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

    public Language(String name){
    this.name=name;
}



}
