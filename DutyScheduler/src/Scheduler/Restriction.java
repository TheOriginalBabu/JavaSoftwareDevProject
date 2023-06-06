package Scheduler;

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
    private int week;
    private Time time;
    private boolean isAvailable;

    /**
     * Instantiates a new Restriction.
     *
     * @param description the description
     * @param date        the date
     * @param week        the week
     * @param time        the time
     * @param isAvailable the isAvailable
     */
    public Restriction(String description, Date date, int week,Time time, boolean isAvailable) {
        this.description = description;
        this.date = date;
        this.week = week;
        this.time = time;
        this.isAvailable = isAvailable;
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
     * Gets week.
     *
     * @return the week
     */
    public int getWeek() {
        return week;
    }

    /**
     * Sets week.
     *
     * @param week the week
     */
    public void setWeek(int week) {
        this.week = week;
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

    /**
     * Gets isAvailable.
     *
     * @return the isAvailable
     */
    public boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * Sets isAvailable.
     *
     * @param isAvailable the isAvailable
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
