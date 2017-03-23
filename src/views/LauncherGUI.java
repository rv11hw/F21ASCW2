package views;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LauncherGUI extends JFrame{
	//gui components
		private JTextField passengerGroups = new JTextField();
		private JTextField taxi = new JTextField();
		private JTextField sleepTime = new JTextField();
		private JButton startButton = new JButton("Start");
		
		public LauncherGUI()
		{	
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			//add update panel at the top (doesn't need to know about the clock object)
			add(BorderLayout.NORTH, createKioskSettingPanel());
			
			setSize(300,250);
			setVisible(true);
		}
		
		public JPanel createKioskSettingPanel()  {	
			JPanel setKioskPanel = new JPanel(new BorderLayout());	
			
			JPanel panel = new JPanel(new GridLayout(3,2));
			panel.add(new JLabel("Passenger Groups (>1)"));
			panel.add(passengerGroups);
			panel.add(new JLabel("Taxis (>1)"));
			panel.add(taxi);
			panel.add(new JLabel("Sleep (in milliseconds)"));
			panel.add(sleepTime);
			setKioskPanel.add(BorderLayout.CENTER, panel);
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(startButton);	

			setKioskPanel.add(BorderLayout.SOUTH, buttonPanel);
					
			return setKioskPanel;
		}
		
		//return contents of passenger text box
		public String getPassNumber() {
			return passengerGroups.getText();
		}
		
		//return contents of taxi text box
		public String getTaxiNumbers() {
			return taxi.getText();
		}
		
		public String getSleepTime() {
			return sleepTime.getText();
		}
		
		//add listener to update button
		public void addSetListener (ActionListener al) {
			startButton.addActionListener(al);			
		}
		

}
