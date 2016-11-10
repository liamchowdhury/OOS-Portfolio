package org.st20043420.assignment2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.jfree.data.xy.XYDataset;

public class ImportCSV {
	final static Logger logger = Logger.getLogger("ImportCSV");
	
	public static List<Double> gps_x = new ArrayList<>();
	public static List<Double> gps_y = new ArrayList<>();
	public static List<Double> euler_phi = new ArrayList<>();
	public static List<Double> euler_psi = new ArrayList<>();
	public static List<Double> euler_theta = new ArrayList<>();
	public static List<Double> acc_forward = new ArrayList<>();
	public static List<Double> acc_sideways = new ArrayList<>();
	public static List<Double> acc_up = new ArrayList<>();
	public static List<Double> gyr1 = new ArrayList<>();
	public static List<Double> gyr2 = new ArrayList<>();
	public static List<Double> gyr3 = new ArrayList<>();
	public static List<Double> mag_forward = new ArrayList<>();
	public static List<Double> mag_sideways = new ArrayList<>();
	public static List<Double> mag_up = new ArrayList<>();
	public static List<Double> music_track = new ArrayList<>();
	
	//Read in CSV file to save the readings.
	public void readCSV(String filepath){
		try {
			Scanner scanner = new Scanner(new FileReader(filepath));
			String line;
			ReadingVariables csvreadings;
			
			scanner.nextLine();
			while (scanner.hasNextLine()){
				line = scanner.nextLine();
				String[] reading = line.split(",");
				
				double gps_xReading = Double.parseDouble( reading[0] );
				double gps_yReading = Double.parseDouble( reading[1] );
				double euler_phiReading = Double.parseDouble( reading[2] );
				double euler_psiReading = Double.parseDouble( reading[3] );
				double euler_thetaReading = Double.parseDouble( reading[4] );
				double acc_forwardReading = Double.parseDouble( reading[5] );
				double acc_sidewaysReading = Double.parseDouble( reading[6] );
				double acc_upReading = Double.parseDouble( reading[7] );
				double gyr1Reading = Double.parseDouble( reading[8] );
				double gyr2Reading = Double.parseDouble( reading[9] );
				double gyr3Reading = Double.parseDouble( reading[10] );
				double mag_forwardReading = Double.parseDouble( reading[11] );
				double mag_sidewaysReading = Double.parseDouble( reading[12] );
				double mag_upReading = Double.parseDouble( reading[13] );
				double music_trackReading = Double.parseDouble( reading[14] );
				
				gps_x.add(gps_xReading);
				gps_y.add(gps_yReading);
				euler_phi.add(euler_phiReading);
				euler_psi.add(euler_psiReading);
				euler_theta.add(euler_thetaReading);
				acc_forward.add(acc_forwardReading);
				acc_sideways.add(acc_sidewaysReading);
				acc_up.add(acc_upReading);
				gyr1.add(gyr1Reading);
				gyr2.add(gyr2Reading);
				gyr3.add(gyr3Reading);
				mag_forward.add(mag_forwardReading);
				mag_sideways.add(mag_sidewaysReading);
				mag_up.add(mag_upReading);
				music_track.add(music_trackReading);
				
				logger.info("CSV File has been imported into their arrays.");
			}
						
		} catch (Exception e) {
			logger.error("CSV File could not be imported into arrays.");
		}
		
	}
}
