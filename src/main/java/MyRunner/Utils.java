package MyRunner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.SecureRandom;

public class Utils {


	/**
	 * This function is to delete directory.
	 */
	public static void makeDirectory(String directoryName) {

		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}
	public static String getUserHomePath() {
		String path = null;
		try {
			path = System.getProperty("user.dir");
			if (path.contains("target")) {
				path = path.replace("/target", "");
			}
		} catch (Throwable e) {
		
		}
		return path;
	}
	 
	public static void fileWriter(String fileName,String fileContent) 
	{
		try {
			String path=getUserHomePath()+"/PNR";	 
			makeDirectory(path);
			FileWriter fileWriter = new FileWriter(path+"/"+fileName+".txt");
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String fileReader(String fileName) 
	{
		String temp="";
		try {
			String path=getUserHomePath()+"/PNR";	 
			FileReader reader=new FileReader(new File(path+"/"+fileName+".txt"));

			int i;    
			while((i=reader.read())!=-1)   
				temp=temp+(char)i;
			reader.close();   

			System.out.println(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public static  String getRandomNumber(int length) {

		String NUMBER = "123456789";
		String DATA_FOR_RANDOM_STRING =  NUMBER;
		SecureRandom random = new SecureRandom();

		if (length < 1) throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			// 0-62 (exclusive), random returns 0-61
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

			sb.append(rndChar);
		}

		return sb.toString();

	}

}
