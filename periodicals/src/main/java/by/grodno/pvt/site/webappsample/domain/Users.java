package by.grodno.pvt.site.webappsample.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;

    private String password;

    private String email;

    private String role;




}
