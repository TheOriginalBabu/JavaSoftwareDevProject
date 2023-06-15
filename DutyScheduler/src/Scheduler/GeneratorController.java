package Scheduler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * The type Generator controller.
 */
public class GeneratorController {
    private SupervisionGenerator supervisionGenerator;
    private OnCallGenerator onCallGenerator;
    private ArrayList<SupervisionDuty> supervisionDuties;
    private ArrayList<OnCallDuty> onCallDuties;
    private ArrayList<Teacher> teachers;
    private ArrayList<Time> times;
    private ArrayList<Location> locations;
    private HashMap<Time, ArrayList<Teacher>> assignedTeachers = new HashMap<>();
    private ArrayList<String> teachersStringList = new ArrayList<>();
    private ArrayList<String> timesStringList = new ArrayList<>();
    private ArrayList<String> locationsStringList = new ArrayList<>();


    /**
     * Instantiates a new Generator controller.
     *
     * @param times             the times
     * @param supervisionDuties the supervision duties
     * @param teachers          the teachers
     * @param onCallDuties      the on call duties
     * @param locations         the locations
     */
    public GeneratorController(ArrayList<Time> times, ArrayList<SupervisionDuty> supervisionDuties, ArrayList<Teacher> teachers, ArrayList<OnCallDuty> onCallDuties, ArrayList<Location> locations) { // Call this constructor from Controller class
        this.supervisionDuties = supervisionDuties;
        this.onCallDuties = onCallDuties;
        this.teachers = teachers;
        this.times = times;
        this.locations = locations;

        // Create a hashmap of times and a blank arraylist of teachers
        for (Time time : times) { // TODO: Times is not defined
            assignedTeachers.put(time, new ArrayList<>());
        }

        // Initialize a supervision generator
        supervisionGenerator = new SupervisionGenerator(supervisionDuties, teachers, Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));

        // Initialize an on call generator
        onCallGenerator = new OnCallGenerator(onCallDuties, teachers);
    }

    /**
     * Generate.
     */
    public void generate() {
        // Generate supervision schedule and assign it to a hashmap
        supervisionGenerator.generate();
        HashMap<SupervisionDuty, Teacher> assignedSupervisionDuties = supervisionGenerator.getAssignedDuties();

        // Determine which teachers are assigned to which times
        for (SupervisionDuty name : assignedSupervisionDuties.keySet()) {
            assignedTeachers.get(name.getTime()).add(assignedSupervisionDuties.get(name));
        }

        // Generate on call schedule and assign it to a hashmap
        onCallGenerator.generate(assignedTeachers);
        HashMap<OnCallDuty, Teacher> assignedOnCallDuties = onCallGenerator.getAssignedDuties();
        for (OnCallDuty name : assignedOnCallDuties.keySet()) {
            assignedTeachers.get(name.getTime()).add(assignedOnCallDuties.get(name)); //Add assigned teacher to the hashmap
        }
    }

    /**
     * Gets assigned teachers.
     *
     * @return the assigned teachers
     */
    public HashMap<Time, ArrayList<Teacher>> getAssignedTeachers() {
        return assignedTeachers;
    }

    /**
     * Gets supervision duties.
     *
     * @return the supervision duties
     */
    public ArrayList<SupervisionDuty> getSupervisionDuties() {
        return supervisionDuties;
    }

    /**
     * Gets on call duties.
     *
     * @return the on call duties
     */
    public ArrayList<OnCallDuty> getOnCallDuties() {
        return onCallDuties;
    }

    /**
     * Gets teachers.
     *
     * @return the teachers
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Sets teachers string list.
     *
     * @param list the list
     */
    public void setTeachersStringList(ArrayList<String> list) {
        this.teachersStringList = list;
    }

    /**
     * Gets teachers string list.
     *
     * @return the teachers string list
     */
    public ArrayList<String> getTeachersStringList() {
        return teachersStringList;
    }

    /**
     * Gets times.
     *
     * @return the times
     */
    public ArrayList<Time> getTimes() {
        return times;
    }

    /**
     * Sets times string list.
     *
     * @param list the list
     */
    public void setTimesStringList(ArrayList<String> list) {
        this.timesStringList = list;
    }

    /**
     * Gets times string list.
     *
     * @return the times string list
     */
    public ArrayList<String> getTimesStringList() {
        return timesStringList;
    }

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Sets locations string list.
     *
     * @param list the list
     */
    public void setLocationsStringList(ArrayList<String> list) {
        this.locationsStringList = list;
    }

    /**
     * Gets locations string list.
     *
     * @return the locations string list
     */
    public ArrayList<String> getLocationsStringList() {
        return locationsStringList;
    }

    /**
     * Adds teachers info.
     *
     * @param teacherName the teacher name
     * @param classes     the periods
     */
    public void addTeacher(String teacherName, int minutesRequired, int minutesLeft, ArrayList<String> classes) {

        ArrayList<Time> classTimes = new ArrayList<>();
        for (String className : classes) {
            for (Time time : times) {
                if (time.getName().equals(className)) {
                    classTimes.add(time);
                }
            }
        }

        ArrayList<Time> prepTimes = new ArrayList<>();
        for (String className : classes) {
            for (Time time : times) {
                if (!time.getName().equals(className)) {
                    classTimes.add(time);
                }
            }
        }

        Teacher teacher = new Teacher(teacherName, minutesRequired, minutesLeft, classTimes, prepTimes);
    }


    public void addTime(String timeName, String startTime, String endTime) {//todo: finish this

    }


    public void addLocation(String locationName) {

    }
}
