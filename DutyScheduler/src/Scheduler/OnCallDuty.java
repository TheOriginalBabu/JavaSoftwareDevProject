package Scheduler;

import java.util.Date;

/**
 * The type OnCallDuty. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: OnCallDuty
 */
public class OnCallDuty extends Duty{

    private Date date;

    /**
     * Instantiates a new Duty.
     *
     * @param name     the name
     * @param time     the time
     * @param location the location
     * @param teacher  the teacher
     * @param date     the date
     */
    public OnCallDuty(String name, Time time, Location location, Teacher teacher, Date date) {
        super(name, time, location, teacher);
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

    public boolean isTeacherAvailable(Teacher teacher, boolean ignoreRecentDuties) {
        return teacher.isAvailable(this, ignoreRecentDuties);
    }
}
