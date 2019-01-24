package fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileReadLineByLine {

	public static String separator = " ";

	public static int getMaximumNumberOfPeaks(int[][] matrix, int sortedArray,
			int rows, int columns) {

		int[][] lookupMatrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				lookupMatrix[i][j] = getAvailablePaths(matrix, lookupMatrix, i, j);
			}
		}

		return 0;
	}

	//Recursion logic 
	public static int getAvailablePaths(int[][] matrix, int [][] lookupMatrix, int i, int j) {

		
		while()
		
		return 0;
	}

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("/Users/karanratra/Desktop/input.txt");

		BufferedReader br = new BufferedReader(fr);

		FileWriter fw = new FileWriter("/Users/karanratra/Desktop/Output.txt");

		BufferedWriter bw = new BufferedWriter(fw);

		String str = null;

		int testCase = 0;
		if ((str = br.readLine()) != null)
			testCase = Integer.parseInt(str);

		String testCaseString = null;

		int lineCount;

		for (int i = 0; i < testCase; i++) {

			testCaseString = br.readLine();

			lineCount = 0;

			String[] tempArr = testCaseString.split(separator);

			int rowCount = Integer.parseInt(tempArr[1]);

			int columnCount = Integer.parseInt(tempArr[2]);

			int[][] matrix = new int[rowCount][columnCount];

			int[] numberArray = new int[rowCount * columnCount];

			int index = 0;

			int tempRowCount = 0;

			while (lineCount != rowCount && (str = br.readLine()) != null) {

				lineCount++;

				String[] temStringArray = str.split(separator);

				for (int j = 0; j < temStringArray.length; j++) {
					int value = Integer.parseInt(temStringArray[j]);
					matrix[tempRowCount][j] = value;
					numberArray[index++] = value;
				}
				tempRowCount++;
			}
			Arrays.sort(numberArray);

			// Call method to get the longest run and pass the matrix to
			// calculate

			// Write the longest path in the output file
			fw.write(tempArr[0] + "--  KARAN\n");

			System.out.println("Matrix " + i);
			for (int row = 0; row < rowCount; row++) {
				for (int column = 0; column < columnCount; column++) {
					System.out.print(matrix[row][column]);
				}
				System.out.println("\n");
			}

			str = null;
		}

		br.close();
		fr.close();
		bw.close();
		fw.close();

	}
}