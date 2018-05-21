package com.smh;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
public class Upload extends JWindow{
	
	
	Dimension dim;
    JLabel image;
    JLabel title;
    JLabel load;
    JLabel process;
    public Upload(String stitle)
    {
		try
		{
    //	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
    	
    	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	
    	dim  = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	title = new JLabel("Smart Home System");
      //  title.setForeground(Color.red);
        title.setForeground(new Color(86,3,25));
        title.setFont(new Font("calibri", Font.BOLD,16));
        title.setBounds(65,3,200,50);
        this.add(title); 
    	this.setLayout(null);
    	
    	image=new JLabel(new ImageIcon("smart-home.jpg"));
        image.setBounds(20,40,250,130);
        image.setBorder(BorderFactory.createLineBorder(Color.gray,2,true));
        this.add(image);
        
        process=new JLabel(new ImageIcon("loadcha.GIF"));
        process.setBounds(50,180,200,100);
       this.add(process);
        
	    load = new JLabel(""+stitle+"...");
        load.setForeground(new Color(22,34,34));
        load.setFont(new Font("calibri", Font.BOLD,14));
        load.setBounds(80,240,150,40);
    //    this.add(load);
        
        this.setAlwaysOnTop(true);
        this.setSize(300,300);
      	this.setLocationRelativeTo(null);
      	this.setBackground(Color.gray);
      	this.show(true);
        
        	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public static void main(String a[])
    {
    	new Upload("Train");
    }
    
  
	
	
	
}