package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Disruption {

    private String category;

    private String type;

    private String categoryDescription;

    private String description;

    private String summary;

    private String additionalInfo;

    private String created;

    private String lastUpdate;

    private List<RouteSection> affectedRoutes;

    private List<StopPoint> affectedStops;

    private String closuretext;

}
