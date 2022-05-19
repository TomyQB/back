package com.appuntate.back.security.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.appuntate.back.model.EventUser;
import com.appuntate.back.model.History;
import com.appuntate.back.model.Reservation;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrincipalUser implements UserDetails {

    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String userName;
    
    private String creditCard;
    private String image;

    private List<Reservation> reservations;
    private List<History> histories;
    private List<EventUser> eventUser;

    private Collection<? extends GrantedAuthority> authorities;

    public static PrincipalUser build(User user) {
        List<GrantedAuthority> authorities =
            user.getRols().stream().map(rol -> new SimpleGrantedAuthority(
                rol.getRolName().name())).collect(Collectors.toList());

        return new PrincipalUser(user.getName(),
                                    user.getLastName(),
                                    user.getPhone(),
                                    user.getEmail(),
                                    user.getPassword(),
                                    user.getUserName(),
                                    user.getCreditCard(),
                                    user.getImage(),
                                    user.getReservations(),
                                    user.getHistories(),
                                    user.getEventUser(),
                                    authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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


    
}
