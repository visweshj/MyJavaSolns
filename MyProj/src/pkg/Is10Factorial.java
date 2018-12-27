package pkg;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Is10Factorial {
	
	
	
		 
	    // A utility function that returns maximum of two integers
	     static int max(int a, int b) { return (a > b)? a : b; }
	      
	     // Returns the maximum value that can be put in a knapsack of capacity W
	     static int knapSack(int W, int wt[], int val[], int n)
	     {
	        // Base Case
	    if (n == 0 || W == 0)
	        return 0;
	      
	    // If weight of the nth item is more than Knapsack capacity W, then
	    // this item cannot be included in the optimal solution
	    if (wt[n-1] > W)
	       return knapSack(W, wt, val, n-1);
	      
	    // Return the maximum of two cases: 
	    // (1) nth item included 
	    // (2) not included
	    else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
	                     knapSack(W, wt, val, n-1)
	                      );
	      }

	     static int c=0;
	public static void main(String[] args) {
		/*java.util.Date dt =null;
		try {
			dt = new SimpleDateFormat("yyyy-mm-dd").parse("2016-01-15");
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			System.out.print(cal.get(cal.DAY_OF_MONTH)+"," +  cal.get(cal.MONTH));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	         LocalDate bDate = LocalDate.parse("2012-01-15", formatter);
	         System.out.print(" " + bDate.getDayOfMonth()+"," +  bDate.getMonthValue());
			
		} catch (ParseException e) {
			// TODO: handle exception
		}*/
		
		System.out.println(is10Fact(100100L));
		
	}
	
	private static boolean is10Fact(Long number){
		
		String numStr = number.toString();
		
		if(numStr.charAt(0)!='1') {
			return false;
		}
		
		Stream<String> numStream = Arrays.stream(numStr.substring(1).split("\n"));
		int sum=  numStream.parallel().map(str-> Integer.parseInt(str)).reduce(0,(a,b)->a+b);
		return sum==0;
		
	}

}

interface I2{
	String name ="434";
}
interface I3 extends I2{
	String name ="456";
	String s2 ="asd";
}
class C1 implements I3{
	public static void main(String[] args) {
		System.out.println(I3.name);
		System.out.println(I3.s2);
		System.out.println(((I2)new C1()).name);
	}
}

class ListDemo {
    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add(0,"3");
        list.add(1,"4");
        list.forEach(System.out::println);
    }
}