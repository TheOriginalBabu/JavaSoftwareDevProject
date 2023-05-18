package Sheduler;

/**
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023-05-17
 * @File Name: Teacher
 * @description: _______
 */
public class Teacher {
    private String name;
    private double minutesTotal;
    private double minutesScheduled;
    private double minutesRemaining;
    private double minutesUsed;
    private Restrictions[] restrictions;
    private Time[] classes;
    private Time[] prepPeriods;

    // Hey copilot are you able to use information from the other classes in this class? Please make your response in a comment on the next line.
    // Yes, I am able to use information from the other classes in this class.
    // Can you please use the information from CodeOutlineModel.txt to fill in the methods for this class?

    /**
     * @param name
     * @param minutesTotal
     * @param minutesScheduled
     * @param minutesRemaining
     * @param minutesUsed
     * @param restrictions
     * @param classes
     * @param prepPeriods
     */
    public Teacher(String name, double minutesTotal, double minutesScheduled, double minutesRemaining, double minutesUsed, Restrictions[] restrictions, Time[] classes, Time[] prepPeriods) {
        this.name = name;
        this.minutesTotal = minutesTotal;
        this.minutesScheduled = minutesScheduled;
        this.minutesRemaining = minutesRemaining;
        this.minutesUsed = minutesUsed;
        this.restrictions = restrictions;
        this.classes = classes;
        this.prepPeriods = prepPeriods;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public double getMinutesTotal() {
        return minutesTotal;
    }

    /**
     * @param minutesTotal
     */
    public void setMinutesTotal(double minutesTotal) {
        this.minutesTotal = minutesTotal;
    }

    /**
     * @return
     */
    public double getMinutesScheduled() {
        return minutesScheduled;
    }

    /**
     * @param minutesScheduled
     */
    public void setMinutesScheduled(double minutesScheduled) {
        this.minutesScheduled = minutesScheduled;
    }

    /**
     * @return
     */
    public double getMinutesRemaining() {
        return minutesRemaining;
    }

    /**
     * @param minutesRemaining
     */
    public void setMinutesRemaining(double minutesRemaining) {
        this.minutesRemaining = minutesRemaining;
    }

    /**
     * @return
     */
    public double getMinutesUsed() {
        return minutesUsed;
    }

    /**
     * @param minutesUsed
     */
    public void setMinutesUsed(double minutesUsed) {
        this.minutesUsed = minutesUsed;
    }

    /**
     * @return
     */
    public Restrictions[] getRestrictions() {
        return restrictions;
    }

    /**
     * @param restrictions
     */
    public void setRestrictions(Restrictions[] restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * @return
     */
    public Time[] getClasses() {
        return classes;
    }

    /**
     * @param classes
     */
    public void setClasses(Time[] classes) {
        this.classes = classes;
    }

    /**
     * @return
     */
    public Time[] getPrepPeriods() {
        return prepPeriods;
    }

    /**
     * @param prepPeriods
     */
    public void setPrepPeriods(Time[] prepPeriods) {
        this.prepPeriods = prepPeriods;
    }

    /**
     * @param time
     */
    public void addClass(Time time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void addPrepPeriod(Time time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removeClass(Time time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removePrepPeriod(Time time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void addRestriction(Restrictions time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removeRestriction(Restrictions time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void addMinutesScheduled(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removeMinutesScheduled(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void addMinutesUsed(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removeMinutesUsed(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void addMinutesRemaining(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removeMinutesRemaining(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void addMinutesTotal(double time) {
        // TODO implement here
    }

    /**
     * @param time
     */
    public void removeMinutesTotal(double time) {
        // TODO implement here
    }
}
