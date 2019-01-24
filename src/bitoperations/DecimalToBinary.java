package bitoperations;

public class DecimalToBinary {

	public static String decimalToBinary(String num) {

		Integer intPart = Integer.parseInt(num.substring(0, num.indexOf('.')));
		Double decPart = Double.parseDouble(num.substring(num.indexOf('.'),
				num.length()));

		Integer m = intPart;

		StringBuffer strBuf = new StringBuffer();

		while (intPart != 0) {
			m = intPart % 2;
			intPart = intPart / 2;
			strBuf.append(m);
		}

		StringBuffer decStringBuffer = new StringBuffer();

		double r; 
		while (decPart > 0) {
			if (decStringBuffer.length() > 32)
				return "ERROR";

			if (decPart == 1) {
				decStringBuffer.append(1);
				break;
			}
			r = decPart * 2 ;
			if(r >=1 ){
				decStringBuffer.append(1);
				decPart = r - 1;
			}else{
				decStringBuffer.append(0);
				decPart = r;
			}
		}
		return strBuf.reverse().append('.').append(decStringBuffer).toString();

	}

	public static void main(String[] args) {

		System.out.println(decimalToBinary("372.590"));
		if (0.5 > 0)
			System.out.println("true");
		else
			System.out.println("false");
	}

}
