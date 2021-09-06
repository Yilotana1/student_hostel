package org.example.student_hostel.repo;

import org.example.student_hostel.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ApartmentRepo extends JpaRepository<Apartment, Long> {


    @Query("SELECT a FROM Apartment AS a WHERE a.floor.number IN :floorsNumbers")
    List<Apartment> findByFloorsNumbers(Collection<Integer> floorsNumbers);

    @Query("SELECT a FROM Apartment AS a WHERE a.floor.number = ?1 AND a.number = ?2")
    Apartment findByFloorAndNumber(Integer floor, Integer number);

    @Query("SELECT a FROM Apartment  AS a WHERE a.floor.number IN :floorsNumbers AND a.students.size IN :studentsNumber")
    List<Apartment> findByStudentsAndFloor(Collection<Integer> floorsNumbers, Collection<Integer> studentsNumber);
}
