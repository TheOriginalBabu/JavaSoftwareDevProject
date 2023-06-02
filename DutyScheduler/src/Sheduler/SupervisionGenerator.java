package Sheduler;

/**
 * The type supervisionGenerator. /TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -06-02
 * @File: SupervisionGenerator
 */
public class SupervisionGenerator extends Generator {
    /**
     * Instantiates a new Generator.
     *
     * @param scheduleParameters the schedule parameters
     * @param duties             the duties
     * @param teachers           the teachers
     */
    public SupervisionGenerator(ScheduleParameters[] scheduleParameters, Duty[] duties, Teacher[] teachers) {
        super(scheduleParameters, duties, teachers);
    }
}
