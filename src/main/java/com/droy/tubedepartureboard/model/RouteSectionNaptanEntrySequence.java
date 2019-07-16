package com.droy.tubedepartureboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteSectionNaptanEntrySequence {

    private int ordinal;

    private StopPoint stopPoint;

}
