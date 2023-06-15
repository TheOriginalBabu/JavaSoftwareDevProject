package Scheduler;

import javax.swing.*;

public class CustomTextField extends JTextField {
    private String identifier;

    public CustomTextField(String identifier) {
        super();
        this.identifier = identifier;
        this.setBorder(BorderFactory.createTitledBorder(identifier));
    }

    public String getIdentifier() {
        return identifier;
    }

    public void clearText() {
        this.setText("");
    }
}
