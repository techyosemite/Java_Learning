package workbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadMyFileForDMG {

	public static void main(String[] args) {

		InputStream inp = null;
		try {
			// Change the path for Input File
			inp = new FileInputStream("/Users/karanratra/Input.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(inp));

		// Output File Name
		String filename = "/Users/karanratra/Desktop/Hello.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("TableDescription");

		System.out.println("Your excel file has been generated!");

		HSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell((short) 0).setCellValue("Table Name.");
		rowhead.createCell((short) 1).setCellValue("Column Description");

		int tableCount = 0;

		String str = null;
		int count = 0;
		String[] tempStringArray;
		String tableName;
		String[] columnStringArray;

		try {
			while ((str = reader.readLine()) != null) {
				tempStringArray = str.split(",");
				tableName = tempStringArray[0];
				count = Integer.parseInt(tempStringArray[1]);
				int tempCount = 0;
				String tempString;
				StringBuffer tableDesc = new StringBuffer();
				HSSFRow row = sheet.createRow((short) ++tableCount);
				row.createCell((short) 0).setCellValue(tableName);

				while (tempCount != count) {
					tempCount++;
					tempString = reader.readLine();
					columnStringArray = tempString.split("\\|");
					StringBuffer writeAbleStringBuf = new StringBuffer();
					for (int i = 0; i < 4; i++) {
						if (i == 1) {
							writeAbleStringBuf.append(columnStringArray[i]
									+ " (");
						} else if (i == 2) {
							writeAbleStringBuf.append(columnStringArray[i]
									+ ") ");
						} else if (i == 3) {
							if (columnStringArray[i].equals("N"))
								writeAbleStringBuf.append("NOT NULL");
							else
								writeAbleStringBuf.append("NULLABLE");
						} else {
							writeAbleStringBuf.append(columnStringArray[i]
									+ " ");
						}
					}
					writeAbleStringBuf.append("\n");
					tableDesc.append(writeAbleStringBuf);
				}
				row.createCell((short) 1).setCellValue(tableDesc.toString());
				reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
