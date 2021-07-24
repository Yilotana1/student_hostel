package org.example.student_hostel.controller;


import org.example.student_hostel.repo.ApartmentRepo;
import org.example.student_hostel.repo.FloorRepo;
import org.example.student_hostel.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private UserRepo userRepo;
    private FloorRepo floorRepo;
    private ApartmentRepo apartmentRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setFloorRepo(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    @Autowired
    public void setApartmentRepo(ApartmentRepo apartmentRepo) {
        this.apartmentRepo = apartmentRepo;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("user", userRepo.findById(1L));
        model.addAttribute("floor", floorRepo.findById(1L));
        model.addAttribute("apartment", apartmentRepo.findById(1L));
        return "main";
    }
}
