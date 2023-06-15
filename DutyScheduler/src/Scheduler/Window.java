package Scheduler;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        JPanel panel = new JPanel(layout);
        panel.add(createMenuPanel(), "Menu");
        panel.add(createGeneratorPanel(), "Generator");
        panel.add(createViewPanel(), "View");
        panel.add(createSettingsPanel(), "Settings");
        panel.add(createValInitPanel(), "ValInit");
        panel.add(createTeachInitPanel(), "TeachInit");
        panel.add(createTimeInitPanel(), "TimeInit");
        panel.add(createLocInitPanel(), "LocInit");

        return panel;
    }

    /**
     * Creates the menu panel
     *
     * @return menu panel
     */
    private JPanel createMenuPanel() {
        JPanel menuPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Duty Scheduler");

        menuPanel.add(createCardSwitchButton("Generator", "Generator"));

        menuPanel.add(createCardSwitchButton("Schedule View", "View"));

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
        generatorBtn.addActionListener(e -> generatorController.generate());

        generatorPanel.add(generatorBtn);
        generatorPanel.add(createCardSwitchButton("Back", "Menu"));

        return generatorPanel;
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

        setupPanel.add(createCardSwitchButton("Next", "TeachInit"));

        setupPanel.add(createCardSwitchButton("Back", "Settings"));

        return setupPanel;
    }

    /**
     * Creates the teacher initialisation panel
     *
     * @return teacher initialisation panel
     */
    private JPanel createTeachInitPanel() {
        JPanel teachInitPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Teacher Initialisation");

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
        String[] periods = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        CustomJList classPeriodsList = new CustomJList(periods);
        CustomJList prepPeriodsList = new CustomJList(periods);

        // Set selection mode to multiple interval selection
        classPeriodsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//todo: fix this
        prepPeriodsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//todo: fix this

        // Add scroll panes for the lists
        JScrollPane classPeriodsScrollPane = new JScrollPane(classPeriodsList);
        classPeriodsScrollPane.setBorder(BorderFactory.createTitledBorder("Select Prep Periods"));
        teachInitPanel.add(classPeriodsScrollPane);

        // Add JScroll pane for prep periods
        JScrollPane prepPeriodsScrollPane = new JScrollPane(prepPeriodsList);
        prepPeriodsScrollPane.setBorder(BorderFactory.createTitledBorder("Select Prep Periods"));
        teachInitPanel.add(prepPeriodsScrollPane);

        JButton saveButton = new JButton("Save and Next");
        teachInitPanel.add(saveButton);

        saveButton.addActionListener(e -> {
            // Create a new map to store the current teacher's information
            HashMap<String, Object> currentTeacher = new HashMap<>();
            for (Map.Entry<String, CustomTextField> entry : textFields.entrySet()) {
                // Get the attribute and value from the text field
                currentTeacher.put(entry.getKey(), entry.getValue().getText());
                // Clear the text field
                entry.getValue().clearText();
            }

            // Create a map for the periods
            HashMap<String, String> periodAssignments = new HashMap<>();
            for (String period : classPeriodsList.getSelectedItems()) {
                periodAssignments.put(period, "Class");
            }
            for (String period : prepPeriodsList.getSelectedItems()) {
                periodAssignments.put(period, "Prep");
            }

            // Clear the selected items in the lists
            classPeriodsList.clearSelectedItems();
            prepPeriodsList.clearSelectedItems();

            // Add the periods map to the current teacher's information
            currentTeacher.put("Periods", periodAssignments);

            // Add the current teacher's information to the list
            teacherData.add(currentTeacher);

            // For testing, print the current list of teacher data
            System.out.println(teacherData);

            // Clear the selected items in the lists
            classPeriodsList.clearSelection();
            prepPeriodsList.clearSelection();
        });
        return teachInitPanel;
    }

    /**
     * Creates the time initialisation panel
     *
     * @return time initialisation panel
     */
    private JPanel createTimeInitPanel() {
        JPanel timeInitPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Time Initialisation");

        timeInitPanel.add(new EditableComboBox<>("Times", generatorController.getTimes()));

        timeInitPanel.add(createCardSwitchButton("Next", "LocInit"));

        timeInitPanel.add(createCardSwitchButton("Back", "TeachInit"));

        return timeInitPanel;
    }

    /**
     * Creates the location initialisation panel
     *
     * @return location initialisation panel
     */
    private JPanel createLocInitPanel() {
        JPanel locInitPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Location Initialisation");

        locInitPanel.add(new EditableComboBox<>("Locations", generatorController.getLocations()));

        locInitPanel.add(createCardSwitchButton("Next", null));

        locInitPanel.add(createCardSwitchButton("Back", "TimeInit"));

        return locInitPanel;
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
