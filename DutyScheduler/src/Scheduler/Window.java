package Scheduler;

/**
 * @author: Griffin Robinson
 * @date: 2023-06-12
 * @File Name: Window
 * @description: _______
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Window.
 */
public class Window extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;

    public Window() {
        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = createCardPanel(cardLayout);

        getContentPane().add(cards, BorderLayout.CENTER);

        pack();
    }

    private JPanel createCardPanel(CardLayout layout) {
        JPanel panel = new JPanel(layout);
        panel.add(createPanel("Duty Scheduler"), "Menu");
        panel.add(createPanel("Page 2"), "Card2");

        return panel;
    }

    private JPanel createPanel(String text) {
        JPanel panel = createGradientPanel(new GridLayout(0, 1, 10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel(text);
        label.setFont(new Font(Font.SERIF, Font.BOLD, 28));
        panel.add(label);

        panel.add(createCardSwitchButton("Next Card", "Card2"));
        panel.add(createCardSwitchButton("Previous Card", "Menu"));

        return panel;
    }

    private JPanel createGradientPanel(LayoutManager layout) {
        return new JPanel(layout) {
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
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window().setVisible(true));
    }
}
