package officeprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

class SimpleDateFormatWrapper extends SimpleDateFormat {

	private static final long serialVersionUID = 6685188603600065264L;

	private static final String DEFAULT_PATTERN = "dd/MM/yyyy HH:mm:ss";

	private final static String ORACLE_DATE_FORMAT = "DD/MM/YYYY HH24:MI:SS";

	public SimpleDateFormatWrapper() {
		super(DEFAULT_PATTERN);
	}

	public SimpleDateFormatWrapper(String pattern) {
		super(pattern);
	}

	@Override
	public synchronized Date parse(String source) throws ParseException {
		return super.parse(source);
	}

	public static String getDbDateFormat() {
		return ORACLE_DATE_FORMAT;
	}
}

public class FileReadInChunks {

	public static void main(String[] args) {

		char[] myBuffer = new char[512];
		String str[] = new String[5];
		int bytesRead = 0;

		try {
			/*
			 * BufferedReader in = new BufferedReader( new FileReader(
			 * "/home/karan/Desktop/TestNumbers.txt" ));
			 * 
			 * while ((bytesRead = in.read(myBuffer, 0, 512)) != -1) {
			 * 
			 * System.out.println("OPWEOPOER" + myBuffer[0]);
			 * System.out.println(myBuffer.toString()); }
			 */

			FileInputStream in = new FileInputStream(
					"/Users/karanratra/Desktop/TestNumbers.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String tmp;
			Random random = new Random();
			
			String strLine[] = new String[2];
			int count = 0;
			String[] fileNames = new String[5];
			int fileCount = 0;
			while ((tmp = br.readLine()) != null) {
				strLine[count] = tmp;
				count++;
				if (count == 2) {
				
					count = 0;
					
					int[] arr = new int[2];
					
					for (int i = 0; i < 2; i++) {
						arr[i] = Integer.parseInt(strLine[i]);
						strLine[i] = null;
					}

					Arrays.sort(arr);

					String absoluteFileName = "/Users/karanratra/Desktop/OuputFileDirectories/"
							+ "file_" + random.nextInt();

					fileNames[fileCount++] = absoluteFileName;

					BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(absoluteFileName)));
					
					for (int j = 0; j < 2; j++) {

						
						bufWriter.write(Integer.toString(arr[j])+"\n");
					}
					bufWriter.close();

				}
			}
			in.close();
			
			for(String fileName:fileNames){
				System.out.println(fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
