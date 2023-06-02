package Sheduler;

import java.util.Date;

/**
 * The type Generator. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Generator
 */
public abstract class Generator {//todo: Error Trapping/Handling
    private ScheduleParameters[] scheduleParameters;
    private Duty[] duties;
    private Teacher[] teachers;

    /**
     * Instantiates a new Generator.
     *
     * @param scheduleParameters the schedule parameters
     * @param duties             the duties
     * @param teachers           the teachers
     */
    public Generator(ScheduleParameters[] scheduleParameters, Duty[] duties, Teacher[] teachers) {
        this.scheduleParameters = scheduleParameters;
        this.duties = duties;
        this.teachers = teachers;
    }

    /**
     * Finds teacher with most minutes available and that hasn't been assigned to the duty recently.
     * Priority is given to teachers with more minutes available.
     *
     * @param duty the duty to find a teacher for
     * @param date the date
     * @return teacher with most minutes available and that hasn't been assigned to the duty recently
     */
    public Teacher findTeacher(Duty duty, Date date) {
        Teacher[] teachers = getTeachers();
        Teacher bestTeacher = null;
        double bestMinutesAvailable = 0.0;
        for (Teacher teacher : teachers) {
            if (teacher.isAvailable(duty, date)) {
                double minutesAvailable = teacher.getMinutesRemaining();
                if (minutesAvailable > bestMinutesAvailable) {
                    bestTeacher = teacher;
                    bestMinutesAvailable = minutesAvailable;
                }
            }
        }
        // TODO: Add error handling (if bestTeacher is null)
        return bestTeacher;
    }


    /**
     * Get schedule parameters schedule parameters [ ].
     *
     * @return the schedule parameters [ ]
     */
    public ScheduleParameters[] getScheduleParameters() {
        return scheduleParameters;
    }


    /**
     * Sets schedule parameters.
     *
     * @param scheduleParameters the schedule parameters
     */
    public void setScheduleParameters(ScheduleParameters[] scheduleParameters) {
        this.scheduleParameters = scheduleParameters;
    }

    /**
     * Gets duties.
     *
     * @return the duties
     */
    public Duty[] getDuties() {
        return duties;
    }

    /**
     * Sets duties.
     *
     * @param duties the duties
     */
    public void setDuties(Duty[] duties) {
        this.duties = duties;
    }

    /**
     * Gets teachers.
     *
     * @return the teachers
     */
    public Teacher[] getTeachers() {
        return teachers;
    }

    /**
     * Sets teachers.
     *
     * @param teachers the teachers
     */
    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }
}
