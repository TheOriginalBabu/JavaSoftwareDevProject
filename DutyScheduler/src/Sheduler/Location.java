package Sheduler;

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
    private Time[] timesToWatch;

    /**
     * Instantiates a new Location.
     *
     * @param name         the name
     * @param description  the description
     * @param timesToWatch the times to watch
     */
    public Location(String name, String description, Time[] timesToWatch) {
        this.name = name;
        this.description = description;
        this.timesToWatch = timesToWatch;
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
    public Time[] getTimesToWatch() {
        return timesToWatch;
    }

    /**
     * Sets times to watch.
     *
     * @param newTimesToWatch the new times to watch
     */
    public void setTimesToWatch(Time[] newTimesToWatch) {
        timesToWatch = newTimesToWatch;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name + " " + description + " " + timesToWatch;
    }
}
