package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchedRoute {

    private String routeCode;

    private String name;

    private String direction;

    private String originationName;

    private String destinationName;

    private String originator;

    private String destination;

    private String serviceType;

    private String validTo;

    private String validFrom;
}
