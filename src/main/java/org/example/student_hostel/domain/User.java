package org.example.student_hostel.domain;


import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min = 5, max = 15, message = "Логін повинен бути довжиною від 5 до 15 символів")
    private String username;

    @NotBlank(message = "Мобільний номер не повинен бути пустим")
    private String phone;

    @Email
    @NotBlank(message = "Поштовий адрес не повинен бути пустим")
    private String email;

    @Length(min = 8, message = "Пароль повинен бути довжиною не менше 8 символів")
    private String password;

    @Pattern(regexp = "[A-Za-z\\p{IsCyrillic}]+",
            message = "Ім'я повинно містити тільки латинницю або кирилицю")
    private String firstname;

    @Pattern(regexp = "[A-Za-z\\p{IsCyrillic}]+",
            message = "Прізвище повинно містити тільки латинницю або кирилицю")
    private String lastname;

    private String photoName;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private UserRole userRole;


    public UserRole getRole() {
        return userRole;
    }

    public void setRole(UserRole role) {
        this.userRole = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + userRole +
                '}';
    }
}
