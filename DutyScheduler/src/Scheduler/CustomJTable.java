package Scheduler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomJTable extends JTable {

    public CustomJTable(ArrayList<String> data) {
        super(new CustomTableModel(data));

        // Custom selection model
        this.setSelectionModel(new DefaultListSelectionModel() {
            @Serial
            private static final long serialVersionUID = 1L;

            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });

        // Disable cell editing
        this.setDefaultEditor(Object.class, null);

        // Remove table header
        this.setTableHeader(null);
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
