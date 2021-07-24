package org.example.student_hostel.domain;


import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;


    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;


    @ManyToOne
    @JoinColumn(name = "type_id")
    private ApartmentType type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public ApartmentType getType() {
        return type;
    }

    public void setType(ApartmentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "number=" + number +
                ", floor=" + floor +
                ", type=" + type +
                '}';
    }
}
