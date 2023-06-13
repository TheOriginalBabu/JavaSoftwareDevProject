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
    private HashMap<Time, ArrayList<Teacher>> assignedTeachers = new HashMap<>();
    private HashMap<OnCallDuty, Teacher> teacherDuties = new HashMap<>();


    /**
     * Instantiates a new OnCallGenerator.
     *
     * @param duties           the duties
     * @param teachers         the teachers
     * @param assignedTeachers the assigned teachers
     */
    public OnCallGenerator(ArrayList<OnCallDuty> duties, ArrayList<Teacher> teachers, HashMap<Time, ArrayList<Teacher>> assignedTeachers) {
        this.duties = duties;
        this.teachers = teachers;
        this.assignedTeachers = assignedTeachers;
    }

    /**
     * Generate.
     */
    public void generate() {
        for (OnCallDuty duty : duties) {
            Teacher bestTeacher = findBestTeacher(duty, teachers, assignedTeachers);
            teacherDuties.put(duty, bestTeacher);
            assignedDuties.add(duty);
            if (!assignedTeachers.containsKey(duty.getTime())) {
                assignedTeachers.put(duty.getTime(), new ArrayList<>());
            } else {
                assignedTeachers.get(duty.getTime()).add(bestTeacher);
            }
            bestTeacher.changeAvailability(duty.getTime(), false);
        }
    }

    /**
     * Get assigned hashMap
     *
     * @return teacherDuties
     */
    public HashMap<OnCallDuty, Teacher> getAssignedDuties() {
        return teacherDuties;
    }
}
