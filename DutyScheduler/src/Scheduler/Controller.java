package Scheduler;

import javax.swing.*;

/**
 * The type Controller. TODO: Add description
 *
 * @author: Griffin, Izaan, Ronit, Shahmeer
 * @date: 2023 -05-18
 * @File: Controller
 */
public class Controller {//todo: Error Trapping/Handling
    /**
     * The Config.
     */
    Config config;
    /**
     * The File reader.
     */
    FileReader fileReader;
    /**
     * The File writer.
     */
    FileWriter fileWriter;
    /**
     * The Generator.
     */
    Generator generator;
    /**
     * The Teacher.
     */
    Teacher teacher;

    Duty duty;
    /**
     * The Time.
     */
    Time time;
    /**
     * The Location.
     */
    Location location;
    /**
     * The Restriction.
     */
    Restriction restriction;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window window = new Window();
            }
        });
    }
}
