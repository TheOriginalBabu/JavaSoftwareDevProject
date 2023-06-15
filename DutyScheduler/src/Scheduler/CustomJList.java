package Scheduler;

import javax.swing.*;
import java.util.List;

public class CustomJList extends JList<String>{
    public CustomJList(String[] items) {
        super(items);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    public List<String> getSelectedItems() {
        return this.getSelectedValuesList();
    }

    public void clearSelectedItems() {
        this.clearSelection();
    }
}
