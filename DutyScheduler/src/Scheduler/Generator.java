package Scheduler;

import java.util.ArrayList;

/**
 * The type Generator. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Generator
 */
public abstract class Generator {//todo: Error Trapping/Handling

    private ArrayList<Duty> duties;
    private ArrayList<Teacher> teachers;

    public <T extends Duty> Teacher findBestTeacher(T duty, ArrayList<Teacher> assignedTeachers) throws Exception {
        Teacher bestTeacher = null;
        double bestMinutesAvailable = 0d;
        for (Teacher teacher : teachers) {
            if (teacher.isAvailable(duty) && !assignedTeachers.contains(teacher)){
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
                if (teacher.isAvailable(duty, true)) {
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
