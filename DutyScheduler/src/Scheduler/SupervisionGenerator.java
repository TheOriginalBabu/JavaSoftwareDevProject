package Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type supervisionGenerator. /TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -06-02
 * @File: SupervisionGenerator
 */
public class SupervisionGenerator extends Generator {

    private ArrayList<SupervisionDuty> duties;
    private ArrayList<Teacher> teachers;
    private ArrayList<SupervisionDuty> assignedDuties = new ArrayList<>();
    private ArrayList<Teacher> assignedTeachers = new ArrayList<>();
    private final int week;
    private HashMap<SupervisionDuty, Teacher> teacherDuties = new HashMap<>();

    /**
     * Instantiates a new Generator.
     *
     * @param duties   the duties
     * @param teachers the teachers
     * @param week     the week
     */
    public SupervisionGenerator(ArrayList<SupervisionDuty> duties, ArrayList<Teacher> teachers, int week) {
        this.duties = duties;
        this.teachers = teachers;
        this.week = week;
        generate();
    }

    /**
     * Generate.
     */
    public void generate() {
        for (SupervisionDuty duty : duties) {
            Teacher bestTeacher = findBestTeacher(duty);
            teacherDuties.put(duty, bestTeacher);
            assignedDuties.add(duty);
            assignedTeachers.add(bestTeacher);
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
            if (teacher.isAvailable(duty) && !assignedTeachers.contains(teacher)) {
                double minutesAvailable = teacher.getMinutesRemaining();
                if (minutesAvailable > bestMinutesAvailable) {
                    bestTeacher = teacher;
                    bestMinutesAvailable = minutesAvailable;
                }
            }
        }
        if (bestTeacher != null) {
            return bestTeacher;
        } else {
            for (Teacher teacher : teachers) {
                if (teacher.isAvailable(duty)) {
                    double minutesAvailable = teacher.getMinutesRemaining();
                    if (minutesAvailable > bestMinutesAvailable) {
                        bestTeacher = teacher;
                        bestMinutesAvailable = minutesAvailable;
                    }
                }
            }
        }
        // todo: Add error handling (if bestTeacher is null) (if no teachers are available)
        return bestTeacher;
    }
}
