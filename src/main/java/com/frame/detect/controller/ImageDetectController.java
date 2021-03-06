package com.frame.detect.controller;

import com.frame.detect.service.ImageDetectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller("/")
public class ImageDetectController {

    private Logger logger = LoggerFactory.getLogger(ImageDetectController.class);

    @Autowired
    private ImageDetectService imageDetectService;

    // test for upload files
    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    // test for upload files
    @PostMapping("/upload")
    @ResponseBody
    public String update(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/tmp/Downloads/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败";
    }

    @GetMapping("/detect")
    public String detectImage() {
        return "detect";
    }

    @PostMapping("/detect")
    @ResponseBody
    public String detectImage(@RequestParam("file") MultipartFile file) {

        if(file.isEmpty()){
            return "上传失败，请选择文件";
        }

        try {
            // detect image
            String s = imageDetectService.detectByFile(file);
            logger.info(String.format("result: {}", s));
            return s;

        } catch (Exception e){
            logger.error(e.toString(),e);
        }
        // model and view

        return "上传失败";
    }

}
