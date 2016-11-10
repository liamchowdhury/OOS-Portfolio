package org.st20043420.assignment2;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.FileReader;
import java.util.Scanner;

import mvc.views.View;

import org.apache.log4j.Logger;
import org.jfree.chart.*;
import org.jfree.ui.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.*;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * 
 * @author Liam Chowdhury
 * 
 * <p>AccPanel contain the JFreeChart to create a line graph from the dataset provided in the ArrayLists.
 * AccPanel's qualities such as height and colours are kept the same as every line chart within the program to keep the consistency.</p>
 * 
 *
 */

@SuppressWarnings("serial")
public class AccPanel extends ApplicationFrame {
	
	public AccPanel(String title) {
	   super(title);
	   int n = 0;
	   XYDataset dataset = createDataset(n);
	   JFreeChart chart = createChart(dataset);
	   ChartPanel chartPanel = new ChartPanel(chart);
	   chartPanel.setSize(480, 150);
	   chartPanel.setLocation(620, 190);
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
   @SuppressWarnings({"static-access"})
   public static XYDataset createDataset(int n){
	   XYSeries acc_for = new XYSeries("Forward");
	   XYSeries acc_side = new XYSeries("Sideways");
	   XYSeries acc_up = new XYSeries("Up");
	   
	   /**
	    * <p>The variable time is set to 0, and represents the Time axis on the line graph.
	    * upTo is the maximum amount of indexes of arrays the user can view on the chart.
	    * form is the minimum value the user can view in the chart.</p>
	    */
	   
	   int time = 0;
	   int upTo = n+500;
	   int from = n;
		
	   for (int i = from; i < upTo; i++) {
		   time = i;
		   acc_for.add(time, ImportCSV.acc_forward.get(i));
	   }
		
	   for (int i = from; i < upTo; i++) {
		   time = i;
		   acc_side.add(time, ImportCSV.acc_sideways.get(i));
	   }
		
	   for (int i = from; i < upTo; i++) {
		   time = i;
		   acc_up.add(time, ImportCSV.acc_up.get(i));
	   }
		
	   XYSeriesCollection dataset = new XYSeriesCollection();
	   dataset.addSeries(acc_for);
	   dataset.addSeries(acc_side);
	   dataset.addSeries(acc_up);
		
	   return dataset;	   
   }
   
   /**
    * @see #JFreeChart <p>enables the look and settings of the chart</p>
    * 
    */
   
   private static JFreeChart createChart (XYDataset dataset){
	   //create the chart
	   JFreeChart chart = ChartFactory.createXYLineChart(
			   "Accelerometer",					//chart title 
			   "Time(s)",						//domain axis label 
			   "Acceleration (g)",				//range axis label
			   dataset,							//data
			   PlotOrientation.VERTICAL,		//orientation
			   false,							//include legend
			   true,							//tooltips
			   false							//urls
		);
	   	
	   chart.setBackgroundPaint(Color.white);
	   
	   return chart;
	   
   }
}
