package com.nashtechnologies.project.timestamps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        
    	ArrayList<String> t = new ArrayList<String>();
    	
    	ExtractTimestamps newInstance = new ExtractTimestamps();  
    	t = newInstance.getAllTimestamps("trace.pcap");
    	
    	
        ToCsv tc = new ToCsv();
        tc.exportToCsv(t);
   
    
  }
}

