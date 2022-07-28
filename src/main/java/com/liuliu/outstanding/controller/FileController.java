package com.liuliu.outstanding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileController {

    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file) throws IOException {
        File destFile = new File("D:\\develop\\gitHub\\outstandingproject\\src\\main\\resources\\test-upload.txt");
        FileWriter fileWriter = new FileWriter(destFile);
        InputStream inputStream = file.getInputStream();
        fileWriter.write(inputStream.read());
        fileWriter.close();
        return "success!";
    }


}
