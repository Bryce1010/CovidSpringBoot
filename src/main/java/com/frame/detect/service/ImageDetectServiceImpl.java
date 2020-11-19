package com.frame.detect.service;

import com.frame.detect.common.ImageDetector;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageDetectServiceImpl implements ImageDetectService {

    private Logger logger = LoggerFactory.getLogger(ImageDetectServiceImpl.class);

    @Autowired
    private ImageDetector imageDetector;

    @Override
    public String detectByFile(MultipartFile imageFile) {


            //BASE64Encoder base64Encoder = new BASE64Encoder();
            //String base64EncoderImg = base64Encoder.encode(imageFile.getBytes());
//            Base64.Encoder encoder = Base64.getEncoder();
//            String base64EncoderImg = encoder.encodeToString(imageFile.getBytes());

        return imageDetector.getDetectImageByCode(imageFile);


    }
}
