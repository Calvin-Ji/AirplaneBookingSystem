package airplanebookingsystem;


public class MyModel extends javax.swing.table.DefaultTableModel {
    
    public MyModel(Object[][] data, Object[] cols) {
        super(data, cols);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
    
}
    
    
    
    

