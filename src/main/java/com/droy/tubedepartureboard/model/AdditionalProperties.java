package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalProperties {

    private String category;

    private String key;

    private String sourceSystemKey;

    private String value;

    private String modified;

}
