package mvc.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.st20043420.assignment2.*;

/**
 * 
 * @author Liam Chowdhury
 * 
 * <p>This class presents all JPanels created with the graphs and data.
 * Enabling the user to view all data at the same time.</p>
 * 
 * <p>The buttons and data slider are also created in this class,
 * allowing everything to be more centralised:</p>
 * 
 * @see #exportData
 * @see #screenshot
 * 
 * <p>This class also defines the look of the overall programme.</p>
 * 
 * @see #View(String)
 * 
 * <p>To allow the View class to access other classes, I first imported the packages that they
 * are involved in;</p>
 * <list>
 * 	<ul>mvc</ul>
 * 	<ul>mvc.controllers</ul>
 * 	<ul>mvc.models</ul>
 * 	<ul>org.st20043420.assignment2</ul>
 * </list>
 * 
 *
 */

public class View {
	
	final static Logger logger = Logger.getLogger("View");
	private GPSPanel GPSGraph;
	private GyroPanel GyroGraph;
	private AccPanel AccGraph;
	private MagPanel MagGraph;
	private EulPanel EulGraph;
	private MusicPanel MusicLabel;
	public static JButton exportData;
	public static JButton screenshot;
	public static JFrame frame;
	public View(String text){
        frame = new JFrame("Liam"); //Window Name                               
        frame.getContentPane().setLayout(null);                                              
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(1180,700);
        frame.setFocusable(false);
        frame.setResizable(false);
        frame.setVisible(true);    
        frame.setLocationRelativeTo(null);
        
        GPSGraph = new GPSPanel();
        GyroGraph = new GyroPanel(null);
        AccGraph = new AccPanel(null);
        MagGraph = new MagPanel(null);
        EulGraph = new EulPanel(null);  
        MusicLabel = new MusicPanel(null, 0);
        
      //##########################################################
        
        final JSlider slider = new JSlider(500, 6000, 500); //Initiates the JSlider
        slider.setSize(500, 50);
        slider.setLocation(102, 450);
        slider.addChangeListener(new ChangeListener() {
            @Override
            /**
             * @see #stateChanged <p>Transfers the variable of the data slider variable to the class to change the datasets.</p>
             * 
             * <p>.repaint allows the graphs to be refreshed with the new dataset that has been changed</p>
             */
            public void stateChanged(ChangeEvent e) {
                GyroPanel.createDataset(((JSlider) slider).getValue());
                AccPanel.createDataset(((JSlider) slider).getValue());
                EulPanel.createDataset(((JSlider) slider).getValue());
                MagPanel.createDataset(((JSlider) slider).getValue());
                
                GyroGraph.repaint();
                AccGraph.repaint();
                EulGraph.repaint();
                MagGraph.repaint();
            }
        });
        frame.add(slider);		//Adds the data slider to the application
        
        //##########################################################
        
       	exportData = new JButton("Export Data"); //Initiates the JButton for Export Data.
        exportData.setSize(200, 50);
        exportData.setLocation(102, 500);
        exportData.addActionListener(new ActionListener(){
        	@Override
        	/**
        	 * @see #actionPerformed <p>Accesses the @see #ExportReadings to transfer the 
        	 * variable from the data slider to print the correct dataset to the text file</p>
        	 */
			public void actionPerformed(ActionEvent e) {
				ExportReadings.exportData(slider.getValue());
			}
        });
        frame.getContentPane().add(exportData); //Adds the Export Data button to the application.
        
        //##########################################################
        
        screenshot = new JButton("Take Screenshot"); //Initiates the JButton for Take Screenshot.
        screenshot.setSize(200, 50);
        screenshot.setLocation(400, 500);
        screenshot.addActionListener(new ActionListener(){
        	/**
        	 * @See actionPerformed <p>Creates the screenshot of the application
        	 * then saves the image as a PNG to the source folder, with the date</p>
        	 */
        	public void actionPerformed(ActionEvent arg0) {
        		BufferedImage generatedImage;
				try {
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date date = new Date();					
					generatedImage = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(generatedImage, "png", new File(dateFormat.format(date) + " Screenshot.png"));
					JOptionPane.showMessageDialog(null, "Screenshot has been taken...", "Success", JOptionPane.INFORMATION_MESSAGE);
					logger.info("Screenshot successfully saved.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Screenshot aborted...", "Failure", JOptionPane.INFORMATION_MESSAGE);
					logger.error("Screenshot failed.");
				}
			}
        });
        frame.getContentPane().add(screenshot);
        
      //##########################################################
    }
}
   
