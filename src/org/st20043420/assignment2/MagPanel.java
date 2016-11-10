package org.st20043420.assignment2;

import java.awt.Color;
import java.awt.GridBagLayout;

import mvc.views.View;

import org.jfree.chart.*;
import org.jfree.ui.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * 
 * @author Liam Chowdhury
 * 
 * <p>MagPanel contain the JFreeChart to create a line graph from the dataset provided in the ArrayLists.
 * MagPanel's qualities such as height and colours are kept the same as every line chart within the program to keep the consistency.</p>
 * 
 *
 */

@SuppressWarnings("serial")
public class MagPanel extends ApplicationFrame {
   public MagPanel(String title) {
	   super(title);
	   int n = 0;
	   XYDataset dataset = createDataset(n);
	   JFreeChart chart = createChart(dataset);
	   ChartPanel chartPanel = new ChartPanel(chart);
	   chartPanel.setSize(480, 150);
	   chartPanel.setLocation(620, 350);
	   chartPanel.setBackground(Color.red);
	   chartPanel.setLayout(new GridBagLayout());
	   View.frame.getContentPane().add(chartPanel);
   }
   
   /**
	 * <p>XYSeries are first created enable what series of data will be presented on the graph.
	 * A for loop is then used to go through the ArrayLists and apply them to the XYSeries.
	 * The XYSeries' created are then added to the dataset created with the XYSeriesCollection.</p>
	 * @param n
	 * @return
	 */
   @SuppressWarnings("static-access")
   public static XYDataset createDataset(int n){
	   XYSeries forward = new XYSeries("X");
	   XYSeries side = new XYSeries("Y");
	   XYSeries up = new XYSeries("Z");
	   
	   int time = 0;
	   int upTo = n+500;
	   int from = n;
		
	   for (int i = from; i < upTo; i++) {
		   time = i;
		   forward.add(time, ImportCSV.mag_forward.get(i));
	   }
		
	   for (int i = from; i < upTo; i++) {
		   time = i;
		   side.add(time, ImportCSV.mag_sideways.get(i));
	   }
		
	   for (int i = from; i < upTo; i++) {
		   time = i;
		   up.add(time, ImportCSV.mag_up.get(i));
	   }
		
	   XYSeriesCollection dataset = new XYSeriesCollection();
	   dataset.addSeries(forward);
	   dataset.addSeries(side);
	   dataset.addSeries(up);
		
	   return dataset;
   }
   
   /**
	 * 
	 *  @see #JFreeChart <p>enables the look and settings of the chart</p>
	 * 
	 */
   
   private static JFreeChart createChart (XYDataset dataset){
	   //create the chart
	   JFreeChart chart = ChartFactory.createXYLineChart(
			   "Magnetometer",					//chart title 
			   "Time(s)",						//domain axis label 
			   "Flux (G)",				//range axis label
			   dataset,							//data
			   PlotOrientation.VERTICAL,		//orientation
			   false,							//include legend
			   true,							//tooltips
			   false							//urls
		);
	   	
	   return chart;
	   
   }
}
