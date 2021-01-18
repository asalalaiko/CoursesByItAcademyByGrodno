package by.grodno.pvt.site.webappsample.domain;

import org.springframework.security.core.GrantedAuthority;

public enum  UserRole implements GrantedAuthority {

    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
