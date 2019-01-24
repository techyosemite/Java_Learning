package officeprograms;

public class SwapNumbers {
	public static void main(String[] args) {
		
		int count = 0 ;
		char temp ;
		char []arr = "010101011".toCharArray();
		for(int i = 0 ; i< arr.length -1 ; i++){
			if((int)arr[i] > (int)arr[i+1] ){
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				count++;
				for(int k = i; k>=1; k--){
					if((int)arr[k] < (int)arr[k-1]){
						temp = arr[k];
						arr[k] = arr[k-1];
						arr[k -1 ] = temp;
						count++;
					}
				}
			}
		}
		System.out.println(arr);
		for(int i =0 ; i< arr.length ; i++){
			System.out.println(arr[i]);
		}
		System.out.println("count is :: " + count);
	}

}
