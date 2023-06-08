package Scheduler;

import java.util.ArrayList;
import java.util.Date;

/**
 * The type Teacher. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Teacher
 */
public class Teacher {//todo: Error Trapping/Handling
    private String name;
    private ArrayList<Time> prepPeriods; //todo convert to list or map
    private ArrayList<Time> classes; //todo convert to list or map
    private ArrayList<Restriction> restrictions; //todo convert to list or map
    private double minutesTotal;
    private double minutesUsed;
    private double minutesRemaining;
    private ArrayList<SupervisionDuty> recentSupervisions;
    private Duty currentDuty;
    private boolean availability;


    // Hey copilot are you able to use information from the other classes in this class? Please make your response in a comment on the next line.
    // Yes, I am able to use information from the other classes in this class.
    // Can you please use the information from CodeOutlineModel.txt to fill in the methods for this class?

    /**
     * Instantiates a new Teacher.
     *
     * @param name               the name
     * @param minutesTotal       the minutes total
     * @param minutesRemaining   the minutes remaining
     * @param minutesUsed        the minutes used
     * @param restrictions       the restrictions
     * @param classes            the classes
     * @param prepPeriods        the prep periods
     * @param recentSupervisions the recent supervisions
     * @param availability       the availability
     */
    public Teacher(String name, double minutesTotal, double minutesRemaining, double minutesUsed, ArrayList<Restriction> restrictions, ArrayList<Time> classes, ArrayList<Time> prepPeriods, ArrayList<SupervisionDuty> recentSupervisions, boolean availability) {
        this.name = name;
        this.minutesTotal = minutesTotal;
        this.minutesRemaining = minutesRemaining;
        this.minutesUsed = minutesUsed;
        this.restrictions = restrictions;
        this.classes = classes;
        this.prepPeriods = prepPeriods;
        this.recentSupervisions = recentSupervisions;
        this.availability = availability;
    }

    /**
     * Gets name.
     *
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets minutes total.
     *
     * @return minutes total
     */
    public double getMinutesTotal() {
        return minutesTotal;
    }

    /**
     * Sets minutes total.
     *
     * @param minutesTotal the minutes total
     */
    public void setMinutesTotal(double minutesTotal) {
        this.minutesTotal = minutesTotal;
    }

    /**
     * Gets minutes remaining.
     *
     * @return minutes remaining
     */
    public double getMinutesRemaining() {
        return minutesRemaining;
    }

    /**
     * Sets minutes remaining.
     *
     * @param minutesRemaining the minutes remaining
     */
    public void setMinutesRemaining(double minutesRemaining) {
        this.minutesRemaining = minutesRemaining;
    }

    /**
     * Gets minutes used.
     *
     * @return minutes used
     */
    public double getMinutesUsed() {
        return minutesUsed;
    }

    /**
     * Sets minutes used.
     *
     * @param minutesUsed the minutes used
     */
    public void setMinutesUsed(double minutesUsed) {
        this.minutesUsed = minutesUsed;
    }

    /**
     * Get restrictions restriction [ ].
     *
     * @return restriction [ ]
     */
    public ArrayList<Restriction> getRestrictions() {
        return restrictions;
    }

