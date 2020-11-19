package com.frame.detect.service;


import org.springframework.web.multipart.MultipartFile;

public interface ImageDetectService {

    String detectByFile(MultipartFile file);
}
