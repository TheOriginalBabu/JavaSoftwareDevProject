package Sheduler;

/**
 * @author: Griffin Robinson
 * @date: 2023-06-01
 * @File Name: OnCall
 * @description: _______
 */
public class OnCall extends Duty{

    /**
     * Instantiates a new Duty.
     *
     * @param time     the time
     * @param location the location
     * @param teacher the teacher
     */
    public OnCall(Time time, Location location, Teacher teacher) {
        super(time, location, teacher);
    }
}
