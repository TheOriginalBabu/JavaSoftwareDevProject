package Scheduler;

import java.util.ArrayList;

/**
 * The type Location. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-17
 * @File: Location
 */
public class Location {//todo: Error Trapping/Handling
    private String name;
    private String description;
    private ArrayList<Time> timesToWatch;
    private Restriction restriction;

    /**
     * Instantiates a new Location.
     *
     * @param name         the name
     * @param description  the description
     * @param timesToWatch the times to watch
     */
    public Location(String name, String description, ArrayList<Time> timesToWatch) {
        this.name = name;
        this.description = description;
        this.timesToWatch = timesToWatch;
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param newName the new name
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Gets description.
     *
     * @return description description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param newDescription the new description
     */
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    /**
     * Get times to watch time [ ].
     *
     * @return time [ ]
     */
    public ArrayList<Time> getTimesToWatch() {
        return timesToWatch;
    }

    /**
     * Sets times to watch.
     *
     * @param newTimesToWatch the new times to watch
     */
    public void setTimesToWatch(ArrayList<Time> newTimesToWatch) {
        timesToWatch = newTimesToWatch;
    }

    /**
     * Gets restriction.
     *
     * @return restriction restriction
     */
    public Restriction getRestriction() {
        return restriction;
    }

    /**
     * Sets restriction.
     *
     * @param newRestriction the new restriction
     */
    public void setRestriction(Restriction newRestriction) {
        restriction = newRestriction;
    }

    /**
     *
     * @return location as a string
     */
    @Override
    public String toString() {
        return name;
    }
}
