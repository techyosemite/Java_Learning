package arrays;

public class MedianArrays {

	public static void findMedian(int[] arr1, int[] arr2) {

		if (arr1 == null || arr2 == null)
			return;
		int i, j, k;

		i = j = 0;
		k = -1;

		int length = arr1.length + arr2.length;

		if (length % 2 == 0) {
			int m1, m2;
			m1 = m2 = 0;
			int index = length /2 ;
			while (i <= arr1.length - 1  && j <= arr2.length - 1 && k!=index) {
				if (arr1[i] < arr2[j]) {

					m1 = m2;
					m2 = arr1[i];
					i++;

				} else {
					m1 = m2;
					m2 = arr1[j];
					j++;
					
				}
				k++;
			}
			if(i >= arr1.length){
				while(k != index){
					m1 = m2;
					m2 = arr2[j];
					k++;
				}
			}else{
				while(k!= index){
					m1=m2;
					m2= arr1[i];
					k++;
				}
			}
			System.out.println("Median is ::" + (float)(m1 + m2)/2 );

		} else {

		}
	}

	public static void main(String[] args) {

		int[] arr1 = { 1, 3, 5 , 6};

		int[] arr2 = { 7, 8, 9, 10 };
		
		findMedian(arr1, arr2);

	}

}
