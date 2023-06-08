package Scheduler;

import javax.swing.*;

public class Window extends JFrame{
    private JPanel BaseFrame;
    private JPanel Menu;
    private JButton button1;
    private JButton button2;
    private JButton button3;


    public Window() {
        setContentPane(BaseFrame);
        setTitle("Duty Scheduler");
        setSize(630, 855);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
