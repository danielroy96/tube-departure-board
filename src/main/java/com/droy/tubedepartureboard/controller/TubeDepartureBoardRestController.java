package com.droy.tubedepartureboard.controller;

import com.droy.tubedepartureboard.model.enumeration.Line;
import com.droy.tubedepartureboard.model.tfl.Prediction;
import com.droy.tubedepartureboard.model.tfl.StopPoint;
import com.droy.tubedepartureboard.service.TflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping("/rest")
public class TubeDepartureBoardRestController {

    private TflService tflService;

    @Autowired
    public TubeDepartureBoardRestController(TflService tflService) {
        this.tflService = tflService;
    }

    @GetMapping("/StopPoint/{stopPoint}/arrivals")
    public List<Prediction> getStopPointPredictions(@PathVariable String stopPoint) {
        return tflService.getPredictionsForStopPoint(stopPoint);
    }

    @GetMapping("StopPoint/{stopPoint}/lines")
    public Set<Line> getStopPointLines(@PathVariable String stopPoint) {
        return tflService.getPredictionsForStopPoint(stopPoint)
            .stream()
            .map(prediction -> Line.fromId(prediction.getLineId()))
            .collect(toSet());
    }

    @GetMapping("/StopPoint/{stopPoint}")
    public StopPoint getStopPoint(@PathVariable String stopPoint) {
        return tflService.getStopPoint(stopPoint);
    }

}
