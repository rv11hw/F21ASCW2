package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import interfaces.Observer;
import logger.Log;
import model.TaxiStationModel;

public class KioskGUI extends JFrame implements Observer {

	JTextArea window1TextArea;
	JTextArea window2TextArea;
	TaxiStationModel model;
	
	int sleepTime;
	
	Log log;

	public KioskGUI(TaxiStationModel model) {

		this.model = model;
		model.registerObserver(this);
		
		sleepTime = 2000;

		setTitle("Taxi Station - Kiosk");
		setSize(20, 50);

		JPanel jsp1 = new JPanel();
		JPanel jsp2 = new JPanel();

		JLabel j1 = new JLabel("WINDOW 1");
		JLabel j2 = new JLabel("WINDOW 2");
		j1.setForeground(Color.BLUE);
		j2.setForeground(Color.BLUE);
		jsp1.add(j1);
		jsp2.add(j2);

		window1TextArea = new JTextArea(20, 50);
		window1TextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		window1TextArea.setEditable(false);

		window2TextArea = new JTextArea(20, 50);
		window2TextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		window2TextArea.setEditable(false);

		jsp1.add(window1TextArea);
		jsp2.add(window2TextArea);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jsp1, jsp2);
		splitPane.setDividerSize(20);
		splitPane.setDividerLocation(400);
		splitPane.setOneTouchExpandable(true);
		getContentPane().add(splitPane);

		this.pack();

	}
	
	public void setSleepTime(int sleepTime){
		this.sleepTime = sleepTime;
	}
	
	public int getSleepTime(){
		return sleepTime;
	}


	public synchronized void update() {
		try {
			Thread.sleep(getSleepTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		if (model.getWindowVal().equals("W1")) {
			window1TextArea.setText(model.getWin1Queue());
		} else {
			window2TextArea.setText(model.getWin2Queue());			
		}
		repaint();
	}
}