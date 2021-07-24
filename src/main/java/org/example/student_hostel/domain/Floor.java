package org.example.student_hostel.domain;


import javax.persistence.*;

@Entity
@Table(name = "floor")
public class Floor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;

    private Integer apartmentsCount;

    @OneToOne
    @JoinColumn(name = "head_student")
    private User headStudent;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", apartmentsCount=" + apartmentsCount +
                ", headStudent=" + headStudent +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getApartmentsCount() {
        return apartmentsCount;
    }

    public void setApartmentsCount(int apartmentsCount) {
        this.apartmentsCount = apartmentsCount;
    }

    public User getHeadStudent() {
        return headStudent;
    }

    public void setHeadStudent(User headStudent) {
        this.headStudent = headStudent;
    }
}
