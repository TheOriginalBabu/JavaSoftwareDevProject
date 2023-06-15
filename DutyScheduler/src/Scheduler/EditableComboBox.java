package Scheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Editable combo box.
 *
 * @param <T> the type parameter
 */
public class EditableComboBox<T> extends JComboBox<String> {

    private ArrayList<String> stringList;

    /**
     * Instantiates a new Editable combo box.
     *
     * @param text the text
     * @param list the list
     */
    public EditableComboBox(String text, ArrayList<T> list) {
        super();
        this.stringList = new ArrayList<>();

        // Add items to combo box and to string list
        for (T element : list) {
            this.addItem(element.toString());
            stringList.add(element.toString());
        }

        // Create the custom editor
        final JTextField editor = new JTextField();
        editor.setBorder(null);
        this.setEditor(new ComboBoxEditor() {
            @Override
            public Component getEditorComponent() {
                return editor;
            }

            @Override
            public void setItem(Object anObject) {
                if (anObject != null)
                    editor.setText(anObject.toString());
                else
                    editor.setText(text);  // Set the prompt text when item is null
            }

            @Override
            public Object getItem() {
                return editor.getText();
            }

            @Override
            public void selectAll() {
                editor.selectAll();
            }

            @Override
            public void addActionListener(ActionListener l) {
                editor.addActionListener(l);
            }

            @Override
            public void removeActionListener(ActionListener l) {
                editor.removeActionListener(l);
            }
        });

        // Overrides method to display default prompt text when no item is selected
        this.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value == null) {
                    setText(text);
                }
                return this;
            }
        });

        // Add action listener to combo box that adds user item to list if it is not already in the list
        this.addActionListener(e -> {
            String input = ((JTextField)EditableComboBox.this.getEditor().getEditorComponent()).getText();

            if(input != null && !input.equals(text) && !stringList.contains(input)) {
                this.addItem(input);
                stringList.add(input);

                // Refreshes the combo box
                this.revalidate();
                this.repaint();

                // Clear the input field for the next entry
                ((JTextField)EditableComboBox.this.getEditor().getEditorComponent()).setText("");
            }
        });

        this.setEditable(true); // Allow user to type in combo box
        this.setSelectedItem(null); // Set default item to null
        this.setBorder(BorderFactory.createTitledBorder(text));
    }

    /**
     * Gets string list.
     *
     * @return the string list
     */
    public ArrayList<String> getStringList() {
        return this.stringList;
    }
}
