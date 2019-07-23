package com.droy.tubedepartureboard.service;

import com.droy.tubedepartureboard.model.tfl.Prediction;
import com.droy.tubedepartureboard.model.tfl.StopPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TflService {

    @Value("${api.tfl.gov.uk.id}")
    private String app_id;

    @Value("${api.tfl.gov.uk.key}")
    private String app_key;

//    @Cacheable("predictions")
    public List<Prediction> getPredictionsForStopPoint(String stopPoint) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Prediction>> responseEntity = restTemplate.exchange(
                buildUrl("StopPoint/" + stopPoint + "/arrivals"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Prediction>>() {} );
        return responseEntity.getBody();
    }

    public StopPoint getStopPoint(String stopPoint) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StopPoint> responseEntity = restTemplate.exchange(
                buildUrl("StopPoint/" + stopPoint),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<StopPoint>(){});
        return responseEntity.getBody();
    }

    public List<StopPoint> getAllStopPoints() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<StopPoint>> responseEntity = restTemplate.exchange(
                buildUrl("StopPoint/Type/NaptanMetroStation"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StopPoint>>() {});
        return responseEntity.getBody();
    }

    private String buildUrl(String apiPath) {
        return "https://api.tfl.gov.uk/" +
                apiPath +
                "?app_id=" + app_id +
                "&app_key=" + app_key;
    }

}
