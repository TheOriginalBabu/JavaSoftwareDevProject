package Sheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton button1;

    public Window() {
        windowInit();
        Frame.add(StartPage, "StartPage");
        Frame.add(ScheduleGeneratorPage, "ScheduleGeneratorPage");
        setVisible(true);

        CardLayout cardLayout = (CardLayout) Frame.getLayout();

        button1.addActionListener(e -> cardLayout.show(Frame, "ScheduleGeneratorPage"));
    }

    private void windowInit() {
        setContentPane(Frame);
        setTitle("Duty Scheduler");
        setSize(500, 700);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window();
    }
}
