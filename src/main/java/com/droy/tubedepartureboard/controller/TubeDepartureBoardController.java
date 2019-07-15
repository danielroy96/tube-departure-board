package com.droy.tubedepartureboard.controller;

import com.droy.tubedepartureboard.service.TflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TubeDepartureBoardController {

    private TflService tflService;

    @Autowired
    public TubeDepartureBoardController(TflService tflService) {
        this.tflService = tflService;
    }

    @GetMapping({"/", "/view"})
    public String trafficLightView(Model model) {
        model.addAttribute("arrivalPredictions" ,tflService.getStopPointArrivalPredictions("940GZZLUEMB"));
        return "departure-board";
    }

}
