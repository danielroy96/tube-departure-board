package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteSection {

    private String id;

    private String lineId;

    private String routeCode;

    private String name;

    private String lineString;

    private String direction;

    private String originationName;

    private String destinationName;

    private String validTo;

    private String validFrom;

    private RouteSectionNaptanEntrySequence routeSectionNaptanEntrySequence;
}
