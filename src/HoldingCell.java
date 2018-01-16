
import java.util.ArrayList;

public class HoldingCell {
    static int cellnumber = 1;
    int capacity;
    ArrayList<Prisoner> inmates = new ArrayList<>();


    public HoldingCell(int capacity) {
        this.capacity = capacity;
    }

    public boolean addInmate(Prisoner prisoner){
        if(capacity < inmates.size()){
            inmates.add(prisoner);
        }else{
            return false;
        }
        return true;
    }

    public String inmatesInCell(){
        String result = "";
        result = "there are " + inmates.size() + "in the cell you can add " + (capacity-inmates.size()) + "more in the cell";
        return result;
    }
}