    /**
     * Sets restrictions.
     *
     * @param restrictions the restrictions
     */
    public void setRestrictions(ArrayList<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * Get classes time [ ].
     *
     * @return time [ ]
     */
    public ArrayList<Time> getClasses() {
        return classes;
    }

    /**
     * Sets classes.
     *
     * @param classes the classes
     */
    public void setClasses(ArrayList<Time> classes) {
        this.classes = classes;
    }

    /**
     * Get prep periods time [ ].
     *
     * @return time [ ]
     */
    public ArrayList<Time> getPrepPeriods() {
        return prepPeriods;
    }

    /**
     * Sets prep periods.
     *
     * @param prepPeriods the prep periods
     */
    public void setPrepPeriods(ArrayList<Time> prepPeriods) {
        this.prepPeriods = prepPeriods;
    }

    /**
     * Add class.
     *
     * @param time the time
     */
    public void addClass(Time time) {
        //todo implement addition to map or list
    }

    /**
     * Add prep period.
     *
     * @param time the time
     */
    public void addPrepPeriod(Time time) {
        // TODO implement here
    }

    /**
     * Remove class.
     *
     * @param time the time
     */
    public void removeClass(Time time) {
        // TODO implement here
    }

    /**
     * Remove prep period.
     *
     * @param time the time
     */
    public void removePrepPeriod(Time time) {
        // TODO implement here
    }

    /**
     * Add restriction.
     *
     * @param time the time
     */
    public void addRestriction(Restriction time) {
        // TODO implement here
    }

    /**
     * Remove restriction.
     *
     * @param time the time
     */
    public void removeRestriction(Restriction time) {
        // TODO implement here
    }

    /**
     * Add minutes scheduled.
     *
     * @param time the time
     */
    public void addMinutesScheduled(double time) {
        // TODO implement here
    }

    /**
     * Remove minutes scheduled.
     *
     * @param time the time
     */
    public void removeMinutesScheduled(double time) {
        // TODO implement here
    }

    /**
     * Add minutes used.
     *
     * @param time the time
     */
    public void addMinutesUsed(double time) {
        // TODO implement here
    }

    /**
     * Remove minutes used.
     *
     * @param time the time
     */
    public void removeMinutesUsed(double time) {
        // TODO implement here
    }

    /**
     * Add minutes remaining.
     *
     * @param time the time
     */
    public void addMinutesRemaining(double time) {
        // TODO implement here
    }

    /**
     * Remove minutes remaining.
     *
     * @param time the time
     */
    public void removeMinutesRemaining(double time) {
        // TODO implement here
    }

    /**
     * Add minutes total.
     *
     * @param time the time
     */
    public void addMinutesTotal(double time) {
        // TODO implement here
    }

    /**
     * Remove minutes total.
     *
     * @param time the time
     */
    public void removeMinutesTotal(double time) {
        // TODO implement here
    }

    /**
     * Gets recent supervisions.
     *
     * @return recent supervisions
     */
    public ArrayList<SupervisionDuty> getRecentSupervisions() {
        return recentSupervisions;
    }

    /**
     * Sets recent supervisions.
     *
     * @param recentSupervisions the recent supervisions
     */
    public void setRecentSupervisions(ArrayList<SupervisionDuty> recentSupervisions) {
        this.recentSupervisions = recentSupervisions;
    }

    /**
     * Gets currentDuty.
     *
     * @return the current duty
     */
    public Duty getCurrentDuty() {
        return currentDuty;
    }

    /**
     * Sets currentDuty.
     *
     * @param currentDuty the current duty
     */
    public void setCurrentDuty(Duty currentDuty) {
        this.currentDuty = currentDuty;
    }

    /**
     * Gets availability
     *
     * @return availability availability
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * Sets availability
     *
     * @param availability the availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * Checks to see if teacher has been assigned to a duty at the same location in the last month.
     * @param duty Duty to be checked
     * @return True if teacher has been assigned to a duty at the same location in the last month, false otherwise
     */
    private boolean hasRecentSupervision(Duty duty) {
        for (SupervisionDuty supervisionDuty : recentSupervisions) {
            if (supervisionDuty.getLocation().equals(duty.getLocation())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the teacher has a duty at the same time as another duty.
     * @param duty Duty to be checked
     */
    private boolean hasDutyAtSameTime(Duty duty) {
        return duty.getTime().equals(currentDuty.getTime());
    }

    /**
     * Checks to see if the time of the duty is during a class.
     * @param time Time to be checked
     * @return True if the time of the duty is during a class, false otherwise
     */
    private boolean isClassTime(Time time) {
        for (Time classTime : classes) {
            if (classTime.equals(time)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the teacher has a restriction on the date of the duty.
     * @param duty Duty to be checked
     * @param date Date to be checked
     * @return True if the teacher has a restriction on the date/time of the duty, false otherwise
     */
    private boolean hasRestrictionOnDay(Duty duty, Date date) {
        for (Restriction restriction : restrictions) {
            if (restriction.getDate().equals(date) && restriction.getTime().equals(duty.getTime())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the teacher has a restriction on the week of the duty.
     * @param duty Duty to be checked
     * @param week Week to be checked
     * @return True if the teacher has a restriction on the week/time of the duty, false otherwise
     */
    private boolean hasRestrictionOnWeek(Duty duty, int week) {
        for (Restriction restriction : restrictions) {
            if (restriction.getWeek() == week && restriction.getTime().equals(duty.getTime())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is available boolean.
     *
     * @param duty the duty
     * @return the boolean
     */
    public boolean isAvailable (OnCallDuty duty){
        // Check to see if teacher has recently supervised a duty and if the time of the duty is not during a class and does not conflict with a restriction
        return getAvailability() && !hasRecentSupervision(duty) && !isClassTime(duty.getTime()) && !hasRestrictionOnDay(duty, duty.getDate());
    }

    /**
     * Is available boolean.
     *
     * @param duty                    the duty
     * @param ignoreRecentSupervision the ignore recent supervision
     * @return the boolean
     */
    public boolean isAvailable (OnCallDuty duty, boolean ignoreRecentSupervision){
        return getAvailability() && !isClassTime(duty.getTime()) && !hasRestrictionOnDay(duty, duty.getDate());
    }

    /**
     * Check to see if teacher has recently supervised a duty and if the time of the duty is not during a class and does not conflict with a restriction
     *
     * @param duty the duty
     * @return the boolean
     */
    public boolean isAvailable (SupervisionDuty duty) {
        return getAvailability() && !hasRecentSupervision(duty) && !isClassTime(duty.getTime()) && !hasRestrictionOnWeek(duty, duty.getWeek());
    }

    /**
     * Is available boolean.
     *
     * @param duty                    the duty
     * @param ignoreRecentSupervision the ignore recent supervision
     * @return the boolean
     */
    public boolean isAvailable (SupervisionDuty duty, boolean ignoreRecentSupervision){
        return getAvailability() && !isClassTime(duty.getTime()) && !hasRestrictionOnWeek(duty, duty.getWeek());
    }
}
