package Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneratorController {
    private SupervisionGenerator supervisionGenerator;
    private OnCallGenerator onCallGenerator;
    private HashMap<Time, ArrayList<Teacher>> assignedTeachers = new HashMap<>();

    public GeneratorController(ArrayList<Time> times, ArrayList<SupervisionDuty> supervisionDuties, ArrayList<Teacher> teachers) { // Call this constructor from Controller class
        // Create a hashmap of times and a blank arraylist of teachers
        for (Time time: times) { // TODO: Times is not defined
            assignedTeachers.put(time, new ArrayList<>());
        }

        //todo: Initialize generators
    }

    public void generate() {
        // Generate supervision schedule and assign it to a hashmap
        supervisionGenerator.generate();
        HashMap<SupervisionDuty, Teacher> assignedSupervisionDuties = supervisionGenerator.getAssignedDuties();

        // Determine which teachers are assigned to which times
        for (SupervisionDuty name: assignedSupervisionDuties.keySet()) {
            assignedTeachers.get(name.getTime()).add(assignedSupervisionDuties.get(name));
        }

        // Generate on call schedule and assign it to a hashmap
        onCallGenerator.generate();
        HashMap<OnCallDuty, Teacher> assignedOnCallDuties = onCallGenerator.getAssignedDuties();
        for (OnCallDuty name: assignedOnCallDuties.keySet()) {
            assignedTeachers.get(name.getTime()).add(assignedOnCallDuties.get(name));
        }
    }
}
