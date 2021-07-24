package org.example.student_hostel.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "apartment_type")
public class ApartmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

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

    @Override
    public String toString() {
        return name;
    }
}
