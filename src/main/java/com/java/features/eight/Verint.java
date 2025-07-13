package com.java.features.eight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Verint {
    public static void main(String[] args) {
      List<String> inpStrList = new ArrayList<String>();
        inpStrList.add("9-10");
        inpStrList.add("11-12");
        inpStrList.add("14-16");
        inpStrList.add("16-18");

        List<String> continiousShifts = getContiniousWorkingHours(inpStrList);

        Iterator<String> itr = continiousShifts.iterator();

        while(itr.hasNext()){
            System.out.print(itr.next()+"  : ");
        }
    }
// [9-11],[11-12],[14-16],[16-18]   1 1 1 1 0 1 1 1 1 1
    public static List<String> getContiniousWorkingHours(List<String> shifts){
        List<String> retList = new ArrayList<String>();
        Iterator<String> shiftIterator = shifts.iterator();
        String lastShiftEndTime = "";
        while( shiftIterator.hasNext()){
            String temp = shiftIterator.next();
            String[] shiftDetails = temp.split("-");
            String shiftStartTime = shiftDetails[0];
            String ShiftEndTime = shiftDetails[1];
             if(Integer.parseInt(shiftStartTime) == Integer.parseInt(lastShiftEndTime)) {
                 retList.add(temp);
                 lastShiftEndTime = ShiftEndTime;
             } else{
                System.out.println("There was a Time Gap");
            }
        }
        return retList;
    }
}
