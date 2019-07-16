package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoint {

    private String naptanId;

    private String platformName;

    private String indicator;

    private String stopLetter;

    private List<String> modes;

    private String icsCode;

    private String smsCode;

    private String stopType;

    private String stationNaptan;

    private String accessibilitySummary;

    private String hubNaptanCode;

    private List<Identifier> lines;

    private LineGroup lineGroup;

    private LineModeGroup lineModeGroup;

    private String fullName;

    private String naptanMode;

    private boolean status;

    private String id;

    private String url;

    private String commonName;

    private Number distance;

    private String placeType;

    private List<AdditionalProperties> additionalProperties;

    private List<Place> children;

    private List<String> childrenUrls;

    private Number lat;

    private Number lon;



}
