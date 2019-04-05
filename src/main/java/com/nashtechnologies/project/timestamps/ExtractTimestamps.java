package com.nashtechnologies.project.timestamps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.packet.Packet;

public class ExtractTimestamps implements IExtract {
	
	public ArrayList<String> getAllTimestamps(String file) throws FileNotFoundException, IOException {
		
		final Pcap pcap = Pcap.openStream(file);
		
		ArrayList<String> timestamps = new ArrayList<String>();

        pcap.loop(new PacketHandler() {
            @Override
            public boolean nextPacket(Packet packet) throws IOException {
           	 SimpleDateFormat formatted_date = new SimpleDateFormat("HH:mm:ss"); //can be adjusted
           	 Packet p = packet;
				 Date date = new Date(p.getArrivalTime() / 1000);
				 timestamps.add(formatted_date.format(date));
                return true;
            }
            
        });
		return timestamps;
	}

}
