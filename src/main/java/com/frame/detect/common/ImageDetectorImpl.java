package com.frame.detect.common;

import com.frame.detect.client.ImageDetectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageDetectorImpl implements ImageDetector {

    @Autowired
    private ImageDetectClient imageDetectClient;

    @Override
    public String getDetectImageByCode(MultipartFile fileDir) {
        MultiValueMap<String, Object>paramMap = new LinkedMultiValueMap<>();
        paramMap.add("file",fileDir.getResource());
        return imageDetectClient.getDetectImagePost(paramMap);
    }
}
