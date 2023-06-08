package Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type OnCallGenerator. /TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -06-02
 * @File: OnCallGenerator
 */
public class OnCallGenerator extends Generator {

    private final ArrayList<OnCallDuty> duties;
    private final ArrayList<Teacher> teachers;
    private ArrayList<OnCallDuty> assignedDuties = new ArrayList<>();
    private ArrayList<Teacher> assignedTeachers = new ArrayList<>();
    private HashMap<OnCallDuty, Teacher> teacherDuties = new HashMap<>();


    /**
     * Instantiates a new On call generator.
     *
     * @param duties   the duties
     * @param teachers the teachers
     */
    public OnCallGenerator(ArrayList<OnCallDuty> duties, ArrayList<Teacher> teachers) {
        this.duties = duties;
        this.teachers = teachers;
    }

    /**
     * Generate.
     */
    public void generate() {
        for (OnCallDuty duty : duties) {
            findBestTeacher(duty, assignedTeachers);
            Teacher bestTeacher = findBestTeacher(duty, assignedTeachers);
            teacherDuties.put(duty, bestTeacher);
            assignedDuties.add(duty);
            assignedTeachers.add(bestTeacher);
        }
    }
}
