package Scheduler;


import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Window.
 *
 * @author: Griffin Robinson
 * @date: 2023 -06-12
 * @File Name : Window
 * @description: _______
 */
public class Window extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;
    private GeneratorController generatorController;
    /**
     * The Teachers combo box.
     */
    EditableComboBox<? extends Teacher> teachersComboBox;
    /**
     * The Times combo box.
     */
    EditableComboBox<? extends Time> timesComboBox;
    /**
     * The Locations combo box.
     */
    EditableComboBox<? extends Location> locationsComboBox;

    private JPanel scheduleDisplayPanel, cardPanel;

    /**
     * Instantiates a new Window.
     *
     * @param generatorController the generator controller
     */
    public Window(GeneratorController generatorController) {
        this.generatorController = generatorController;

        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = createCardPanel(cardLayout);

        getContentPane().add(cards, BorderLayout.CENTER);

        pack();
    }

    /**
     * create main panel with card layout
     *
     * @param layout card layout
     * @return main panel
     */
    private JPanel createCardPanel(CardLayout layout) {
        cardPanel = new JPanel(layout);
        cardPanel.add(createMenuPanel(), "Menu");
        cardPanel.add(createGeneratorPanel(), "Generator");
        cardPanel.add(createParamInitPanel(), "ParamInit");
        cardPanel.add(createViewPanel(), "View");
        cardPanel.add(createSettingsPanel(), "Settings");
        cardPanel.add(createValInitPanel(), "ValInit");
        cardPanel.add(createTeachInitPanel(), "TeachInit");
        cardPanel.add(createTimeInitPanel(), "TimeInit");
        cardPanel.add(createLocInitPanel(), "LocInit");

        return cardPanel;
    }

    /**
     * Creates the menu panel
     *
     * @return menu panel
     */
    private JPanel createMenuPanel() {
        JPanel menuPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Duty Scheduler");

        menuPanel.add(createCardSwitchButton("Generator", "Generator"));

        // create a button to view the schedule
        JButton viewScheduleBtn = new JButton("View Schedule");

        // add an action listener to the button to switch to the schedule display panel
        viewScheduleBtn.addActionListener(e -> {
            scheduleDisplayPanel = createScheduleDisplayPanel();
            cardPanel.add(scheduleDisplayPanel, "ScheduleDisplay");
            cardLayout.show(cardPanel, "ScheduleDisplay");
        });

        menuPanel.add(viewScheduleBtn);

        // create a button to view the schedule
        menuPanel.add(createCardSwitchButton("Settings", "Settings"));

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> {
            this.dispose();
            SwingUtilities.invokeLater(() -> new Window(generatorController).setVisible(true));
        });
        menuPanel.add(refreshBtn);

        return menuPanel;
    }

    /**
     * Creates the generator panel
     *
     * @return generator panel
     */
    private JPanel createGeneratorPanel() {
        JPanel generatorPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Generator");

        JButton generatorBtn = new JButton("Generate");
        generatorBtn.addActionListener(e -> {
            generatorController.generate();
            scheduleDisplayPanel.revalidate();
            scheduleDisplayPanel.repaint();
        });

        generatorPanel.add(createCardSwitchButton("Add Parameters", "ParamInit"));

        generatorPanel.add(generatorBtn);
        generatorPanel.add(createCardSwitchButton("Back", "Menu"));

        return generatorPanel;
    }

    /**
     * Creates the parameter initialisation panel
     *
     * @return parameter initialisation panel
     */
    private JPanel createParamInitPanel() {
        // The main panel which includes everything.
        JPanel mainPanel = new JPanel(new BorderLayout());

        // The content panel which includes all your components. This panel will be added to the JScrollPane.
        JPanel paramInitPanel = createGradientPanel(new GridLayout(), "Parameter Initialisation");
        paramInitPanel.setLayout(new BoxLayout(paramInitPanel, BoxLayout.Y_AXIS));
        paramInitPanel.add(Box.createRigidArea(new Dimension(0, 500)));// todo: fix this

        // Create radio buttons for the user to select the type of object they want to create
        JRadioButton restrictionButton = new JRadioButton("Create Restriction");
        JRadioButton onCallDutyButton = new JRadioButton("Create OnCallDuty");

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(restrictionButton);
        buttonGroup.add(onCallDutyButton);

        // Create panels to hold the input fields for each type of object
        JPanel restrictionFields = new JPanel(new GridLayout(0, 1, 10, 5));
        JPanel onCallDutyFields = new JPanel(new GridLayout(0, 1, 10, 5));

        // Define the input fields for creating a Restriction
        JTextField restrictionDescriptionField = new JTextField(20);
        restrictionDescriptionField.setBorder(BorderFactory.createTitledBorder("Description"));
        restrictionFields.add(restrictionDescriptionField);

        JTextField restrictionDateField = new JTextField(20);
        restrictionDateField.setBorder(BorderFactory.createTitledBorder("Date (dd-MM-yyyy)"));
        restrictionFields.add(restrictionDateField);

        JTextField restrictionWeekField = new JTextField(20);
        restrictionWeekField.setBorder(BorderFactory.createTitledBorder("Week"));
        restrictionFields.add(restrictionWeekField);

        ArrayList<String> timesList = new ArrayList<>();
        for (Time time : generatorController.getTimes()) {
            timesList.add(time.toString());
        }

        CustomJTable restrictionTimesTable = new CustomJTable(timesList);
        JScrollPane restrictionTimeScrollPane = new JScrollPane(restrictionTimesTable);
        restrictionTimeScrollPane.setColumnHeaderView(null);
        restrictionTimeScrollPane.setBorder(BorderFactory.createTitledBorder("Times"));
        restrictionFields.add(restrictionTimeScrollPane);

        JCheckBox restrictionAvailableField = new JCheckBox("Is Available");
        restrictionFields.add(restrictionAvailableField);

        JComboBox<Teacher> restrictionTeacherField = new JComboBox<>(generatorController.getTeachers().toArray(new Teacher[0]));
        restrictionTeacherField.setEditable(false);
        restrictionTeacherField.setBorder(BorderFactory.createTitledBorder("Teacher"));
        restrictionFields.add(restrictionTeacherField);

        JButton restrictionSaveButton = new JButton("Save Restriction");
        restrictionFields.add(restrictionSaveButton);

        // Define the input fields for creating an OnCallDuty
        JTextField onCallDutyNameField = new JTextField(20);
        onCallDutyNameField.setBorder(BorderFactory.createTitledBorder("Name"));
        onCallDutyFields.add(onCallDutyNameField);

        JComboBox<Location> onCallDutyLocationField = new JComboBox<>(generatorController.getLocations().toArray(new Location[0]));
        onCallDutyLocationField.setBorder(BorderFactory.createTitledBorder("Location"));
        onCallDutyFields.add(onCallDutyLocationField);

        CustomJTable onCallDutyTimesTable = new CustomJTable(timesList);
        JScrollPane onCallDutyTimeScrollPane = new JScrollPane(onCallDutyTimesTable);
        onCallDutyTimeScrollPane.setColumnHeaderView(null);
        onCallDutyTimeScrollPane.setBorder(BorderFactory.createTitledBorder("Times"));
        onCallDutyFields.add(onCallDutyTimeScrollPane);

        JTextField onCallDutyDateField = new JTextField(20);
        onCallDutyDateField.setBorder(BorderFactory.createTitledBorder("Date (dd-MM-yyyy)"));
        onCallDutyFields.add(onCallDutyDateField);

        JButton onCallDutySaveButton = new JButton("Save OnCallDuty");
        onCallDutyFields.add(onCallDutySaveButton);

        // Create action listeners for the radio buttons to show the appropriate input fields
        restrictionButton.addActionListener(e -> {
            paramInitPanel.removeAll();
            JLabel titleLabel = new JLabel("Parameter Initialization");
            titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 28));
            paramInitPanel.add(titleLabel);
            paramInitPanel.add(restrictionButton);
            paramInitPanel.add(onCallDutyButton);
            paramInitPanel.add(restrictionFields);
            paramInitPanel.revalidate();
            paramInitPanel.repaint();
        });

        onCallDutyButton.addActionListener(e -> {
            paramInitPanel.removeAll();
            JLabel titleLabel = new JLabel("Parameter Initialization");
            titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 28));
            paramInitPanel.add(titleLabel);
            paramInitPanel.add(restrictionButton);
            paramInitPanel.add(onCallDutyButton);
            paramInitPanel.add(onCallDutyFields);
            paramInitPanel.revalidate();
            paramInitPanel.repaint();
        });

        // Add action listeners for the save buttons to create the appropriate object
        restrictionSaveButton.addActionListener(e -> {
            String description = restrictionDescriptionField.getText();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                date = dateFormat.parse(restrictionDateField.getText());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }

            int week = Integer.parseInt(restrictionWeekField.getText());

            boolean isAvailable = restrictionAvailableField.isSelected();
            Teacher teacher = (Teacher)restrictionTeacherField.getSelectedItem();

            if(date != null) {
                // Get the selected rows from the table
                int[] selectedRows = restrictionTimesTable.getSelectedRows();

                // Retrieve the corresponding times from the table and create a restriction for each
                for(int row : selectedRows) {
                    Time time = null;
                    for (Time t : generatorController.getTimes()) {
                        if (t.toString().equals(restrictionTimesTable.getValueAt(row, 0))) {
                            time = t;
                        }
                    }

                    assert teacher != null;
                    Restriction restriction = new Restriction(description, date, week, time, isAvailable, teacher);
                }
            }
        });

        onCallDutySaveButton.addActionListener(e -> {
            String name = onCallDutyNameField.getText();

            Location location = (Location)onCallDutyLocationField.getSelectedItem();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                date = dateFormat.parse(onCallDutyDateField.getText());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }

            if(date != null) {
                // Get the selected rows from the table
                int[] selectedRows = onCallDutyTimesTable.getSelectedRows();

                // Retrieve the corresponding times from the table and create an OnCallDuty for each
                for(int row : selectedRows) {
                    Time time = null;
                    for (Time t : generatorController.getTimes()) {
                        if (t.toString().equals(onCallDutyTimesTable.getValueAt(row, 0))) {
                            time = t;
                        }
                    }

                    OnCallDuty onCallDuty = new OnCallDuty(name, time, location, date);
                    generatorController.addOnCallDuty(onCallDuty);
                }
            }
        });

        paramInitPanel.add(restrictionButton);
        paramInitPanel.add(onCallDutyButton);

        // Create JScrollPane and add contentPanel to it.
        JScrollPane scrollPane = new JScrollPane(paramInitPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    /**
     * Creates the view panel
     *
     * @return view panel
     */
    private JPanel createViewPanel() {
        JPanel viewPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "View");

        viewPanel.add(createCardSwitchButton("Back", "Menu"));

        return viewPanel;
    }

    /**
     * Creates the settings panel
     *
     * @return settings panel
     */
    private JPanel createSettingsPanel() {
        JPanel settingsPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Settings");

        settingsPanel.add(createCardSwitchButton("Setup", "ValInit"));

        settingsPanel.add(createCardSwitchButton("Back", "Menu"));

        return settingsPanel;
    }

    /**
     * Creates the setup panel
     *
     * @return setup panel
     */
    private JPanel createValInitPanel() {
        JPanel setupPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Value Initialisation");

        teachersComboBox = new EditableComboBox<>("Teachers", generatorController.getTeachers());
        timesComboBox = new EditableComboBox<>("Times", generatorController.getTimes());
        locationsComboBox = new EditableComboBox<>("Locations", generatorController.getLocations());

        setupPanel.add(teachersComboBox);

        setupPanel.add(timesComboBox);

        setupPanel.add(locationsComboBox);

        setupPanel.add(createCardSwitchButton("Next", "TimeInit"));

        setupPanel.add(createCardSwitchButton("Back", "Settings"));

        return setupPanel;
    }

    /**
     * Creates the time initialisation panel
     *
     * @return time initialisation panel
     */
    private JPanel createTimeInitPanel() {
        JPanel timeInitPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Time Initialisation");

        // Get a list of times
        ArrayList<String> times = new ArrayList<>(timesComboBox.getStringList());

        // The index of the current time
        var ref = new Object() {
            int currentTimeIndex = 0;
        };

        // Create a label to display the name of the current time
        JLabel timeLabel = new JLabel();
        timeLabel.setText("Time: " + times.get(ref.currentTimeIndex));
        timeInitPanel.add(timeLabel);

        HashMap<String, CustomTextField> textFields = new HashMap<>();

        // Create text fields for Start Time and End Time
        String[] attributes = {"Start Time (hh:mm)", "End Time (hh:mm)"};
        for (String attribute : attributes) {
            CustomTextField textField = new CustomTextField(attribute);
            textFields.put(attribute, textField);
            timeInitPanel.add(textField);
        }

        // Add save button
        JButton saveButton = new JButton("Save and Next");
        timeInitPanel.add(saveButton);

        // Add action listener to save button
        saveButton.addActionListener(e -> {
            String startTime = textFields.get("Start Time (hh:mm)").getText();
            String endTime = textFields.get("End Time (hh:mm)").getText();

            // Validate startTime and endTime to make sure they are in the format hh:mm
            if (!startTime.matches("^(.\\d|2[0-3]):([0-5]\\d)$") || !endTime.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
                JOptionPane.showMessageDialog(timeInitPanel, "Please enter time in the format hh:mm.", "Invalid Time Format", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Clear the text fields
            textFields.get("Start Time (hh:mm)").clearText();
            textFields.get("End Time (hh:mm)").clearText();

            // Get the name of the current time
            String name = times.get(ref.currentTimeIndex);

            // Create Time object
            generatorController.addTime(name, startTime, endTime);

            // Increment the current time index
            ref.currentTimeIndex++;

            if (ref.currentTimeIndex >= times.size()) {
                cardLayout.show(cards, "TeachInit");
            } else {
                // If there are still times left to initialize, update the JLabel
                timeLabel.setText("Time: " + times.get(ref.currentTimeIndex));
            }
            // For testing, print the current list of time periods
            System.out.println(name + ": " + startTime + " - " + endTime);
        });

        return timeInitPanel;
    }

    /**
     * Creates the teacher initialisation panel
     *
     * @return teacher initialisation panel
     */
    private JPanel createTeachInitPanel() {
        JPanel teachInitPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Teacher Initialisation");

        // Get a list of teachers
        ArrayList<String> teachers = new ArrayList<>(teachersComboBox.getStringList());

        // The index of the current teacher
        var ref = new Object() {
            int currentTeacherIndex = 0;
        };

        // Create a label to display the name of the current teacher
        JLabel teacherLabel = new JLabel();
        teacherLabel.setText(teachers.get(0));
        teachInitPanel.add(teacherLabel);

        HashMap<String, CustomTextField> textFields = new HashMap<>();
        ArrayList<HashMap<String, Object>> teacherData = new ArrayList<>();

        // Create text fields for Name, Subject, and Age
        String[] attributes = {"Minutes Required", "Minutes Remaining"};
        for (String attribute : attributes) {
            CustomTextField textField = new CustomTextField(attribute);
            textFields.put(attribute, textField);
            teachInitPanel.add(textField);
        }

        // Add JComboBox for class and prep periods
        ArrayList<String> periods = new ArrayList<>(timesComboBox.getStringList());

        // Create table of periods
        CustomJTable table = new CustomJTable(periods);

        // Create scroll pane for table and remove header
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setColumnHeaderView(null);

        // Add scroll pane to panel
        teachInitPanel.add(scrollPane);

        // Add save button
        JButton saveButton = new JButton("Save and Next");
        teachInitPanel.add(saveButton);

        // Create atomic integers to store the minutes required and remaining
        AtomicInteger minutesTotal = new AtomicInteger();
        AtomicInteger minutesRemaining = new AtomicInteger();

        // Add action listener to save button
        saveButton.addActionListener(e -> {
            // Get the attribute and value from the text field
            // Clear the text field
            textFields.forEach((attribute, value) -> {
                if (attribute.equals("Minutes Required")) {
                    if (value.getText().equals("")) {
                        minutesTotal.set(0);
                    } else {
                        minutesTotal.set(Integer.parseInt(value.getText()));
                    }
                } else if (attribute.equals("Minutes Remaining")) {
                    if (value.getText().equals("")) {
                        minutesRemaining.set(0);
                    } else {
                        minutesRemaining.set(Integer.parseInt(value.getText()));
                    }
                }
                value.clearText();
            });

            // Create a list to store the selected periods
            ArrayList<String> classPeriods = new ArrayList<>();

            // Get the selected rows from the table
            int[] selectedRows = table.getSelectedRows();

            // Retrieve the corresponding periods from the table and add to list
            for(int row : selectedRows) {
                classPeriods.add((String)table.getValueAt(row, 0));
            }

            // Get the name of the current teacher
            String name = teachers.get(ref.currentTeacherIndex);

            // Increment the current teacher index
            ref.currentTeacherIndex++;

            // Create a Teacher object from data
            generatorController.addTeacher(name, minutesTotal.get(), minutesRemaining.get(), classPeriods);

            // If there are still teachers left, update the JLabel and clear fields
            if(ref.currentTeacherIndex >= teachers.size()) {
                // When all teachers are initialized go to the next card
                cardLayout.show(cards, "LocInit");
            } else {
                teacherLabel.setText("Teacher: " + teachers.get(ref.currentTeacherIndex));
                table.clearSelection();
            }

            // For testing, print the current list of teacher data
            System.out.println(name + " " + minutesTotal + " " + minutesRemaining + " " + classPeriods);
        });
        return teachInitPanel;
    }

    /**
     * Creates the location initialisation panel
     *
     * @return location initialisation panel
     */
    private JPanel createLocInitPanel() {
        JPanel locInitPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Location Initialisation");

        // Get a list of locations
        ArrayList<String> locations = new ArrayList<>(locationsComboBox.getStringList());

        // The index of the current location
        var ref = new Object() {
            int currentLocationIndex = 0;
        };

        // Create a label to display the name of the current location
        JLabel locationLabel = new JLabel();
        locationLabel.setText(locations.get(0));
        locInitPanel.add(locationLabel);

        HashMap<String, CustomTextField> textFields = new HashMap<>();

        // Create a text field for the Location Description
        CustomTextField textField = new CustomTextField("Location Description");
        textFields.put("Location Description", textField);
        locInitPanel.add(textField);

        // Add JComboBox for supervised times
        ArrayList<String> times = new ArrayList<>(timesComboBox.getStringList());

        // Create table of times
        CustomJTable table = new CustomJTable(times);

        // Create scroll pane for table and remove header
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setColumnHeaderView(null);

        // Add scroll pane to panel
        locInitPanel.add(scrollPane);

        // Add save button
        JButton saveButton = new JButton("Save and Next");
        locInitPanel.add(saveButton);

        // Add action listener to save button
        saveButton.addActionListener(e -> {
            // Get the description from the text field
            // Clear the text field
            String locationDescription = textFields.get("Location Description").getText();
            textFields.get("Location Description").clearText();

            // Create a list to store the selected times
            ArrayList<String> supervisedTimes = new ArrayList<>();

            // Get the selected rows from the table
            int[] selectedRows = table.getSelectedRows();

            // Retrieve the corresponding times from the table and add to list
            for (int row : selectedRows) {
                supervisedTimes.add((String)table.getValueAt(row, 0));
            }

            // Get the name of the current location
            String name = locations.get(ref.currentLocationIndex);

            // Increment the current location index
            ref.currentLocationIndex++;

            // Create a Location object and add it to the list
            generatorController.addLocation(name, locationDescription, supervisedTimes);

            // If there are still locations left, update the JLabel and clear fields
            if (ref.currentLocationIndex >= locations.size()) {
                // When all locations are initialized go to the next card
                cardLayout.show(cards, "Menu");
            } else {
                locationLabel.setText("Location: " + locations.get(ref.currentLocationIndex));
                table.clearSelection();
            }

            // For testing, print the current list of location data
            System.out.println(name + " " + locationDescription + " " + supervisedTimes);
        });

        return locInitPanel;
    }

    /**
     * Create schedule display panel jpanel.
     *
     * @return the jpanel
     */
    private JPanel createScheduleDisplayPanel() {
        // Create a new panel with a BorderLayout
        JPanel schedulePanel = new JPanel(new BorderLayout());

        // Get the assigned duties
        HashMap<SupervisionDuty, Teacher> assignedDuties = generatorController.getAssignedSupervisionDuties();

        // DEBUG: Print out assigned duties
        System.out.println("Assigned Duties: " + assignedDuties);

        // Create column names for the JTable
        String[] columnNames = {"Teacher", "Time", "Location"};

        // Create a 2D array to store the data for the JTable
        String[][] data = new String[assignedDuties.size()][3];

        // Iterate over the entries in the map
        int index = 0;
        for (Map.Entry<SupervisionDuty, Teacher> entry : assignedDuties.entrySet()) {
            SupervisionDuty duty = entry.getKey();
            Teacher teacher = entry.getValue();

            // Add the data to the 2D array
            data[index][0] = teacher.getName();
            data[index][1] = duty.getTime().getName();
            data[index][2] = duty.getLocation().getName();

            // DEBUG: Print out data for this row
            System.out.println("Row data: " + Arrays.toString(data[index]));

            index++;
        }

        // DEBUG: Print out full 2D data array
        System.out.println("Full data array: " + Arrays.deepToString(data));

        // Create a new JTable with the data and column names
        JTable table = new JTable(data, columnNames);

        // Make the table read-only (i.e., user cannot edit)
        table.setDefaultEditor(Object.class, null);

        // Create a JScrollPane containing the JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the panel
        schedulePanel.add(scrollPane, BorderLayout.CENTER);

        // Revalidate and repaint the table to ensure it updates with the data
        table.revalidate();
        table.repaint();

        schedulePanel.add(createCardSwitchButton("Return to Menu", "Menu"), BorderLayout.PAGE_END);

        return schedulePanel;
    }


    /**
     * Creates a gradient panel with set border and set title
     *
     * @param layout layout of panel
     * @param text   text to display
     * @return gradient panel
     */
    private JPanel createGradientPanel(LayoutManager layout, String text) {

        JPanel panel = new JPanel(layout) {//https://stackoverflow.com/questions/14364291/jpanel-gradient-background - Mohammed Sayed
                @Override
                protected void paintComponent(Graphics graphics) {
                    super.paintComponent(graphics);
                    Graphics2D g2d = (Graphics2D) graphics;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    GradientPaint gp = new GradientPaint(0, 0,
                            getBackground().darker().darker(), 0, getHeight(),
                            getBackground().brighter().brighter());
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, getWidth(), getHeight());

                }

            };

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font(Font.SERIF, Font.BOLD, 28));
        panel.add(label);
        return panel;
    }

    /**
     * Creates a button that switches the card
     *
     * @param buttonText text to display on button
     * @param cardName   name of card to switch to
     * @return button
     */
    private JButton createCardSwitchButton(String buttonText, String cardName) {
        JButton button = new JButton(buttonText);

        //Add action listener to button that switches the card
        button.addActionListener(e -> cardLayout.show(cards, cardName));

        return button;
    }

    /**
     * Creates a non-editable combo box with a title and items
     *
     * @param title title of combo box
     * @param items items to add to combo box
     * @return combo box
     */
    private JComboBox<? extends String> createNonEditableComboBox(String title, ArrayList<String> items) {
        JComboBox<String> comboBox = new JComboBox<>();

        for (String item : items) {
            comboBox.addItem(item);
        }

        comboBox.setEditable(false);
        comboBox.setBorder(BorderFactory.createTitledBorder(title));

        return comboBox;
    }
}
