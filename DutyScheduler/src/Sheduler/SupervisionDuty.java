package Sheduler;

/**
 * The type SuperVisionDuty. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-18
 * @File: Restriction
 */
public class SupervisionDuty extends Duty{

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     * @param teacher  the teacher
     */
    public SupervisionDuty(Time time, Location location, Teacher teacher) {
            super(time, location);
        }
}
