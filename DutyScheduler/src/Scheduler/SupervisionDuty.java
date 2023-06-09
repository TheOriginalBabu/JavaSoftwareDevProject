package Scheduler;

/**
 * The type SuperVisionDuty. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-18
 * @File: Restriction
 */
public class SupervisionDuty extends Duty{

    private int week;

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     * @param teacher  the teacher
     * @param week     the week
     */
    public SupervisionDuty(String name, Time time, Location location, Teacher teacher, int week) {
            super(name, time, location, teacher);
    }

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     * @param week     the week
     */
    public SupervisionDuty(String name, Time time, Location location, int week) {
        super(name, time, location);
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
     * @param newWeek the new week
     */
    public void setWeek(int newWeek) {
        week = newWeek;
    }

    public boolean isTeacherAvailable(Teacher teacher, boolean ignoreRecentDuties) {
        return teacher.isAvailable(this, ignoreRecentDuties);
    }
}
