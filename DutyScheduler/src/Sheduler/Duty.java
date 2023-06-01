package Sheduler;

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
    private Teacher teacher;

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     * @param teacher the teacher
     */
    public Duty(Time time, Location location, Teacher teacher) {
        this.time = time;
        this.location = location;
        this.teacher = teacher;
    }

    /**
     * Gets time.
     *
     * @return time
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
     * Getter for teacher field.
     *
     * @return The Teacher object for this duty.
     */
    public Teacher getTeacher() {
        return this.teacher;
    }

    /**
     * Setter for teacher field.
     *
     * @param teacher The new Teacher object for this duty.
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return String representation of Duty object
     */
    @Override
    public String toString() {
        return time + " " + location + " " + teacher;
    }
}
