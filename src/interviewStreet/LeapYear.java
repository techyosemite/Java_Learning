package interviewStreet;

public class LeapYear {

	
	public static void isLeapYear(int year){
		
		boolean isLeapYear = (year % 100 == 0) ? (year % 400 == 0) : (year % 4 == 0);
		if( (year%400==0 || year%100!=0) &&(year%4==0))
//		if(isLeapYear)
		    System.out.println("Year :: " + year + " is a leap year" );
		else
			System.out.println("Year :: " + year + " is not a leap year" );
		
	}
	
	public static void main(String[] args) {
		
		for(int i=2000 ; i < 2050; i++)
			isLeapYear(i);
	}
}
