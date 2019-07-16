package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineGroup {

    private String naptanIdReference;

    private String stationAtcoCode;

    private List<String> lineIdentifier;

}
