package org.st20043420.assignment2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import mvc.models.Model;
import mvc.views.View;

class Surface extends JPanel implements ActionListener {

    private final int DELAY = 150;
    private Timer timer;
    public int n = 0;

    public Surface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public Timer getTimer() {
        
        return timer;
    }
    
    public void DataSlider(int n){
		int dataValue = n;
    }

    private void doDrawing(Graphics g, int n) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);
        
        ImportCSV importCSV = new ImportCSV();

        int w = getWidth();
        int h = getHeight();
        
        int time = 0;
 	   	int upTo = n+500;
 	   	int from = n;

        for(int i = 0; i < 2000; i++) {
     	   Double gps_x = importCSV.gps_x.get(i);
     	   Double gps_y = importCSV.gps_y.get(i);
     	   
     	   int x = Math.abs(gps_x.intValue()) % w;
     	   int y = Math.abs(gps_y.intValue()) % h;
     	   g2d.drawLine(x, y, x, y);
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g, n);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class GPSPanel extends JFrame {

    public GPSPanel() {

        initUI();
    }

    private void initUI() {
    	final Surface surface = new Surface();
        
    	surface.setSize(500, 400);
    	surface.setLocation(102, 30);
    	surface.setBackground(Color.white);
 	   	View.frame.getContentPane().add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(350, 250);
        setLocationRelativeTo(null);
    }
}