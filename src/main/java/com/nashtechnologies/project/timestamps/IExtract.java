package com.nashtechnologies.project.timestamps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IExtract {
	
	public ArrayList<?> getAllTimestamps(String pcap_file) throws FileNotFoundException, IOException;

}
