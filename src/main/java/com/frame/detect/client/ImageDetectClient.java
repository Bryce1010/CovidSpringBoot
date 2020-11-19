package com.frame.detect.client;

import org.springframework.util.MultiValueMap;

public interface ImageDetectClient {
    String getDetectImagePost(MultiValueMap<String, Object>paramMap);
}
