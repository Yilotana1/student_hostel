package org.example.student_hostel.service;


import org.example.student_hostel.domain.Apartment;
import org.example.student_hostel.repo.ApartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.example.student_hostel.service.FloorService.ALL_FLOORS;

@Service
public class ApartmentService {

    private ApartmentRepo apartmentRepo;

    @Autowired
    public void setApartmentRepo(ApartmentRepo apartmentRepo) {
        this.apartmentRepo = apartmentRepo;
    }


    public List<Apartment> loadByFloors(Collection<Integer> floorsNumber) {
        return apartmentRepo.findByFloorsNumbers(floorsNumber);
    }

    public List<Apartment> loadAllApartments() {
        return apartmentRepo.findAll();
    }

    public Optional<Apartment> loadByFloorAndNumber(Integer floor, Integer number) {
        return Optional.ofNullable(apartmentRepo.findByFloorAndNumber(floor, number));
    }


    public List<Apartment> loadByFloorAndStudents(Collection<Integer> floorsNumber, Collection<Integer> studentsNumber){
        if (floorsNumber == null) floorsNumber = ALL_FLOORS;
        if (studentsNumber == null) studentsNumber = UserService.ALL_STUDENTS;

        return apartmentRepo.findByStudentsAndFloor(floorsNumber, studentsNumber);
    }

}
