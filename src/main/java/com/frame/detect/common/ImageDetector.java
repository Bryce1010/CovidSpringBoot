package com.frame.detect.common;

import org.springframework.web.multipart.MultipartFile;

public interface ImageDetector {
    String getDetectImageByCode(MultipartFile fileDir);
}
