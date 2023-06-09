package Scheduler;

/**
 * The type Duty. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Duty
 */
public abstract class Duty {//todo: Error Trapping/Handling
    private String name;
    private Time time;
    private Location location;
    private Teacher teacher;

    /**
     * Instantiates a new Duty.
     *
     * @param name     the name
     * @param time     the time
     * @param location the location
     * @param teacher  the teacher
     */
    public Duty(String name, Time time, Location location, Teacher teacher) {
        this.name = name;
        this.time = time;
        this.location = location;
        this.teacher = teacher;
    }

    /**
     * Instantiates a new Duty.
     *
     * @param name     the name
     * @param time     the time
     * @param location the location
     */
    public Duty(String name, Time time, Location location) {
        this.name = name;
        this.time = time;
        this.location = location;
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
     * Gets teacher.
     *
     * @return teacher teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Sets teacher.
     *
     * @param teacher the teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Is teacher available boolean.
     *
     * @param teacher            the teacher
     * @param ignoreRecentDuties the ignore recent duties
     * @return the boolean
     */
    public abstract boolean isTeacherAvailable(Teacher teacher, boolean ignoreRecentDuties);

    /**
     *
     * @return String representation of Duty object
     */
    public String toString() {
        return name;
    }
}
