
package airplanebookingsystem;

import java.util.ArrayList;

public class Booked_Seat extends Seat{
    
    private String name;
    private int age;
    private String password;
    
    public Booked_Seat(int row, int col, String seatclass, String seattype, int seatIndexNumber, String name, int age, String password){
        super(row,col,seatclass,seattype,seatIndexNumber);
        this.name=name;
        this.age=age;
        this.password=password;
        availability = false;
        //super.setAvailability(false);
        ArrayList<Seat> temp = new AirplaneBookingSystem().getArrayListseats();
        temp.get(seatIndexNumber).setAvailability(false);
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getPassword(){
        return password;
    }
    
    @Override
    public int getSeatIndexNumber(){
        return super.getSeatIndexNumber();
    }
    
    
    
    
}
