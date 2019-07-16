package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidityPeriod {

    private String fromDate;

    private String toDate;

    private boolean isNow;

}
