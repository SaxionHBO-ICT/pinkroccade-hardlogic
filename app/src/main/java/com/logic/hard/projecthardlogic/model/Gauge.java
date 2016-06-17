package com.logic.hard.projecthardlogic.model;

/**
 * Created by Werner on 17-06-16.
 */
public class Gauge {
    private String name;
    private double minValue;
    private double maxValue;
    private double inputValue;

    public Gauge(String name, double minValue, double maxValue, double inputValue) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.inputValue = inputValue;
    }
}
