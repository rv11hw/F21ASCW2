package views;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LauncherGUI extends JFrame{
	//gui components
		private JTextField passengerGroups = new JTextField();
		private JTextField taxi = new JTextField();
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
			JPanel setClockPanel = new JPanel(new BorderLayout());	
			
			JPanel panel = new JPanel(new GridLayout(2,2));
			panel.add(new JLabel("Passenger Groups (0 - 5)"));
			panel.add(passengerGroups);
			panel.add(new JLabel("Taxis (0 - 5)"));
			panel.add(taxi);
			setClockPanel.add(BorderLayout.CENTER, panel);
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.add(startButton);	

			setClockPanel.add(BorderLayout.SOUTH, buttonPanel);
					
			return setClockPanel;
		}
		
		//return contents of passenger text box
		public String getPassNumber() {
			return passengerGroups.getText();
		}
		
		//return contents of taxi text box
		public String getTaxiNumbers() {
			return taxi.getText();
		}
		
		//add listener to update button
		public void addSetListener (ActionListener al) {
			startButton.addActionListener(al);			
		}
		

}
