package Scheduler;

import java.time.LocalTime;

/**
 * The type Time. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Time
 */
public class Time {//todo: Error Trapping/Handling
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * Instantiates a new Time.
     *
     * @param name      the name
     * @param startTime the start time
     * @param endTime   the end time
     */
    public Time(String name, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets start time.
     *
     * @return start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return end time
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets duration.
     *
     * @return duration duration
     */
    public int getDuration() {
        return (endTime.getHour() - startTime.getHour()) * 60 + (endTime.getMinute() - startTime.getMinute());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return startTime + " " + endTime;
    }
}
