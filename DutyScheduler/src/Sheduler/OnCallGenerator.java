package Sheduler;

/**
 * The type OnCallGenerator. /TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -06-02
 * @File: OnCallGenerator
 */
public class OnCallGenerator extends Generator {

    /**
     * Instantiates a new On call generator.
     *
     * @param scheduleParameters the schedule parameters
     * @param duties             the duties
     * @param teachers           the teachers
     */
    public OnCallGenerator(ScheduleParameters[] scheduleParameters, Duty[] duties, Teacher[] teachers) {
        super(scheduleParameters, duties, teachers);
    }
}
