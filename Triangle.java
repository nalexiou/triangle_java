import java.util.ArrayList;
import java.util.Collections;
import java.math.*;

public class MyMainClassAlt {
        
        BigDecimal a = null;
        BigDecimal b = null;
        BigDecimal c = null;
        String righttriangle = "No";
        String mymessage = "";


        public MyMainClassAlt(String firstSide, String secondSide, String thirdSide )   {
        
                if (firstSide.isEmpty()) {
                        mymessage = "First side is empty";
                        return;
                }
                
                if (secondSide.isEmpty()) {
                        mymessage = "Second side is empty";
                        return;
                }
                
                if (thirdSide.isEmpty()) {
                        mymessage = "Third side is empty";
                        return;
                }
                
                try {
                 a = new BigDecimal(firstSide);
                 b = new BigDecimal(secondSide);
                 c = new BigDecimal(thirdSide);
                }
                 
                    catch (NumberFormatException e) {
                        if (a==null){
                                                mymessage = "First side contains non-numeric characters";
                                                return;
                        }
                        else if (b==null){
                                mymessage = "Second side contains non-numeric characters";
                                
                                return;
                        }
                        
                        else {
                                mymessage = "Third side contains non-numeric characters";
                                return;
                        }
                    }            
        }
        
    public boolean inputsEqual(BigDecimal x,  BigDecimal y){
        BigDecimal precision = new BigDecimal("0.0001");

        if (!(y.subtract(x).divide(y,40, RoundingMode.HALF_UP).setScale(4, RoundingMode.HALF_UP).compareTo(precision)==1)){
                return true;
        }
        else {
                return false;
        }
    }
        
        public String processSides(){
                
          if (!mymessage.isEmpty()) {
                  return mymessage;
          }
           
           BigDecimal zero = new BigDecimal("0.0");
           
           if (! (a.compareTo(zero)==1)){
                   
                        return "First side must be greater than 0";


           }
           
           if (! (b.compareTo(zero)==1)){
                   
                   return "Second side must be greater than 0";
           }
           
           if (! (c.compareTo(zero)==1)){
                   
                   return "Third side must be greater than 0";
           }
        
            //create arraylist to hold the valid tags
            ArrayList<BigDecimal> numberarray = new ArrayList<BigDecimal>();
            numberarray.add(a);
            numberarray.add(b);
            numberarray.add(c);
        
            Collections.sort(numberarray);
            
            
            if (! (numberarray.get(0).add(numberarray.get(1)).compareTo(numberarray.get(2)) == 1) ){
                                        return "Invalid triangle";
            }
            
           // if (numberarray.get(0).equals(numberarray.get(1)) && numberarray.get(0).equals(numberarray.get(2))){
                if (inputsEqual(numberarray.get(0),numberarray.get(1)) && inputsEqual(numberarray.get(0),numberarray.get(2))){
         
                                return "Equilateral triangle";
            }
            
            
            //MathContext mc = new MathContext(4);
            BigDecimal one = new BigDecimal("1.00");

            BigDecimal rightanglecheck = (((numberarray.get(0).divide(numberarray.get(2),40, RoundingMode.HALF_UP)).pow(2).add((numberarray.get(1).divide(numberarray.get(2),40, RoundingMode.HALF_UP)).pow(2)))).setScale(3,RoundingMode.HALF_UP);
            //System.out.println(rightanglecheck);
            if (rightanglecheck.compareTo(one) == 0){
         righttriangle = "Yes";
            }
            
            
            if (inputsEqual(numberarray.get(0),numberarray.get(1))) {
                 if (righttriangle.equals("Yes")) {
                        return "Isosceles right triangle";
                 }
                 else {
                         return "Isosceles triangle";
                 }
            }
            
            else {

                 if (righttriangle.equals("Yes")) {
                        return "Scalene right triangle";
                 }
                 else {
                         return "Scalene triangle";
                 }
            } 

        }
        
        public static void main(String[] args) {
                
        /**
         * @param args
         * @author Nikolaos Alexiou
         */
                if (args.length < 1) {
                        System.out.println("First side is empty");
                        return;
                }
                
                if (args.length < 2) {
                        System.out.println("Second side is empty");
                        return;
                }
                
                if (args.length < 3) {
                        System.out.println("Third side is empty");
                        return;
                }
                
                MyMainClassAlt myClass = new MyMainClassAlt(args[0],args[1], args[2]);
                System.out.println(myClass.processSides());
                
        }
}
        

