package com.droy.tubedepartureboard.model.enumeration;

public enum Line {

    BAKERLOO("bakerloo", "FFFFFF", "AE6118"),
    CENTRAL("central", "FFFFFF", "E41F1F"),
    CIRCLE("circle", "113892", "F8D42D"),
    DISTRINCT("district", "FFFFFF", "007229"),
    DLR("dlr", "FFFFFF", "00BBB4"),
    HAMMERSMITH_AND_CITY("handc", "113892", "E899A8"),
    JUBILEE("jubilee", "FFFFFF", "686E72"),
    METROPOLITAN("metropolitan", "FFFFFF", "893267"),
    NORTHERN("northern", "FFFFFF", "000000"),
    OVERGROUND("overground", "FFFFFF", "F86F86"),
    PICADILLY("picadilly", "FFFFFF", "0450A1"),
    VICTORIA("victoria", "FFFFFF", "009FE0"),
    WATERLOO_AND_CITY("wandc", "113892", "70C3CE");

    String lineId;

    String foregroundColour;

    String backgroundColour;

    Line(String lineId, String foregroundColour, String backgroundColor) {
        this.lineId = lineId;
        this.foregroundColour = foregroundColour;
        this.backgroundColour = backgroundColor;
    }

}
