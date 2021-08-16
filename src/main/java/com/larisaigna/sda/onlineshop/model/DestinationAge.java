package com.larisaigna.sda.onlineshop.model;

public enum DestinationAge {

    AGE_RANGE_0_3_YEARS("0 - 3 ani"),
    AGE_RANGE_3_5_YEARS("3 - 5 ani"),
    AGE_RANGE_5_7_YEARS("5 - 7 ani"),
    OVER_7_YEARS("peste 7 ani");

    private final String displayValue;


    DestinationAge(String displayValue) {

        this.displayValue = displayValue;
    }

    public String getDisplayValue() {

        return displayValue;
    }
}
