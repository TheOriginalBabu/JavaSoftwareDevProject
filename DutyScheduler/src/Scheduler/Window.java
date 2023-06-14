package Scheduler;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        panel.add(createSetupPanel(), "Setup");

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

        settingsPanel.add(createCardSwitchButton("Setup", "Setup"));

        settingsPanel.add(createCardSwitchButton("Back", "Menu"));

        return settingsPanel;
    }

    /**
     * Creates the setup panel
     *
     * @return setup panel
     */
    private JPanel createSetupPanel() {
        JPanel setupPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Setup - Value Initialisation");

        setupPanel.add(createComboBox("Teachers", generatorController.getTeachers().toArray()));

        setupPanel.add(createCardSwitchButton("Back", "Settings"));

        return setupPanel;
    }



    /**
     * Creates a gradient panel with set border and set title
     *
     * @param layout layout of panel
     * @param text   text to display
     * @return gradient panel
     */
    private JPanel createGradientPanel(LayoutManager layout, String text) {
        JPanel panel = new JPanel(layout) {
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, cardName);
            }
        });
        return button;
    }

    /**
     * Creates a combo box with a list of items
     *
     * @param text text to display
     * @param list list of items
     * @return combo box
     */
    private JComboBox<Object> createComboBox(String text, Object[] list) {
        JComboBox<Object> cb = new JComboBox<Object>(list);
        cb.setSelectedItem(text);
        cb.setEditable(true);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo: take input and add and array to list then clear input
                //check if user inpu talready exists
                if (cb.getSelectedItem() != null) {
                    if (cb.contains(cb.getSelectedItem())) {
                        cb.removeItem(cb.getSelectedItem());
                    }
                }
                cb.addItem(cb.getSelectedItem());

            }
        });

        return cb;
    }
}
