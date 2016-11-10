package org.st20043420.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mvc.views.View;

import org.jfree.ui.ApplicationFrame;

/**
 * 
 * @author Liam Chowdhury
 * 
 * <p>Instead of using a graph to represent the music, I created multiple labels to display the 
 * amount of times the song occurs throughout the data selected. As there are 9 tracks throughout
 * the dataset used, nine labels were created.</p>
 * 
 * <p>Collection.frequency is used to count how many times a certain song will appear,
 * which is then added into a temporary variable, then called into the labels</p>
 *
 */

public class MusicPanel extends ApplicationFrame{
	
	private JLabel musicLabel;
	private JLabel oneLabel;
	private JLabel twoLabel;
	private JLabel threeLabel;
	private JLabel fourLabel;
	private JLabel fiveLabel;
	private JLabel sixLabel;
	private JLabel sevenLabel;
	private JLabel eightLabel;
	private JLabel nineLabel;
	public MusicPanel(String title, int n) {
		super(title);
		musicLabel = new JLabel("Music Played:", SwingConstants.CENTER);
		musicLabel.setSize(500, 20);
		musicLabel.setLocation(102, 555);
		View.frame.getContentPane().add(musicLabel);
		
		int upTo = n+500;
		int from = n;
			
		ArrayList<Double> musicArray = new ArrayList<>(ImportCSV.music_track.subList(from, upTo));
		
		int one = Collections.frequency(musicArray, 1);
		int two = Collections.frequency(musicArray, 2);
		int three = Collections.frequency(musicArray, 3);
		int four = Collections.frequency(musicArray, 4);
		int five = Collections.frequency(musicArray, 5);
		int six = Collections.frequency(musicArray, 6);
		int seven = Collections.frequency(musicArray, 7);
		int eight = Collections.frequency(musicArray, 8);
		int nine = Collections.frequency(musicArray, 9);
		
		oneLabel = new JLabel("Track 1 : " + one, SwingConstants.CENTER); 	//Creates the label
		oneLabel.setSize(100, 20);											//Size of the label is set
		oneLabel.setLocation(112, 585);										//Where the labe will be placed
		View.frame.getContentPane().add(oneLabel);							//Label is added to the main frame of the program.
		
		twoLabel = new JLabel("Track 2 : " + two, SwingConstants.CENTER);
		twoLabel.setSize(100, 20);
		twoLabel.setLocation(180, 585);
		View.frame.getContentPane().add(twoLabel);
		
		threeLabel = new JLabel("Track 3 : " + three, SwingConstants.CENTER);
		threeLabel.setSize(100, 20);
		threeLabel.setLocation(248, 585);
		View.frame.getContentPane().add(threeLabel);
		
		fourLabel = new JLabel("Track 4 : " + four, SwingConstants.CENTER);
		fourLabel.setSize(100, 20);
		fourLabel.setLocation(316, 585);
		View.frame.getContentPane().add(fourLabel);
		
		fiveLabel = new JLabel("Track 5 : " + five, SwingConstants.CENTER);
		fiveLabel.setSize(100, 20);
		fiveLabel.setLocation(384, 585);
		View.frame.getContentPane().add(fiveLabel);
		
		sixLabel = new JLabel("Track 6 : " + six, SwingConstants.CENTER);
		sixLabel.setSize(100, 20);
		sixLabel.setLocation(452, 585);
		View.frame.getContentPane().add(sixLabel);
		
		sevenLabel = new JLabel("Track 7 : " + seven, SwingConstants.CENTER);
		sevenLabel.setSize(100, 20);
		sevenLabel.setLocation(210, 605);
		View.frame.getContentPane().add(sevenLabel);
		
		eightLabel = new JLabel("Track 8 : " + eight, SwingConstants.CENTER);
		eightLabel.setSize(100, 20);
		eightLabel.setLocation(280, 605);
		View.frame.getContentPane().add(eightLabel);
		
		nineLabel = new JLabel("Track 9 : " + nine, SwingConstants.CENTER);
		nineLabel.setSize(100, 20);
		nineLabel.setLocation(348, 605);
		View.frame.getContentPane().add(nineLabel);
	}
}
