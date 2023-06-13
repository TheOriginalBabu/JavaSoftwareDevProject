package Scheduler;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Griffin Robinson
 * @date: 2023-06-12
 * @File Name: Window
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

        return panel;
    }

    /**
     * Creates the menu panel
     *
     * @return menu panel
     */
    private JPanel createMenuPanel() {
        JPanel menuPanel = createGradientPanel(new GridLayout(0, 1, 10, 10), "Duty Scheduler");

        menuPanel.add(createCardSwitchButton("Next Card", "Generator"));
        menuPanel.add(createCardSwitchButton("Previous Card", "Menu"));

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
        generatorPanel.add(createCardSwitchButton("Back", "Menu"), BorderLayout.SOUTH);

        return generatorPanel;
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
}
