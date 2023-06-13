package Scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class GeneratorController {
    private SupervisionGenerator supervisionGenerator;
    private OnCallGenerator onCallGenerator;
    private ArrayList<SupervisionDuty> supervisionDuties;
    private ArrayList<OnCallDuty> onCallDuties;
    private ArrayList<Teacher> teachers;
    private ArrayList<Time> times;
    private HashMap<Time, ArrayList<Teacher>> assignedTeachers = new HashMap<>();

    public GeneratorController(ArrayList<Time> times, ArrayList<SupervisionDuty> supervisionDuties, ArrayList<Teacher> teachers, ArrayList<OnCallDuty> onCallDuties) { // Call this constructor from Controller class
        this.supervisionDuties = supervisionDuties;
        this.onCallDuties = onCallDuties;
        this.teachers = teachers;
        this.times = times;

        // Create a hashmap of times and a blank arraylist of teachers
        for (Time time: times) { // TODO: Times is not defined
            assignedTeachers.put(time, new ArrayList<>());
        }

        // Initialize a supervision generator
        SupervisionGenerator supervisionGenerator = new SupervisionGenerator(supervisionDuties, teachers, Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));

        // Initialize an on call generator
        OnCallGenerator onCallGenerator = new OnCallGenerator(onCallDuties, teachers);
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
        onCallGenerator.generate(assignedTeachers);
        HashMap<OnCallDuty, Teacher> assignedOnCallDuties = onCallGenerator.getAssignedDuties();
        for (OnCallDuty name: assignedOnCallDuties.keySet()) {
            assignedTeachers.get(name.getTime()).add(assignedOnCallDuties.get(name)); //Add assigned teacher to the hashmap
        }
    }
}
