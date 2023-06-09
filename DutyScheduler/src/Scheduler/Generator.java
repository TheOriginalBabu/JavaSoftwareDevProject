package Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Generator. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Generator
 */
public abstract class Generator {//todo: Error Trapping/Handling

    private ArrayList<Duty> duties = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    /**
     * Instantiates a new Generator.
     */
    protected Generator() {
    }

    /**
     * Finds teacher with most minutes available and that hasn't been assigned to the duty recently.
     * Priority is given to teachers with more minutes available.
     * If two teachers have the same number of minutes available, the teacher that hasn't been assigned to the duty recently is chosen.
     * Checks to make sure the teacher doesn't have another duty/class at the same time or a restriction at the same time on any day of the week.
     *
     * @param duty             the duty to find a teacher for
     * @param assignedTeachers the assigned teachers
     * @return the best teacher for the duty
     */
    public Teacher findBestTeacher(Duty duty, ArrayList<Teacher> teachers, HashMap<Time, ArrayList<Teacher>> assignedTeachers) {
        Teacher bestTeacher = null;
        double bestMinutesAvailable = 0d;
        for (Teacher teacher : teachers) {
            if (duty.isTeacherAvailable(teacher, false) && !assignedTeachers.get(duty.getTime()).contains(teacher)) {
                double minutesAvailable = teacher.getMinutesRemaining();
                if (minutesAvailable > bestMinutesAvailable) {
                    bestTeacher = teacher;
                    bestMinutesAvailable = minutesAvailable;
                }
            }
        }
        if (bestTeacher == null) {
            findBestTeacher(duty, teachers);
        }
        if (bestTeacher == null) {
            System.out.println("No teacher available for duty: " + duty.getName());
        } else {
            System.out.println("Teacher " + bestTeacher.getName() + " assigned to duty: " + duty.getName());
        }
        // todo: Add error handling (if bestTeacher is null) (if no teachers are available) (Teacher already assigned to Oncall/Supervision)
        return bestTeacher;
    }

        /**
         * Finds teacher with most minutes available and that hasn't been assigned to the duty recently.
         * Priority is given to teachers with more minutes available.
         * If two teachers have the same number of minutes available, the teacher that hasn't been assigned to the duty recently is chosen.
         * Checks to make sure the teacher doesn't have another duty/class at the same time or a restriction at the same time on any day of the week.
         *
         * @param duty             the duty to find a teacher for
         * @return the best teacher for the duty
         */
        public Teacher findBestTeacher(Duty duty, ArrayList<Teacher> teachers) {
        Teacher bestTeacher = null;
        double bestMinutesAvailable = 0d;
        for (Teacher teacher : teachers) {
            if (duty.isTeacherAvailable(teacher, true)) {
                double minutesAvailable = teacher.getMinutesRemaining();
                if (minutesAvailable > bestMinutesAvailable) {
                    bestTeacher = teacher;
                    bestMinutesAvailable = minutesAvailable;
                }
            }
        }
        if (bestTeacher == null) {
            System.out.println("No teacher available for duty: " + duty.getName());
        } else {
            System.out.println("Teacher " + bestTeacher.getName() + " assigned to duty: " + duty.getName());
        }
        // todo: Add error handling (if no teachers are available) (Teacher has too many duties)
        return bestTeacher;
    }
}
