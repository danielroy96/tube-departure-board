package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mode {

    private boolean isTflService;

    private boolean isFarePaying;

    private boolean isScheduledService;

    private String modeName;
}
