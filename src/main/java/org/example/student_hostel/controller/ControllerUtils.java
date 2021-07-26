package org.example.student_hostel.controller;

import java.io.File;

public class ControllerUtils {

    public static void createDirIfNotExist(String path){
        File pathFile = new File(path);
        if (!pathFile.exists()){
            pathFile.mkdir();
        }
    }
}
