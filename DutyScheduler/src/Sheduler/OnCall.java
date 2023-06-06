package Sheduler;

import java.util.Date;

/**
 * The type OnCall. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: OnCall
 */
public class OnCall extends Duty{

    private Date date;

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     * @param date     the date
     */
    public OnCall(Time time, Location location, Teacher teacher,Date date) {
        super(time, location, teacher);
        this.date = date;
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
     * @param newDate the new date
     */
    public void setDate(Date newDate) {
        date = newDate;
    }
}
