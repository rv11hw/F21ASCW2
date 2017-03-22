package views;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import interfaces.Observer;
import model.KioskWindow;
import model.TaxiStationModel;
 
public class KioskGUI extends JFrame implements Observer  {
	
	
	JTextArea window1TextArea;
	JTextArea window2TextArea;
	TaxiStationModel model;
	KioskWindow model2;
	
	public KioskGUI(){
		
	}
	
    public KioskGUI(TaxiStationModel model) {
    	
    	this.model = model;
    	model2 = new KioskWindow();
    	//model.registerObserver(this);
    	model2.registerObserver(this);
         
        setTitle("Taxi Station - Kiosk");
        setSize(450, 350);
         
        JPanel jsp1 = new JPanel();
        JPanel jsp2 = new JPanel();
        
        JLabel j1 = new JLabel("WINDOW 1");
        JLabel j2 = new JLabel("WINDOW 2");
        j1.setForeground(Color.BLUE);
        j2.setForeground(Color.BLUE);
        jsp1.add(j1);
        jsp2.add(j2);
         
       
        
        window1TextArea = new JTextArea(20, 90);
        window1TextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        window1TextArea.setEditable(false);
        
        window2TextArea = new JTextArea(20, 90);
        window2TextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        window2TextArea.setEditable(false);
        
        jsp1.add(window1TextArea);
        jsp2.add(window2TextArea);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jsp1, jsp2);
        splitPane.setDividerSize(15);
        splitPane.setDividerLocation(200);
        splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);
        
        this.pack();
   
    }
    public void update(){
    	
    }
    public void update(String worker)
	{
    	if(worker.equals("W1")){
    		System.out.println("w1");
    		//window1TextArea.setText(window1TextArea.getText()+"\n"+model2.getwindow1Str());
    	} else{
    		System.out.println("w2");
    		//window2TextArea.setText(window2TextArea.getText()+"\n"+model2.getwindow2Str());
    	}    	
    	repaint();
	}
}