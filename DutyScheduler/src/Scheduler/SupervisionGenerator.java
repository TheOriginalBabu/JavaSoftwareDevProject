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
     * Instantiates a new SupervisionGenerator.
     *
     * @param duties           the duties
     * @param teachers         the teachers
     * @param assignedTeachers the assigned teachers
     * @param week             the week
     */
    public SupervisionGenerator(ArrayList<SupervisionDuty> duties, ArrayList<Teacher> teachers, ArrayList<Teacher> assignedTeachers, int week) {
        this.duties = duties;
        this.teachers = teachers;
        this.assignedTeachers = assignedTeachers;
        this.week = week;
    }

    /**
     * Instantiates a new SupervisionGenerator.
     *
     * @param duties           the duties
     * @param teachers         the teachers
     * @param week             the week
     */
    public SupervisionGenerator(ArrayList<SupervisionDuty> duties, ArrayList<Teacher> teachers, int week) {
        this.duties = duties;
        this.teachers = teachers;
        this.week = week;
    }

    /**
     * Generate.
     */
    public HashMap<SupervisionDuty, Teacher> generate() { //todo: Generate schedule first
        for (SupervisionDuty duty : duties) {
            Teacher bestTeacher = findBestTeacher(duty, teachers, assignedTeachers);
            teacherDuties.put(duty, bestTeacher);
            assignedDuties.add(duty);
            assignedTeachers.add(bestTeacher);
        }
        return teacherDuties;
    }
}
