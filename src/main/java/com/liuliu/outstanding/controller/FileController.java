package com.liuliu.outstanding.controller;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileController {

    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file) throws IOException {
        String path = System.getProperty("user.dir");
        File destFile = new File(path + File.separator + "test-upload.txt");
        try {
            if (!destFile.exists()) {
                destFile.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        file.transferTo(destFile);
        return "success!";
    }


}
