package matrix;

public class SpiralMatrixPrinting {

	public static void spiralPrinting(int m, int n, int[][] arr) {

		int i, k = 0, l = 0;

		while (k < m && l < n) {

			for (i = l; i < n; ++i) {
				System.out.println(arr[k][i]);
			}
			k++;

			for (i = k; i < m; ++i) {
				System.out.println(arr[i][n - 1]);
			}
			n--;

			if (k < m) {
				for (i = n - 1; i >= l; --i)
					System.out.println(arr[m - 1][i]);
				m--;
			}

			if (l < n) {
				for (i = m - 1; i >= k; --i)
					System.out.println(arr[i][l]);
				l++;
			}

		}
	}

	public static void spiralPrint(int m, int n, int a[][])
	{
	    int i, k = 0, l = 0;
	 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
	 
	    while (k < m && l < n)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < n; ++i)
	        {
	            System.out.println(a[k][i]);
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < m; ++i)
	        {
	            System.out.println(a[i][n-1]);
	        }
	        n--;
	 
	        /* Print the last row from the remaining rows */
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	                System.out.println(a[m-1][i]);
	            }
	            m--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	               System.out.println(a[i][l]);
	            }
	            l++;    
	        }        
	    }
	}
	public static void main(String[] args) {

		int a[][] = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		spiralPrinting(3, 6, a);
	}
}
