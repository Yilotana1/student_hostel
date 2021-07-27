package org.example.student_hostel.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.File;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {

    public static void createDirIfNotExist(String path){
        File pathFile = new File(path);
        if (!pathFile.exists()){
            pathFile.mkdir();
        }
    }


    protected static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors
                .toMap(
                        fieldError -> fieldError.getField() + "Error",
                        FieldError::getDefaultMessage
                );


        return bindingResult.getFieldErrors().stream().collect(collector);
    }
}
