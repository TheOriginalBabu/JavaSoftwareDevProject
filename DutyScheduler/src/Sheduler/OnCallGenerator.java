package Sheduler;

/**
 * The type OnCallGenerator. /TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -06-02
 * @File: OnCallGenerator
 */
public class OnCallGenerator extends Generator {

    private final OnCall[] duties;
    private final Teacher[] teachers;


    /**
     * Instantiates a new On call generator.
     *
     * @param duties   the duties
     * @param teachers the teachers
     */
    public OnCallGenerator(OnCall[] duties, Teacher[] teachers) {
        this.duties = duties;
        this.teachers = teachers;
    }

    /**
     * Generate.
     */
    public void generate() {
        for (OnCall duty : duties) {
            findBestTeacher(duty);
        }
    }

    /**
     * Finds teacher with most minutes available and that hasn't been assigned to the duty recently.
     * Priority is given to teachers with more minutes available.
     * If two teachers have the same number of minutes available, the teacher that hasn't been assigned to the duty recently is chosen.
     * Checks to make sure the teacher doesn't have another duty/class at the same time or a restriction at the same time on any day of the week.
     *
     * @param duty the duty to find a teacher for
     * @return teacher with most minutes available and that hasn't been assigned to the duty recently
     */
    public Teacher findBestTeacher(OnCall duty) {
        Teacher bestTeacher = null;
        double bestMinutesAvailable = 0.0;
        for (Teacher teacher : teachers) {
            if (teacher.isAvailable(duty)) {
                double minutesAvailable = teacher.getMinutesRemaining();
                if (minutesAvailable > bestMinutesAvailable) {
                    bestTeacher = teacher;
                    bestMinutesAvailable = minutesAvailable;
                }
            }
        }
        // todo: Add error handling (if bestTeacher is null)
        return bestTeacher;
    }
}
