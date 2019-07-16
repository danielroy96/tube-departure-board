package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

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
