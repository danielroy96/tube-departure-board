package com.droy.tubedepartureboard.service;

import com.droy.tubedepartureboard.model.tfl.Prediction;
import com.droy.tubedepartureboard.model.tfl.StopPoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TflService {

//    @Cacheable("predictions")
    public List<Prediction> getPredictionsForStopPoint(String stopPoint) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Prediction>> responseEntity = restTemplate.exchange(
                "https://api.tfl.gov.uk/StopPoint/" + stopPoint + "/arrivals",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Prediction>>() {} );
        return responseEntity.getBody();
    }

    public StopPoint getStopPoint(String stopPoint) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StopPoint> responseEntity = restTemplate.exchange(
                "https://api.tfl.gov.uk/StopPoint/" + stopPoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<StopPoint>(){});
        return responseEntity.getBody();
    }

}
