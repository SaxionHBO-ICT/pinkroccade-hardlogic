package com.logic.hard.projecthardlogic.model;

/**
 * Created by Werner on 17-06-16.
 */
public class Productiviteit extends Report{
    public Gauge[] gauges;
    private static Productiviteit instance;
    public static final int PRODUCTIVITEIT = 0;
    public static final int HANDENAANBED = 1;
    /**
     * Constructor
     *
     * @param title the title of the report you're going to create
     */
    public Productiviteit(String title) {
        super(title);
    }
    public static Productiviteit getInstance(){
        if(instance != null){
            instance = new Productiviteit("Productiviteit");
        }
        return instance;
    }
    public void setGauges(Gauge[] e){
        gauges = e;
    }

    public Gauge[] getGauges() {
        return gauges;
    }

}
