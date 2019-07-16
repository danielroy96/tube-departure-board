package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Crowding {

    private List<PassengerFlow> passengerFlows;

    private List<TrainLoading> trainLoadings;

}
