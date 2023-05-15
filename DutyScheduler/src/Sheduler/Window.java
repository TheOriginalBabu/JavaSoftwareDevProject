package Sheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author: Griffin Robinson
 * @date: 2023-05-11
 * @File Name: Window
 * @description: _______
 */
public class Window extends JFrame {

    private JPanel Frame;
    private JPanel StartPage;
    private JPanel ScheduleGeneratorPage;
    private JButton scheduleGeneratorBTN, optionsBTN;
    private JPanel SetupPage;
    private JComboBox<Object> TeacherDropDown;
    private JComboBox<Object> LocationsDropDown;
    private JComboBox<Object> TimesDropDown;
    private JPanel optionsPage;
    private JButton setUpButton;
    private JButton editButton;
    private ArrayList<String> teachersArr = new ArrayList<String>(); //todo Change to hashmap
    private ArrayList<String> locationsArr = new ArrayList<String>(); //todo Change to hashmap
    private ArrayList<String> timesArr = new ArrayList<String>(); //todo Change to hashmap

    public Window() {

        // Calls a method that initializes the main window
        windowInit();

        // Adds all the pages to the main window
        Frame.add(StartPage, "StartPage");
        Frame.add(ScheduleGeneratorPage, "ScheduleGeneratorPage");
        Frame.add(optionsPage, "OptionsPage");
        Frame.add(SetupPage, "SetupPage");

        // Sets the main window to be visible
        setVisible(true);

        // Calls initialization methods
        cardLayoutInit();
        setUpPageInit();
    }

    /**
     * Sets up the card layout for the frame and sets what each page each button goes to
     */
    private void cardLayoutInit() {
        CardLayout cardLayout = (CardLayout) Frame.getLayout();
        scheduleGeneratorBTN.addActionListener(e -> cardLayout.show(Frame, "ScheduleGeneratorPage"));
        optionsBTN.addActionListener(e -> cardLayout.show(Frame, "OptionsPage"));
        setUpButton.addActionListener(e -> cardLayout.show(Frame, "SetupPage"));
    }

    /**
     * Sets up the dropdown menus on the setup page with the ability to add new items
     */
    private void setUpPageInit() {
        TeacherDropDown.setEditable(true); // Gives the user the ability to type in the dropdown menu
        TeacherDropDown.add(new JLabel("Teachers")); // Sets the default text shown on the dropdown menu
        TeacherDropDown.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    TeacherDropDown.addItem(TeacherDropDown.getEditor().getItem());
                    teachersArr.add((String) TeacherDropDown.getEditor().getItem());
                    TeacherDropDown.getEditor().setItem("");
                }
            }
        });
        LocationsDropDown.setEditable(true); // Gives the user the ability to type in the dropdown menu
        LocationsDropDown.add(new JLabel("Locations")); // Sets the default text shown on the dropdown menu
        LocationsDropDown.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    LocationsDropDown.addItem(LocationsDropDown.getEditor().getItem());
                    locationsArr.add((String) LocationsDropDown.getEditor().getItem());
                    LocationsDropDown.getEditor().setItem("");
                }
            }
        });
        TimesDropDown.setEditable(true); // Gives the user the ability to type in the dropdown menu
        TimesDropDown.add(new JLabel("Times")); // Sets the default text shown on the dropdown menu
        TimesDropDown.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    TimesDropDown.addItem(TimesDropDown.getEditor().getItem());
                    timesArr.add((String) TimesDropDown.getEditor().getItem());
                    TimesDropDown.getEditor().setItem("");
                }
            }
        });
    }

    /**
     * Initializes the main window with basic settings
     */
    private void windowInit() {
        setContentPane(Frame); // Setting main content pane
        setTitle("Duty Scheduler"); // Title at top of window
        setSize(500, 700); // Default Size of window
        setResizable(true); // Allows the window to be resized
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Sets the close button to close the program when clicked
    }

    public static void main(String[] args) {
        new Window();
    }
}
