package org.example.student_hostel.domain;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole implements GrantedAuthority {

    public static final long ADMIN = 1;
    public static final long STUDENT = 2;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return name;
    }


    public static UserRole getAdminRole(){
        UserRole userRole = new UserRole();
        userRole.setId(ADMIN);
        userRole.setName("ADMIN");
        return userRole;
    }

    public static UserRole getStudentRole(){
        UserRole userRole = new UserRole();
        userRole.setId(STUDENT);
        userRole.setName("STUDENT");
        return userRole;
    }

}
