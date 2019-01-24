package objectCreation;

import java.util.Date;

public class LazyIntializationClass {

	private static  Date startDate ;
	private static   Date endDate;
	public void initialize(){
		startDate = new Date();
	}
	public static void main(String[] args) throws Throwable {
		LazyIntializationClass obj  = new LazyIntializationClass();
		obj.finalize();
	}

}
