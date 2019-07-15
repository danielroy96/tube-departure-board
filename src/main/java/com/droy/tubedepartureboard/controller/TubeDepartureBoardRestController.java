package com.droy.tubedepartureboard.controller;

import com.droy.tubedepartureboard.model.Prediction;
import com.droy.tubedepartureboard.service.TflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/rest")
public class TubeDepartureBoardRestController {

    private TflService tflService;

    @Autowired
    public TubeDepartureBoardRestController(TflService tflService) {
        this.tflService = tflService;
    }

    @GetMapping("/StopPoint/{id}/arrivals")
    public List<Prediction> getStopPointPredictions(@PathVariable String id) {
        List<Prediction> predictions = tflService.getStopPointArrivalPredictions(id).stream()
                .filter(prediction -> prediction.getLineId().equalsIgnoreCase("northern"))
                .sorted()
                .collect(toList());
        return predictions;
    }

}
