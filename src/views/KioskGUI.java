package views;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.TaxiStationModel;
 
public class KioskGUI extends JFrame {
     
    public KioskGUI(TaxiStationModel model) {
         
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
         
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jsp1, jsp2);
        splitPane.setDividerSize(15);
        splitPane.setDividerLocation(200);
        splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);
   
    }
}