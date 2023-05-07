
package airplanebookingsystem;


public class Seat {
    protected boolean availability;
    private String seatclass;
    private String seattype;
    private int row;
    private int col;
    private int seatIndexNumber;
    
    
    public Seat(int row, int col, String seatclass, String seattype, int seatIndexNumber){
        availability = true;
        this.row = row;
        this.col = col;
        this.seatclass = seatclass;
        this.seattype = seattype;
        this.seatIndexNumber = seatIndexNumber;
    }
    
    public boolean getAvailability(){
        return availability;
    }
    
    public void setAvailability(boolean availability){
        this.availability = availability;
    }
    
    public String getSeatclass(){
        return seatclass;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public String getSeattype(){
        return seattype;
    }
    public int getSeatIndexNumber(){
        return seatIndexNumber;
    }
}
