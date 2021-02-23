package by.grodno.pvt.site.webappsample.domain;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Entity
@Table(name = "user_table")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @Email
    private String username;


    @NotNull
    @Column(nullable = false)
    @Length(min = 5)
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole roles;

    private Boolean active = false;

    private String activationCode;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setRoles(UserRole user) {
        this.roles = roles;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setActivationCode(String toString) {
        this.activationCode = activationCode;
    }

    public void setPassword(String encode) {
        this.password = password;
    }
}




