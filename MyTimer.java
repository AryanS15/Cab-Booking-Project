import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class MyTimer {
	JFrame f;
    Timer timer;
    
    static JLabel l1,l2;

    public MyTimer(int seconds) {
        timer = new Timer();
       
	    
	    timer.schedule(new RemindTask(), seconds*1000);
	}
    
    public MyTimer(int time,int flag)
    {
    	try {
    	f= new JFrame("Trip");
    	 l1=new JLabel("Trip Started !");
 	    l1.setBounds(300,300,120,50);
    	f.add(l1);
    	
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    new MyTimer(time);
    	}
    	catch(Exception e)
    	{
    		
    	}
    }

 
	class RemindTask extends TimerTask {
       
        	 	 
	
		public void run() {
        l1.setText("Trip Finished !");
       
    	  
            timer.cancel(); //Terminate the timer thread

           
            
            
        }

    }

    public static void main(String args[]) {
    	
        new MyTimer(5,0);
        }
}
//no-static can access static variables
//static variables cannot access non-static members