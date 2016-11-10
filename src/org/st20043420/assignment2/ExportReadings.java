package org.st20043420.assignment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class ExportReadings {
	final static Logger logger = Logger.getLogger("ExportReadings");
	public static void exportData(int n){
		
		int upTo = n+500;
		int from = n;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();	
			PrintWriter writer = new PrintWriter(dateFormat.format(date) + " Readings.txt", "UTF-8");
			writer.write("GPS_X" + "	|	" + "GPS_Y" + "		|	" + "Euler_phi" + "		|	" + "Euler_psi" + "		|	" + "Euler_theta" + "	|	" + "Acc_forward" + "	|	" + "Acc_sideways" + "	|	" + "Acc_up" + "	|	" + "Gyro 1" + "	|	" + "Gyro 2" + "	|	" + "Gyro 3" + "	|	" + "Mag_forward" + "	|	" + "Mag_sideways" + "	|	" + "Mag_up" + "	|	" + "Music_Track" + "\r\n");
			for (int i = from; i < upTo; i++){
				writer.write(ImportCSV.gps_x.get(i) + "	|	" + ImportCSV.gps_y.get(i) + "	|	" + ImportCSV.euler_phi.get(i) + "	|	" + ImportCSV.euler_psi.get(i) + "	|	" + ImportCSV.euler_theta.get(i) + "	|	" + ImportCSV.acc_forward.get(i) + "	|	" + ImportCSV.acc_sideways.get(i) + "	|	" + ImportCSV.acc_up.get(i) + "	|	" + ImportCSV.gyr1.get(i) + "	|	" + ImportCSV.gyr2.get(i) + "	|	" + ImportCSV.gyr3.get(i) + "	|	" + ImportCSV.mag_forward.get(i) + "	|	" + ImportCSV.mag_sideways.get(i) + "	|	" + ImportCSV.mag_up.get(i) + "	|	" + ImportCSV.music_track.get(i) + "\r\n");
			}
			JOptionPane.showMessageDialog(null, "Data has been exported...", "Success", JOptionPane.INFORMATION_MESSAGE);
			logger.info("Data on screen has been exported.");
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(null, "Changed data could not be exported...", "Failure", JOptionPane.INFORMATION_MESSAGE);
			logger.error("Data could not be exported to text file.");
		}
	}
}
