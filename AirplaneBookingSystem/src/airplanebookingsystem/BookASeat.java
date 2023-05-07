
package airplanebookingsystem;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookASeat extends javax.swing.JFrame {

    
    AirplaneBookingSystem owner;
     
     
    public BookASeat(AirplaneBookingSystem owner) {
        this.owner = owner;
        initComponents();
        setLocationRelativeTo(null);
        AvailableSeatsTable.getTableHeader().setResizingAllowed(false);
        setDefaultCloseOperation( javax.swing.JFrame.DISPOSE_ON_CLOSE );
    }
    
    String[][] data = { {"hi","bye"} , {"good", "bad"}, {"iiii","ii"} };
    String[] col = { "Seat Number", "Availability", "Seat Class", "Seat Type", "Row Number", "Column Number"};
    
    MyModel model = new MyModel(data, col);
    
    
    
    public void addASeatAvailableSeatsTable(int seatindexnumber){
         //for(int s=0;s<owner.seats.size();s++){
                //if(owner.seats.get(s).getSeatIndexNumber()==seatindexnumber){
                    Object[] row = {owner.seats.get(seatindexnumber).getSeatIndexNumber(),owner.seats.get(seatindexnumber).getAvailability(),owner.seats.get(seatindexnumber).getSeatclass(),owner.seats.get(seatindexnumber).getSeattype(),owner.seats.get(seatindexnumber).getRow(),owner.seats.get(seatindexnumber).getCol()};
                   model.addRow(row);      
                //}
            //}
    }
    
    public void removeASeatAvailableSeatsTable(int seatindexnumber){
            for(int k=0;k<model.getRowCount();k++){    
                    if((int)(model.getValueAt(k, 0))==seatindexnumber){
                        model.removeRow(k);
                    }
            }          
    }
    public void ClearAvailableSeatsTable(){     
           model.setRowCount(0);     
    }
    
    public void DisplayAvailableSeats(){
        AvailableSeatsTable.setModel(model);
        
        String two = "2";
        String three = "3";
        String Economy = "EconomyClass";
        String Business = "BusinessClass";
        String First = "FirstClass";
        String Mid = "Middle";
        String Win = "Window";
        String Ais = "Aisle";
        
        ClearAvailableSeatsTable();
        
        

        
        if(!NoPreferences.isSelected() && !FirstClass.isSelected() && !EconomyClass.isSelected() && !BusinessClass.isSelected() && !Window.isSelected() && !Middle.isSelected() && !Aisle.isSelected() && !(SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three))){
                //nothing entered please choose a prefrence/s
        }
        else if(!NoPreferences.isSelected() && !FirstClass.isSelected() && !EconomyClass.isSelected() && !BusinessClass.isSelected() && !Window.isSelected() && !Middle.isSelected() && !Aisle.isSelected() && SeatsNextToEachOther.getText().equals(two)){
                //nothing entered please choose a prefrence/s
                 }
        else if(!NoPreferences.isSelected() && !FirstClass.isSelected() && !EconomyClass.isSelected() && !BusinessClass.isSelected() && !Window.isSelected() && !Middle.isSelected() && !Aisle.isSelected() && SeatsNextToEachOther.getText().equals(three)){
                //nothing entered please choose a prefrence/s
                 }
        else if(NoPreferences.isSelected() && !(SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three))){
            for(int s=0;s<owner.seats.size();s++){
                    addASeatAvailableSeatsTable(s);
                
            }
        }
        else if(NoPreferences.isSelected() && SeatsNextToEachOther.getText().equals(two)){
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(First) && owner.seats.get(s).getCol()==0 && owner.seats.get(s).getAvailability() && owner.seats.get(s+1).getSeatclass().equals(First) && owner.seats.get(s+1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s+1);
                }
            }
             
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==0 && owner.seats.get(s).getSeatclass().equals(Business)){
                    if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s+1).getSeatclass().equals(Business) && owner.seats.get(s+1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s+1);
                }
                }
                else if(owner.seats.get(s).getCol()==2 && owner.seats.get(s).getSeatclass().equals(Business)){
                   if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Business) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Business) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                } 
                
                else if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Business) && owner.seats.get(s-1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s-1);
                }
            }
            }
            
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==3 && owner.seats.get(s).getSeatclass().equals(Economy)){
                    if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s+1).getSeatclass().equals(Economy) && owner.seats.get(s+1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s+1);
                }
                    
                }
                else if(owner.seats.get(s).getCol()==5 && owner.seats.get(s).getSeatclass().equals(Economy)){
                   if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Economy) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Economy) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                } 
                
                else if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Economy) && owner.seats.get(s-1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s-1);
                }
            }
            }
            
        }
        else if(NoPreferences.isSelected() && SeatsNextToEachOther.getText().equals(three)){
            //There are no first class seats that can meet these requirments.
            
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==2 && owner.seats.get(s).getSeatclass().equals(Business)){
                   if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Business) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Business) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s-1);
                    addASeatAvailableSeatsTable(s-2);
                  } 
                }
            }    
             
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==5 && owner.seats.get(s).getSeatclass().equals(Economy)){
                   if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Economy) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Economy) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s-1);
                    addASeatAvailableSeatsTable(s-2);
                } 
                }
            }
             
        }
        else if(FirstClass.isSelected() && !Window.isSelected() && !Middle.isSelected() && !Aisle.isSelected() && !(SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three))){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(First) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
        else if(EconomyClass.isSelected() && !Window.isSelected() && !Middle.isSelected() && !Aisle.isSelected() && !(SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three))){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
        else if(BusinessClass.isSelected() && !Window.isSelected() && !Middle.isSelected() && !Aisle.isSelected() && !(SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three))){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(Window.isSelected() && !FirstClass.isSelected() && !EconomyClass.isSelected() && !BusinessClass.isSelected() ){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeattype().equals(Win) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(Middle.isSelected() && !FirstClass.isSelected() && !EconomyClass.isSelected() && !BusinessClass.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeattype().equals(Mid) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(Aisle.isSelected() && !FirstClass.isSelected() && !EconomyClass.isSelected() && !BusinessClass.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeattype().equals(Ais) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(EconomyClass.isSelected() && Middle.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getSeattype().equals(Mid) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(EconomyClass.isSelected() && Aisle.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getSeattype().equals(Ais) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(EconomyClass.isSelected() && Window.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getSeattype().equals(Win) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(FirstClass.isSelected() && Middle.isSelected()){
            //There are no middle First Class seats
        }
         else if(FirstClass.isSelected() && Aisle.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(First) && owner.seats.get(s).getSeattype().equals(Ais) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(FirstClass.isSelected() && Window.isSelected()){
            //There are no window First Class seats
        }
         else if(BusinessClass.isSelected() && Middle.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getSeattype().equals(Mid) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(BusinessClass.isSelected() && Aisle.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getSeattype().equals(Ais) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(BusinessClass.isSelected() && Window.isSelected()){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getSeattype().equals(Win) && owner.seats.get(s).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                }
            }
        }
         else if(EconomyClass.isSelected() && SeatsNextToEachOther.getText().equals(two)){
            for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==3 && owner.seats.get(s).getSeatclass().equals(Economy)){
                    if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s+1).getSeatclass().equals(Economy) && owner.seats.get(s+1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s+1);
                }
                }
                else if(owner.seats.get(s).getCol()==5 && owner.seats.get(s).getSeatclass().equals(Economy)){
                   if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Economy) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Economy) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                } 
                
                else if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Economy) && owner.seats.get(s-1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s-1);
                }
            }
            }
        }
         else if(EconomyClass.isSelected() && SeatsNextToEachOther.getText().equals(three)){
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==5 && owner.seats.get(s).getSeatclass().equals(Economy)){
                   if(owner.seats.get(s).getSeatclass().equals(Economy) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Economy) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Economy) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s-2);
                    addASeatAvailableSeatsTable(s-1);
                    addASeatAvailableSeatsTable(s);
                } 
            }
            }
        }
         else if(FirstClass.isSelected() && SeatsNextToEachOther.getText().equals(two)){
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getSeatclass().equals(First) && owner.seats.get(s).getCol()==0 && owner.seats.get(s).getAvailability() && owner.seats.get(s+1).getSeatclass().equals(First) && owner.seats.get(s+1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s+1);
                }
            }
        }
         else if(FirstClass.isSelected() && SeatsNextToEachOther.getText().equals(three)){
             //There are no seats that can meet these requirments. Do nothing.
        }
         else if(BusinessClass.isSelected() && SeatsNextToEachOther.getText().equals(two)){
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==0 && owner.seats.get(s).getSeatclass().equals(Business)){
                    if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s+1).getSeatclass().equals(Business) && owner.seats.get(s+1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s+1);
                }
                }
                else if(owner.seats.get(s).getCol()==2 && owner.seats.get(s).getSeatclass().equals(Business)){
                   if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Business) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Business) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                } 
                
                else if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Business) && owner.seats.get(s-1).getAvailability()){
                    addASeatAvailableSeatsTable(s);
                    addASeatAvailableSeatsTable(s-1);
                }
            }
            }
        }
         else if(BusinessClass.isSelected() && SeatsNextToEachOther.getText().equals(three)){
             for(int s=0;s<owner.seats.size();s++){
                if(owner.seats.get(s).getCol()==2 && owner.seats.get(s).getSeatclass().equals(Business)){
                   if(owner.seats.get(s).getSeatclass().equals(Business) && owner.seats.get(s).getAvailability() && owner.seats.get(s-1).getSeatclass().equals(Business) && owner.seats.get(s-1).getAvailability() && owner.seats.get(s-2).getSeatclass().equals(Business) && owner.seats.get(s-2).getAvailability()){
                    addASeatAvailableSeatsTable(s-2);
                    addASeatAvailableSeatsTable(s-1);
                    addASeatAvailableSeatsTable(s);
                } 
            }
            }        
        }
        
        if(model.getRowCount()==0){
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        AvailableSeatsTable = new javax.swing.JTable();
        DisplayAvailableSeats = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NoPreferences = new javax.swing.JToggleButton();
        FirstClass = new javax.swing.JToggleButton();
        BusinessClass = new javax.swing.JToggleButton();
        EconomyClass = new javax.swing.JToggleButton();
        Aisle = new javax.swing.JToggleButton();
        Middle = new javax.swing.JToggleButton();
        Window = new javax.swing.JToggleButton();
        SeatsNextToEachOther = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BookSeat = new javax.swing.JButton();
        EnterName = new javax.swing.JTextField();
        EnterAge = new javax.swing.JTextField();
        EnterSeatNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CreatePassword = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AvailableSeatsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        AvailableSeatsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(AvailableSeatsTable);

        DisplayAvailableSeats.setText("Display Available Seats");
        DisplayAvailableSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayAvailableSeatsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Choose Your Seat Prefrences Below");

        NoPreferences.setText("I Want to Book a Seat (No Preferences)");
        NoPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoPreferencesActionPerformed(evt);
            }
        });

        FirstClass.setText("I Want to Book a First Class Seat");
        FirstClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstClassActionPerformed(evt);
            }
        });

        BusinessClass.setText("I Want to Book a Business Class Seat");
        BusinessClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusinessClassActionPerformed(evt);
            }
        });

        EconomyClass.setText("I Want to Book an Economy Class Seat");
        EconomyClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EconomyClassActionPerformed(evt);
            }
        });

        Aisle.setText("I Want to Book an Aisle Seat");
        Aisle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AisleActionPerformed(evt);
            }
        });

        Middle.setText("I Want to Book a Middle Seat");
        Middle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiddleActionPerformed(evt);
            }
        });

        Window.setText("I Want to Book a Window Seat");
        Window.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowActionPerformed(evt);
            }
        });

        SeatsNextToEachOther.setText("Enter Number of Seats (2 or 3)");
        SeatsNextToEachOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeatsNextToEachOtherActionPerformed(evt);
            }
        });

        jLabel3.setText("I Want to Book Seats that are Next to Each Other (Same Row, Same Class, Touching Columns)");

        BookSeat.setText("Book This Seat ");
        BookSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookSeatActionPerformed(evt);
            }
        });

        EnterName.setText("   Enter Your Name");

        EnterAge.setText("    Enter Your Age");

        EnterSeatNumber.setText(" Enter Seat Number");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Enter the Required Information to Book a Seat");

        CreatePassword.setText(" Create Your Password Here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SeatsNextToEachOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(361, 361, 361)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(DisplayAvailableSeats)))
                        .addGap(0, 474, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoPreferences)
                            .addComponent(FirstClass)
                            .addComponent(BusinessClass)
                            .addComponent(EconomyClass)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Middle)
                                    .addComponent(Aisle)
                                    .addComponent(Window))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BookSeat, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(EnterName)
                                    .addComponent(EnterAge)
                                    .addComponent(EnterSeatNumber)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(CreatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DisplayAvailableSeats))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeatsNextToEachOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(NoPreferences)
                                .addGap(29, 29, 29)
                                .addComponent(FirstClass)
                                .addGap(28, 28, 28)
                                .addComponent(BusinessClass)
                                .addGap(26, 26, 26)
                                .addComponent(EconomyClass)
                                .addGap(29, 29, 29)
                                .addComponent(Aisle)
                                .addGap(28, 28, 28)
                                .addComponent(Middle)
                                .addGap(27, 27, 27)
                                .addComponent(Window))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(EnterSeatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EnterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EnterAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BookSeat)
                        .addGap(90, 90, 90))))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowActionPerformed
       String two = "2";
       String three = "3";
        if (SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three)){
            Window.setSelected(false);
        }
        NoPreferences.setSelected(false);
        Middle.setSelected(false);
        Aisle.setSelected(false);
    }//GEN-LAST:event_WindowActionPerformed

    private void FirstClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstClassActionPerformed
        NoPreferences.setSelected(false);
        EconomyClass.setSelected(false);
        BusinessClass.setSelected(false);
    }//GEN-LAST:event_FirstClassActionPerformed

    private void BusinessClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusinessClassActionPerformed
        NoPreferences.setSelected(false);
        EconomyClass.setSelected(false);
        FirstClass.setSelected(false);
    }//GEN-LAST:event_BusinessClassActionPerformed

    private void EconomyClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EconomyClassActionPerformed
        NoPreferences.setSelected(false);
        FirstClass.setSelected(false);
        BusinessClass.setSelected(false);
    }//GEN-LAST:event_EconomyClassActionPerformed

    private void AisleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AisleActionPerformed
       String two = "2";
       String three = "3";
        if (SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three)){
            Aisle.setSelected(false);
        }
        NoPreferences.setSelected(false);
        Middle.setSelected(false);
        Window.setSelected(false);
    }//GEN-LAST:event_AisleActionPerformed

    private void MiddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiddleActionPerformed
       String two = "2";
       String three = "3";
        if (SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three)){
            Middle.setSelected(false);
        }
       NoPreferences.setSelected(false);
       Window.setSelected(false);
       Aisle.setSelected(false);
    }//GEN-LAST:event_MiddleActionPerformed

    private void NoPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoPreferencesActionPerformed
        FirstClass.setSelected(false);
        EconomyClass.setSelected(false);
        BusinessClass.setSelected(false);
        Aisle.setSelected(false);
        Window.setSelected(false);
        Middle.setSelected(false);
    }//GEN-LAST:event_NoPreferencesActionPerformed

    private void SeatsNextToEachOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeatsNextToEachOtherActionPerformed
        Aisle.setSelected(false);
        Window.setSelected(false);
        Middle.setSelected(false);
        String two = "2";
        String three = "3";
        if (SeatsNextToEachOther.getText().equals(two) || SeatsNextToEachOther.getText().equals(three)){
            
        }
        else{
            SeatsNextToEachOther.setText("Error, you must enter 2 or 3");
        }
       
    }//GEN-LAST:event_SeatsNextToEachOtherActionPerformed

    private void DisplayAvailableSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayAvailableSeatsActionPerformed
        DisplayAvailableSeats();
        if(model.getRowCount()==0){
             Object[] row = {"There are","no seats", "/no available","seats that","match your", "preferences"};
                   model.addRow(row);
        }
        
        
    }//GEN-LAST:event_DisplayAvailableSeatsActionPerformed

    private void BookSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookSeatActionPerformed
        //System.out.println("pppppp"+owner);
        int x=0;
        if (  Integer.parseInt(EnterSeatNumber.getText())>=0 && Integer.parseInt(EnterSeatNumber.getText())<200 && owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getAvailability()  ){
        //Seat number is good
        x++;
    }
        else{
            //Seat number does not exist or is not available
           JOptionPane.showMessageDialog(null,"Seat number does not exist or is not available(seat has been booked)","Problem!",JOptionPane.INFORMATION_MESSAGE);
       }
        if(Integer.parseInt(EnterAge.getText())>0){
            //age is good
            x++;
        }
        if(Integer.parseInt(EnterAge.getText())<=0){
            JOptionPane.showMessageDialog(null,"Age must be greater than 0","Problem!",JOptionPane.INFORMATION_MESSAGE);
        }
       
        if(owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getAvailability()&& x==2){
           Booked_Seat newbookedseat = new Booked_Seat(owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getRow(),owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getCol(),owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getSeatclass(),owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getSeattype(),owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).getSeatIndexNumber(),EnterName.getText(),Integer.parseInt(EnterAge.getText()),CreatePassword.getText());
        owner.bookedseats.add(newbookedseat);
        owner.seats.get(Integer.parseInt(EnterSeatNumber.getText())).setAvailability(false);
           JOptionPane.showMessageDialog(null,"Seat has been successfully booked!","Done!",JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_BookSeatActionPerformed

     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AirplaneBookingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirplaneBookingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirplaneBookingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirplaneBookingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookASeat(null).setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Aisle;
    private javax.swing.JTable AvailableSeatsTable;
    private javax.swing.JButton BookSeat;
    private javax.swing.JToggleButton BusinessClass;
    private javax.swing.JTextField CreatePassword;
    private javax.swing.JButton DisplayAvailableSeats;
    private javax.swing.JToggleButton EconomyClass;
    private javax.swing.JTextField EnterAge;
    private javax.swing.JTextField EnterName;
    private javax.swing.JTextField EnterSeatNumber;
    private javax.swing.JToggleButton FirstClass;
    private javax.swing.JToggleButton Middle;
    private javax.swing.JToggleButton NoPreferences;
    private javax.swing.JTextField SeatsNextToEachOther;
    private javax.swing.JToggleButton Window;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
