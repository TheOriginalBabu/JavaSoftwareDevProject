package Scheduler;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomJTable extends JTable {

    public CustomJTable(ArrayList<String> data) {
        super(new CustomTableModel(data));
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setColumnSelectionAllowed(false);
        this.setRowSelectionAllowed(true);
    }
}

class CustomTableModel extends AbstractTableModel {
    private ArrayList<String> data;

    public CustomTableModel(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex);
    }
}
