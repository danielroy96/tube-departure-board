package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineStatus {

    private int id;

    private String lineId;

    private int statusSeverity;

    private String statusSeverityDescription;

    private String reason;

    private String created;

    private String modified;

    private List<ValidityPeriod> validityPeriods;

    private Disruption disruption;

}
