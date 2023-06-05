package Sheduler;

import java.util.Date;

/**
 * The type Duty. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Duty
 */
public abstract class Duty {//todo: Error Trapping/Handling
    private Time time;
    private Location location;

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     */
    public Duty(Time time, Location location) {
        this.time = time;
        this.location = location;
    }

    /**
     * Gets time.
     *
     * @return time time
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param newTime the new time
     */
    public void setTime(Time newTime) {
        time = newTime;
    }

    /**
     * Gets location.
     *
     * @return location location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return String representation of Duty object
     */
    public String toString() {
        return time + " " + location;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public abstract Date getDate();
}
