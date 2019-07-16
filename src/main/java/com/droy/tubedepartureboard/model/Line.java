package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Line {

    private String id;

    private String name;

    private String modeName;

    private List<Disruption> disruptions;

    private String created;

    private String modified;

    private List<LineStatus> lineStatuses;

    private List<MatchedRoute> routeSections;

    private List<LineServiceTypeInfo> serviceTypes;

    private Crowding crowding;

}
