package Scheduler;

/**
 * The type supervisionGenerator. /TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -06-02
 * @File: SupervisionGenerator
 */
public class SupervisionGenerator extends Generator {

    private final SupervisionDuty[] duties;
    private final Teacher[] teachers;
    private final int week;

    /**
     * Instantiates a new Generator.
     *
     * @param duties   the duties
     * @param teachers the teachers
     * @param week     the week
     */
    public SupervisionGenerator(SupervisionDuty[] duties, Teacher[] teachers, int week) {
        this.duties = duties;
        this.teachers = teachers;
        this.week = week;
    }

    /**
     * Generate.
     */
    public void generate() {
        for (SupervisionDuty duty : duties) {
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
    private Teacher findBestTeacher(SupervisionDuty duty) {
        Teacher bestTeacher = null;
        double bestMinutesAvailable = 0d;
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
