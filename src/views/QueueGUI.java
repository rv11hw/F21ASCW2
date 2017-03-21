package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.Observer;
import model.TaxiStationModel;
 
public class QueueGUI extends JFrame implements Observer {
	
	JTextArea passengerList;
	JTextArea taxiList;
	
	TaxiStationModel model;
     
    public QueueGUI(TaxiStationModel model) {
    	
    	this.model = model;
    	model.registerObserver(this);
         
        setTitle("Taxi Station - Queue");
        setSize(450, 350);
         
        JPanel jsp1 = new JPanel();
        JPanel passList = new JPanel();
        JPanel jsp2 = new JPanel();
        
        
        JLabel j1 = new JLabel("Passengers List");
        j1.setForeground(Color.BLUE);
        passList.add(j1, BorderLayout.NORTH);
        
        passengerList = new JTextArea(20, 40);
        passengerList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        passengerList.setText("Sample text\n");
        passengerList.setEditable(false);
        
        passList.add(passengerList,BorderLayout.CENTER);
        
        JLabel j2 = new JLabel("Taxi List");
        
        taxiList = new JTextArea(20, 90);
        taxiList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        taxiList.setEditable(false);
        
        
        j2.setForeground(Color.BLUE);
        
        jsp1.add(passList);
        jsp2.add(j2);
        jsp2.add(taxiList);
         
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true, jsp1, jsp2);
        
        splitPane.setDividerSize(15);
        splitPane.setDividerLocation(200);
        splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);
        
        this.pack();
    }
    public void update()
	{
    	passengerList.setText(model.getPassengerQueue());
    	taxiList.setText(model.getTaxiQueue());
    	repaint();
	}
  
}