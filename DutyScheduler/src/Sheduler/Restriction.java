package Sheduler;

import java.util.Date;

/**
 * The type Restriction. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-18
 * @File: Restriction
 */
public class Restriction {//todo: Error Trapping/Handling
    private String description;
    private Date date;
    private Time time;
    private boolean isAvailable;

    /**
     * Instantiates a new Restriction.
     *
     * @param description the description
     * @param date        the date
     * @param time        the time
     */
    public Restriction(String description, Date date, Time time) {
        this.description = description;
        this.date = date;
        this.time = time;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Time time) {
        this.time = time;
    }


}
