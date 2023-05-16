package Sheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
    private JComboBox<Object> TeacherDropDownS1;
    private JComboBox<Object> LocationsDropDownS1;
    private JComboBox<Object> TimesDropDownS1;
    private JPanel optionsPage;
    private JButton setUpButton;
    private JButton editButton;
    private JComboBox TeacherDropDownSG;
    private JTabbedPane SetUpFrame;
    private JButton NextBtnS1;
    private JPanel NameINIT;
    private JPanel TeachersINIT;
    private JComboBox<String> TeachersDropDownS2;
    private JTextField TeacherHoursS2;
    private JComboBox<String> LocationDropDownS3;
    private JButton enterBtnS2;
    private JTextField timesToBeSupervisedTextField;
    private JButton enterBtn1S3;
    private JTextField descriptionLblS3;
    private JButton enterBtn2S3;
    private JButton NextBtnS2;
    private JButton NextBtnS3;
    private JComboBox<String> TimeDropDownS4;
    private JList LocationListS4;
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
        CardLayout mainCardLayout = (CardLayout) Frame.getLayout();
        scheduleGeneratorBTN.addActionListener(e -> mainCardLayout.show(Frame, "ScheduleGeneratorPage"));
        optionsBTN.addActionListener(e -> mainCardLayout.show(Frame, "OptionsPage"));
        setUpButton.addActionListener(e -> mainCardLayout.show(Frame, "SetupPage"));
        NextBtnS1.addActionListener(e -> SetUpFrame.setSelectedIndex(SetUpFrame.getSelectedIndex() + 1));
        NextBtnS2.addActionListener(e -> SetUpFrame.setSelectedIndex(SetUpFrame.getSelectedIndex() + 1));
        NextBtnS3.addActionListener(e -> SetUpFrame.setSelectedIndex(SetUpFrame.getSelectedIndex() + 1));
    }

    /**
     * Sets up the dropdown menus on the setup page with the ability to add new items
     */
    private void setUpPageInit() {
        TeacherDropDownS1.setEditable(true); // Gives the user the ability to type in the dropdown menu
        TeacherDropDownS1.addItem("Teachers"); // Sets the default text shown on the dropdown menu
        TeacherDropDownS1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    TeacherDropDownS1.addItem(TeacherDropDownS1.getEditor().getItem());
                    teachersArr.add((String) TeacherDropDownS1.getEditor().getItem());
                    TeacherDropDownS1.getEditor().setItem("");
                }
            }
        });


        LocationsDropDownS1.setEditable(true); // Gives the user the ability to type in the dropdown menu
        LocationsDropDownS1.addItem("Locations"); // Sets the default text shown on the dropdown menu
        LocationsDropDownS1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    LocationsDropDownS1.addItem(LocationsDropDownS1.getEditor().getItem());
                    locationsArr.add((String) LocationsDropDownS1.getEditor().getItem());
                    LocationsDropDownS1.getEditor().setItem("");
                }
            }
        });

        TimesDropDownS1.setEditable(true); // Gives the user the ability to type in the dropdown menu
        TimesDropDownS1.addItem("Times"); // Sets the default text shown on the dropdown menu
        TimesDropDownS1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    TimesDropDownS1.addItem(TimesDropDownS1.getEditor().getItem());
                    timesArr.add((String) TimesDropDownS1.getEditor().getItem());
                    TimesDropDownS1.getEditor().setItem("");
                }
            }
        });

        LocationListS4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        LocationListS4.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        LocationListS4.setVisibleRowCount(-1);
        DefaultListModel listModel = new DefaultListModel();

        SetUpFrame.addFocusListener(new FocusAdapter() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (e != null) {
                    TeacherDropDownS1.removeAllItems();
                    LocationsDropDownS1.removeAllItems();
                    TimesDropDownS1.removeAllItems();
                    TeachersDropDownS2.removeAllItems();
                    LocationDropDownS3.removeAllItems();
                    TimeDropDownS4.removeAllItems();
                    TeacherDropDownS1.addItem("Teachers");
                    LocationsDropDownS1.addItem("Locations");
                    TimesDropDownS1.addItem("Times");
                    TeachersDropDownS2.addItem("Teacher");
                    LocationDropDownS3.addItem("Location");
                    TimeDropDownS4.addItem("Time");
                    for (String teacher : teachersArr) { // Adds teacher names to the dropdown menu
                        TeacherDropDownS1.addItem(teacher);
                        TeachersDropDownS2.addItem(teacher);
                    }
                    for (String location : locationsArr) { // Adds location names to the dropdown menu
                        LocationsDropDownS1.addItem(location);
                        LocationDropDownS3.addItem(location);
                        listModel.addElement(location);
                    }
                    LocationListS4.setModel(listModel);
                    for (String time : timesArr) { // Adds time names to the dropdown menu
                        TimesDropDownS1.addItem(time);
                        TimeDropDownS4.addItem(time);
                    }
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
