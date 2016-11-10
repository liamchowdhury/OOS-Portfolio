package mvc;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.st20043420.assignment2.ImportCSV;

import mvc.models.*;
import mvc.views.*;
import mvc.controllers.*;

/**
 * @author Liam Chowdhury
 * 
 * <p>First of all, the Logger is initiated into the program</p>
 * 
 * @see #run() 
 * 
 * <p>First loads the CSV file stored in the source folder, then logs its activity,
 * whether it has been loaded successfully or not</p>
 *
 */

public class Main {
	
	final static Logger logger = Logger.getLogger("Main");
			
	public static void main(String[] args) {           
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { 
            	PropertyConfigurator.configure("log4j.properties");
            	logger.info("Application Started.");
            	try {
            		ImportCSV importCSV = new ImportCSV();
            		importCSV.readCSV("C://Users//Liam//Desktop//Object Oriented Systems//OOSAssignment2//src//DATAFILE.csv"); 
            		logger.info("CSV File Uploaded Successfully");
            	}catch(Exception e){
            		logger.error("CSV File not found");
            		JOptionPane.showMessageDialog(null, "CSV File not found.", "Failure", JOptionPane.INFORMATION_MESSAGE);
            	}
                
                
                Model model = new Model(0);
                View view = new View(""); 
                Controller controller = new Controller(model,view);
                controller.control();
            }
        });  
    }
}
