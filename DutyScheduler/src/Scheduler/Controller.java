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
     * The File path.
     */
    private final String DEFAULT_CONFIG_FILE_PATH = "Data/config.csv";


    /**
     * Instantiates a new Controller.
     */
    private Controller() {
        Config config = new Config(DEFAULT_CONFIG_FILE_PATH); //todo: Receive data from config file and set to variables/Objects

        GeneratorController generatorController = new GeneratorController(config.getTimes(), config.getSupervisionDuties(), config.getTeachers(), config.getOnCallDuties());

        /* ↓ RUN THIS LAST. Starts GUI ↓ */
        SwingUtilities.invokeLater(() -> new Window(generatorController));
        /* ↑ RUN THIS LAST. Starts GUI ↑ */
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Controller();
    }
}
