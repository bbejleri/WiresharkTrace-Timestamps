package com.nashtechnologies.project.timestamps;

import java.io.File;
import java.io.FileWriter;
import static com.nashtechnologies.project.timestamps.Constants.*;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class ToCsv implements IExport{
	
    FileWriter fileWriter = null;
   
	@Override
	public void exportToCsv(ArrayList<String> timestamps) {
		
		//Creating the directory where the file will be saved		
		File file = new File(System.getProperty("user.home") + File.separator + "ExportedFiles");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created.");
            } else {
                System.out.println("Failed to create directory.");
            }
        }
		
		//Saving file in csv format
		try {
            File csv_file = new File(Constants.FILE_PATH, Constants.FILE_NAME);
			fileWriter = new FileWriter(csv_file);
            fileWriter.append(Constants.FILE_HEADER.toString());
                         
             for (int i = 0; i < timestamps.size(); i++) {
            	 fileWriter.append(Constants.NEW_LINE_SEPARATOR);
            	 fileWriter.append(timestamps.get(i));
            	
             }
             System.out.println("CSV file created.");
             
         }catch (Exception e) {
         System.out.println("An Error has occurred.");
         e.printStackTrace();
         }finally {
         
         try {
            fileWriter.flush();
            fileWriter.close();
         } catch (IOException e) {
            System.out.println("An Error has occurred while flushing/closing.");
            e.printStackTrace();
         }
		
	}
  }
}
