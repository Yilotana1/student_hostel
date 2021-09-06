package org.example.student_hostel.controller;


import org.example.student_hostel.domain.Apartment;
import org.example.student_hostel.service.ApartmentService;
import org.example.student_hostel.service.FloorService;
import org.example.student_hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/apartments")
public class ApartmentController {


    private ApartmentService apartmentService;
    private FloorService floorService;

    @Autowired
    public void setFloorService(FloorService floorService) {
        this.floorService = floorService;
    }

    @Autowired
    public void setApartmentService(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public String getApartmentsListView(
            @RequestParam(required = false, name = "floors") Collection<Integer> floorsSelect,
            @RequestParam(required = false, name = "students") Collection<Integer> studentsSelect,
            Model model) {

        List<Apartment> apartments = apartmentService.loadAllApartments();

//        if (floorsSelect != null) {
//            apartments = apartmentService.loadApartmentsByFloors(floorsSelect);
//        }

//        if (studentsSelect != null) {
//            apartments = apartmentService.load(floorsSelect);
//        }

        if (floorsSelect != null || studentsSelect != null) {
            apartments = apartmentService.loadByFloorAndStudents(floorsSelect, studentsSelect);
        }

        model.addAttribute("students_select", studentsSelect);
        model.addAttribute("student_count", UserService.MAX_STUDENTS_IN_APARTMENT);
        model.addAttribute("floors_select", floorsSelect);
        model.addAttribute("apartments", apartments);
        model.addAttribute("floor_count", floorService.getCount());
        return "apartments_list";
    }

    @GetMapping("/select_all")
    public String selectAllApartments(Model model) {
        model.addAttribute("apartments", apartmentService.loadAllApartments());
        model.addAttribute("floors_select", FloorService.ALL_FLOORS);
        model.addAttribute("students_select", UserService.ALL_STUDENTS);
        model.addAttribute("floor_count", floorService.getCount());
        model.addAttribute("student_count", UserService.MAX_STUDENTS_IN_APARTMENT);
        return "apartments_list";
    }


    @GetMapping("/search")
    public String searchApartment(
            @RequestParam(name = "apartment_num") String apartmentS,
            Model model
    ) {
        List<Apartment> apartments = Collections.emptyList();
        Pattern pattern = Pattern.compile("^(\\d+)\\s*-\\s*(\\d+)$");
        Matcher matcher = pattern.matcher(apartmentS);

        if (!matcher.find()) {
            model.addAttribute("error", "Пожалуйста введите этаж и номер комнаты коректно");
        } else {
            Integer floorNumber = Integer.valueOf(matcher.group(1));
            Integer apartmentNumber = Integer.valueOf(matcher.group(2));

            Optional<Apartment> apartment = apartmentService.loadByFloorAndNumber(floorNumber, apartmentNumber);
            if (apartment.isPresent()) {
                apartments = Collections.singletonList(apartment.get());
            }
        }

        model.addAttribute("apartments", apartments);
        model.addAttribute("student_count", UserService.MAX_STUDENTS_IN_APARTMENT);
        model.addAttribute("floor_count", floorService.getCount());
        return "apartments_list";
    }
}
