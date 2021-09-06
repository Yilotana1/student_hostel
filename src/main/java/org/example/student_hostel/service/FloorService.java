package org.example.student_hostel.service;

import org.example.student_hostel.repo.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FloorService {

    public static final int FLOORS_NUMBER = 4;
    public static final List<Integer> ALL_FLOORS = Arrays.asList(1, 2, 3, 4);


    private FloorRepo floorRepo;

    @Autowired
    public void setFloorRepo(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    public long getCount() {
        return this.floorRepo.count();
    }

}
