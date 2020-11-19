package com.frame.detect.client;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ImageDetectClientImpl implements ImageDetectClient {

    @Override
    public String getDetectImagePost(MultiValueMap<String, Object> paramMap) {
        String url = "http://182.92.198.167:15000/predict";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(paramMap, headers);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        Assert.isTrue(HttpStatus.OK == response.getStatusCode(), "http call is failed");
        return response.getBody();

    }
}
