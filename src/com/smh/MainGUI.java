package com.smh;


import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;


public class MainGUI extends JFrame{
	
	
	Toolkit tk;
	Dimension dim;
	Container con;
	JPanel scr_pan;
	JLabel Img_lab,title;
	JPanel btnPanel;
	
	
	JFileChooser chooser;
	String path=null;
	File data=null;
	File datatest=null;
	
	
	JButton button1,button2,button3,button4, button5, button6, button7;
	
	
	 CardLayout ctl;
	 JProgressBar progress;
	 
	 
	 Connection conn;
	 Statement stmt,stmt1,stmt2;
	 
	 int totcount=0;
	
	
	
	
	
	public MainGUI()
	{
		
		
		try{
		
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	     	 
	       	 dim=Toolkit.getDefaultToolkit().getScreenSize();
	       	 
	    	 con=this.getContentPane();
	    	 	
	     	 this.setTitle("Diabetic Testing System");
	     	 
	     	 con.setLayout(null);
	     	 
	     	 
	     	 conn=DB.getConnection();
	     	 
	     	 stmt = conn.createStatement();
	     	 
	     	 stmt1 = conn.createStatement();
	     	 
	     	stmt2 = conn.createStatement();
	     	 
	     	 
	     	 
	     	 
	     	stmt.executeUpdate("delete from smarthome.input");
	     	 stmt.executeUpdate("delete from smarthome.preprocess");
	     	 stmt.executeUpdate("delete from smarthome.activity");
	     	 stmt.executeUpdate("delete from smarthome.grouped");
	     	 stmt.executeUpdate("delete from smarthome.appliances");
	     	stmt.executeUpdate("delete from smarthome.activityprediction");
	     	stmt.executeUpdate("delete from smarthome.activitygrouped");
	     	stmt.executeUpdate("delete from smarthome.finalprediction");
	     	
	     	
	     	
	     	
	     	stmt.executeUpdate("delete from smarthome.inputtest");
	     	 stmt.executeUpdate("delete from smarthome.preprocesstest");
	     	 stmt.executeUpdate("delete from smarthome.activitytest");
	     	 stmt.executeUpdate("delete from smarthome.groupedtest");
	     //	 stmt.executeUpdate("delete from smarthome.appliancestest");
	     	stmt.executeUpdate("delete from smarthome.activitypredictiontest");
	     	stmt.executeUpdate("delete from smarthome.activitygroupedtest");
	     	stmt.executeUpdate("delete from smarthome.finalpredictiontest");
	     	
	     	 
	    // 	 con.setBackground(new Color(255,250,250));
	     	 
	     	 this.setSize(dim.width,dim.height);
	     	 
	     	 
	     	
	     	 
	     	 
	     	 
	     	 scr_pan=new JPanel();
	     	 scr_pan.setBounds(0,0,dim.width,100);
	     	 scr_pan.setBackground(Color.BLACK);
	     	 con.add(scr_pan);
	     	 
	     	 

	     	 Img_lab =new JLabel(new ImageIcon("image1.jpg"));
	     	 Img_lab.setBounds(0,0,1360,131);
	     	 Img_lab.setBackground(Color.BLACK);
	     	 Img_lab.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,2));
	      	 scr_pan.add(Img_lab);
	     	 
	     	 
	     	 
	      	title = new JLabel("SMART HOME ENVIROINMENT FOR HEALTHCARE MONITORING",SwingConstants.CENTER);
			 title.setFont(new Font("Monotype Corsiva",Font.BOLD,28));
		 	 title.setBounds(200,25,900,55);
		     title.setForeground(new Color(255,255,255));
			 Img_lab.add(title);
	     	 
	     	 
	     	 
			 btnPanel=new JPanel();
			 btnPanel.setBounds(0,100,200,700);
			 btnPanel.setBackground(new Color(255,250,250));
			 btnPanel.setLayout(null);
	     	 con.add(btnPanel);
	     	 
	     	 
	     	 
	     	 button1=new JButton("UPLOAD");
			 button1.setBounds(20,30,150,35);
		//	 button1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
			 button1.setFont(new Font("Georgia",Font.BOLD,12));
			 btnPanel.add(button1);

			 button2=new JButton("PREPROCESS");
			 button2.setBounds(20,100,150,35);
		//	 button2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
			 button2.setFont(new Font("Georgia",Font.BOLD,12));
			 btnPanel.add(button2);
			 
			 
			 button3=new JButton("APPLIANCES");
			 button3.setBounds(20,170,150,35);
		//	 button3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
			 button3.setFont(new Font("Georgia",Font.BOLD,12));
			 btnPanel.add(button3);
			 
			 
			 button4=new JButton("GROUPING");
			 button4.setBounds(20,250,150,35);
		//	 button4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Georgia",Font.BOLD,15),Color.black));
			 button4.setFont(new Font("Georgia",Font.BOLD,12));
		//	 button4.setVisible(false);
			 btnPanel.add(button4);
			 
			 
			 button5=new JButton("PREDICTION");
			 button5.setBounds(20,320,150,35);
		//	 button3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
			 button5.setFont(new Font("Georgia",Font.BOLD,12));
			 btnPanel.add(button5);  
			 
			 
			 button6=new JButton("TESTING");
			 button6.setBounds(20,390,150,35);
		//	 button6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
			 button6.setFont(new Font("Georgia",Font.BOLD,12));
			 btnPanel.add(button6);
			 
			 
			 button7 = new JButton("FIND BEHAVIOUR");
			 button7.setBounds(10,460,170,35);
				//	 button6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
					 button7.setFont(new Font("Georgia",Font.BOLD,12));
					 btnPanel.add(button7);
			 
			 
			 
			 
	/*		 button6=new JButton("TESTING");
			 button6.setBounds(20,390,150,35);
		//	 button3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"",1,2,new Font("Verdana",Font.BOLD,15),Color.black));
			 button6.setFont(new Font("Georgia",Font.BOLD,12));
	//		 btnPanel.add(button6);  */
			 
			 
			 
			 	 progress=new JProgressBar();
				 progress.setBounds(10,550,180,40);
				 progress.setFont(new Font("verdana",Font.BOLD,19));
				 btnPanel.add(progress);
				
	     	 
	     	 
		/*	 proPanel = new JPanel();
			 proPanel.setBounds(200,100,dim.width-200,dim.height-100);
			 proPanel.setBackground(new Color(255,250,250));   */
				 
				 
				 
				 final JTabbedPane	proPanel = new JTabbedPane();
			proPanel.setBounds(200,100,dim.width-200,dim.height-100);
		  	con.add("Dataset",proPanel);
			
	     	 con.add(proPanel);
	     	 
	  //   	 ctl = new CardLayout();
	     	 
	  //   	 proPanel.setLayout(ctl);
	     	 
		
	     	 this.show();
	     	 
	     	 
	     	 
	     	 
	     	 
	     	 
	     	 button1.addActionListener(new ActionListener()
	     	 {
	     		 public void actionPerformed(ActionEvent ae)
	     		 
	     		 {
	     			 
	     			 try
	     			 {
	     			
	     				data =  select_File();
	     				 
	   
	     				
	     				Thread t = new Thread()
	     				{
	     					
	     					
	     				public void run()
	     				{
	     					
	     				
	     				try{
	     					
	     				
	     					
	     					
	     					progress.setString("Upload Datasets...");
	            			progress.setIndeterminate(true);
	     					
	     					
	     					
	    					
	    					
	    				
	    					
	    					if(data!=null){
           	    				FileInputStream input=new FileInputStream(data);
                        		byte[] b=new byte[input.available()];
                        		input.read(b);
                        		input.close();
                        		
                        		String content=new String (b);
                        		
                        		System.out.println("check "+content);
                        		
                        		String acon[]=content.split("\n");
                        		
                        	//	System.out.println(acon[1]);
                        		
                        	//	s1 = con1.createStatement();
                        		
                        		System.out.println(" First data "+acon[0]);
                        		
                        		String var[] = acon[0].split(",");
                        		
                        	//	stmt = con1.createStatement();
                        		
                        		
                        		
                        		
                        	
                        		
                        		for(int i=0;i<acon.length;i++)
                        		{
                        			String val[] = acon[i].split(",");
                        	//		String nrval = val[1].replaceAll(";"," ");
                        			
                        	//		System.out.println("nrval check :"+nrval);
                        			
                        			
                        			stmt.executeUpdate("insert into input values('"+val[0]+"','"+val[1]+"','"+val[2]+"','"+val[3]+"','"+val[4]+"','"+val[5]+"','"+val[6]+"','"+val[7]+"','"+val[8]+"','"+val[9]+"','"+val[10]+"','"+val[11]+"','"+val[12]+"','"+val[13]+"','"+val[14]+"','"+val[15]+"','"+val[16]+"','"+val[17]+"')");
                        			
                        		//	va.add(val[i]);
                        			
                        		}
                        		
                        		
                        		
                        		JPanel tableHold = new JPanel(); 
    	    					tableHold.setName("Input");
    	    					tableHold.setLayout(null); 
    	    					
    	    					
    	    					DefaultTableModel tablemod = new DefaultTableModel();
    	    					JTable table = new JTable(tablemod); 
    	    					table.setEnabled(false);
    	    					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	    					
    	    					JScrollPane jsp = new JScrollPane(table); 
    	    					jsp.setName("jsp");
    	    					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Uploaded DataSet",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
    	    					jsp.setBounds(5,5,dim.width-220,dim.height-170);
    	    					jsp.setBackground(new Color(86,3,25));
    	    					
    	    					tableHold.add(jsp);
    	    					
    	    					proPanel.add(tableHold.getName(),tableHold);
    	    					
    	    			//		ctl.show(proPanel,tableHold.getName());
                        		
                        		
                        		
                        		
                    			ResultSet rst=stmt.executeQuery("select * from smarthome.input");
                                ResultSetMetaData meta=rst.getMetaData();
                                for(int i=1;i<=meta.getColumnCount();i++)
                                {
                                 Object column=(Object)meta.getColumnName(i);
                                 tablemod.addColumn(column);
                                }
                        		
                                
                                while(rst.next())
                                {
                                	Vector v=new Vector();
                                	v.add(rst.getString(1));v.add(rst.getString(2));v.add(rst.getString(3));v.add(rst.getString(4));v.add(rst.getString(5));v.add(rst.getString(6));v.add(rst.getString(7));v.add(rst.getString(8));
                                	v.add(rst.getString(9));v.add(rst.getString(10));v.add(rst.getString(11));v.add(rst.getString(12));v.add(rst.getString(13));v.add(rst.getString(14));v.add(rst.getString(15));v.add(rst.getString(16));
                                	v.add(rst.getString(17));v.add(rst.getString(18));
                                	tablemod.addRow(v); 
                                }
                        		
                        		
                        		
                        	
                        		
                        		
                        		progress.setIndeterminate(false);
            					
            					progress.setString("Upload completed...");
	    					
                        		
                       // 		up.setVisible(false);
	    					}
	     				}
	     				
	     				catch(Exception ex)
	     				{
	     					ex.printStackTrace();
	     				}
	     				
	     				
	     				}
	     				
	     				};
	     				t.start();
	     				
	     				
	     				
	     			 }
	     			 catch(Exception ex)
	     			 {
	     				 ex.printStackTrace();
	     			 }
	     			 
	     		 }
	     		 
	     	 }
	     			 
	     			 
	     			 
	     			 );
	     	 
	     	 
	     	 
	     	 button2.addActionListener(new ActionListener()
	     	 {
	     			public void actionPerformed(ActionEvent ae)
	     	 {
	     		 
	     	 
	     				Thread t = new Thread()
	     				{
	     					
	     					public void run()
	     					{
	     						
	     					try{
	     						
	     						
	     						progress.setString("Upload Datasets...");
		            			progress.setIndeterminate(true);
	     						
	     						
	     						
	     						
	     						ResultSet trs=stmt.executeQuery("select * from smarthome.input");
		        	    		   	ResultSetMetaData metadata=trs.getMetaData();
		        	    		   	
		        	    		   	System.out.println(" Count"+metadata.getColumnCount());
		        	    		   	
		        	    		   	
		        	    		    while(trs.next())
	  	        	    			{
	  	        	    				 boolean flag=false;
	  	         	    		   	     for(int i=1; i<=metadata.getColumnCount(); i++)
	  	         	    		   	    {
	  	         	    		   	    	if((trs.getString(i))==null || (trs.getString(i)).isEmpty()){
	  	         	    		   	    		
	  	         	    		   	   
	  	         	    		   	    		flag=true;
	  	         	    		   	    	 break;
	  	         	    		   	    	 }

	  	         	    		   	    	
	  	         	    		   	    }
	  	         	    		   	     
	  	         	    		   	 if(flag == false)
	         	    		   	     {
	         	    		   	    	 String item1 = trs.getString(1);
	         	    		   	    	 String item2 = trs.getString(2);
	         	    		   	    	 String item3 = trs.getString(3);
	         	    		   	    	 String item4 = trs.getString(4);
	         	    		   	    	 String item5 = trs.getString(5);
	         	    		   	    	 String item6 = trs.getString(6);
	         	    		   	    	 String item7 = trs.getString(7);
	         	    		   	    	 String item8 = trs.getString(8);
	         	    		   	    	 String item9 = trs.getString(9);
	         	    		   	    	 String item10 = trs.getString(10);
	         	    		   	    	 String item11 = trs.getString(11);
	         	    		   	    	 String item12 = trs.getString(12);
	         	    		   	    	 String item13 = trs.getString(13);
	         	    		   	    	 String item14 = trs.getString(14);
	         	    		   	    	 String item15 = trs.getString(15);
	         	    		   	    	 String item16 = trs.getString(16);
	         	    		   	    	 String item17 = trs.getString(17);
	         	    		   	    	 String item18 = trs.getString(18);
	         	    		   	    	 
	         	    		   	    	 
	         	    		   	    	stmt1.executeUpdate("insert into smarthome.preprocess values('"+item1+"','"+item2+"','"+item3+"','"+item4+"','"+item5+"','"+item6+"','"+item7+"','"+item8+"','"+item9+"','"+item10+"','"+item11+"','"+item12+"','"+item13+"','"+item14+"','"+item15+"','"+item16+"','"+item17+"','"+item18+"')");
	         	    		   	     }
	  									
	  								}
	  	        	    		  
		        	    		   	
		        	    		   	
		        	    		   	
		        	    		   	
		        	    		   	
	     						
	     					
	     					JPanel tableHold = new JPanel(); 
	    					tableHold.setName("Preprocess");
	    					tableHold.setLayout(null); 
	    					
	    					
	    					DefaultTableModel tablemod = new DefaultTableModel();
	    					JTable table = new JTable(tablemod); 
	    					table.setEnabled(false);
	    					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    					
	    					JScrollPane jsp = new JScrollPane(table); 
	    					jsp.setName("jsp");
	    					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"preprocess dataset",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    					jsp.setBounds(5,5,dim.width-220,dim.height-170);
	    					jsp.setBackground(new Color(86,3,25));
	    					
	    					tableHold.add(jsp);
	    					
	    					proPanel.add(tableHold.getName(),tableHold);
	    					
	    				//	ctl.show(proPanel,tableHold.getName());
	    					
	    					
	    						ResultSet rst=stmt.executeQuery("select * from smarthome.preprocess");
	                            ResultSetMetaData meta=rst.getMetaData();
	                            for(int i=1;i<=meta.getColumnCount();i++)
	                            {
	                             Object column=(Object)meta.getColumnName(i);
	                             tablemod.addColumn(column);
	                             
	                            }
	                            
	                            System.out.println(" Checking vector");
	                            
	                            while(rst.next())
	                            {
	                            	Vector v3=new Vector();
	                            	v3.add(rst.getString(1));v3.add(rst.getString(2));v3.add(rst.getString(3));v3.add(rst.getString(4));v3.add(rst.getString(5));v3.add(rst.getString(6));v3.add(rst.getString(7));v3.add(rst.getString(8));
                                	v3.add(rst.getString(9));v3.add(rst.getString(10));v3.add(rst.getString(11));v3.add(rst.getString(12));v3.add(rst.getString(13));v3.add(rst.getString(14));v3.add(rst.getString(15));v3.add(rst.getString(16));
                                	v3.add(rst.getString(17));v3.add(rst.getString(18));
	                            	tablemod.addRow(v3); 
	                            }
	        	    			
	               	    	
	                            System.out.println(" Checking vector after");
	                           
	                            
	                            JOptionPane.showMessageDialog(null,"Pre-Processed successfully","Message",1);
	    					
	                            progress.setIndeterminate(false);
            					
            					progress.setString("Upload completed...");
	    					
	    					
	     					}
	    					
	    					catch(Exception ex)
	    					{
	    						ex.printStackTrace();
	    					}
	     					
	     				}
	     					
	     					
	     				};
	     				t.start();
	     			 
	     			 
	     			 
	     			 
	     	 }		 
	     			 
	     	 } );
	     	 
	     	 
	     	button3.addActionListener(new ActionListener()  
	     	{
	     			
	     			public void actionPerformed(ActionEvent ae)
	     	{
	     			
	     				
	     				progress.setString("Activity Datasets...");
            			progress.setIndeterminate(true);
 						
 						
 				try
 				{
 						
 						ResultSet trs=stmt.executeQuery("select * from smarthome.preprocess");
        	    		   	ResultSetMetaData metadata=trs.getMetaData();
        	    		   	
        	    		   	System.out.println(" Count"+metadata.getColumnCount());
        	    		   	
        	    		   	
        	    		   	ArrayList<String> all = new ArrayList<String>();
        	    		   	
        	    		   	for(int i=1; i<=metadata.getColumnCount();i++)
        	    		   	{
        	    		   		System.out.println(" Column Name:"+metadata.getColumnName(i));
        	    		   		
        	    		   		all.add(metadata.getColumnName(i));
        	    		   		
        	    		   		
        	    		   	}
        	    		   	
        	    		   	
        	    		   	JPanel tableHold = new JPanel(); 
	    					tableHold.setName("Appliances");
	    					tableHold.setLayout(null); 
	    					
	    					
	    					DefaultTableModel tablemod = new DefaultTableModel();
	    					JTable table = new JTable(tablemod); 
	    					table.setEnabled(false);
	    					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    				//	table.setRowHeight(40);
	    					
	    					JScrollPane jsp = new JScrollPane(table); 
	    					jsp.setName("jsp");
	    					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Appliances",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    					jsp.setBounds(5,5,dim.width-220,dim.height-170);
	    					jsp.setBackground(new Color(86,3,25));
	    					
	    					tableHold.add(jsp);
	    					
	    					proPanel.add(tableHold.getName(),tableHold);
	    					
	    					
	    					
	    					
	    					
	    					tablemod.addColumn("Identity");
	    					tablemod.addColumn("Appliances");
	    					
	    					
	    					
	    			//		Object[] colums = {"Identity","Appliances"};
	    			//		tablemod.addColumn(colums);
	    					
	    					table.setBackground(Color.decode("#F5F5F5"));
	    				    table.setFont(new Font("Lucida Sans", 1, 12));
	    				    table.setForeground(Color.decode("#002E63"));
	    					
	    				    int count = 0;
	    				    for(int j=3; j<all.size();j++)
	    				    {
	    				    	
	    				    	count++;
	    				    	Vector v=new Vector();
	    				    	v.add(count);
	    				    	v.add(all.get(j));
	    				    	tablemod.addRow(v); 
	    				    	
	    				    	stmt.executeUpdate("insert into appliances values('"+v.get(0)+"','"+v.get(1)+"')");
	    				    	
	    				    	
	    				    }
	    				    
	    				    
	    				    
	    				    
	    				    
	    				    
	    					JPanel tableHold1 = new JPanel(); 
	    					tableHold1.setName("Activity");
	    					tableHold1.setLayout(null); 
	    					
	    					
	    					DefaultTableModel tablemod1 = new DefaultTableModel();
	    					JTable table1 = new JTable(tablemod1); 
	    					table1.setEnabled(false);
	    					table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    				//	table1.setRowHeight(15);
	    					
	    					JScrollPane jsp1 = new JScrollPane(table1); 
	    					jsp1.setName("jsp");
	    					jsp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Activity Appliance",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    					jsp1.setBounds(5,5,dim.width-220,dim.height-170);
	    					jsp1.setBackground(new Color(86,3,25));
	    					
	    					tableHold1.add(jsp1);
	    					
	    					proPanel.add(tableHold1.getName(),tableHold1);
	    					
	    					tablemod1.addColumn("Date");
	    					tablemod1.addColumn("Staring Time");
	    					tablemod1.addColumn("Ending Time");
	    					tablemod1.addColumn("Activity Appliance");
	    					
	    					
	    					
	    					table1.setBackground(Color.decode("#F5F5F5"));
	    				    table1.setFont(new Font("Lucida Sans", 1, 12));
	    				    table1.setForeground(Color.decode("#002E63"));
	    					
	    					  
	    				    ResultSet trs1=stmt1.executeQuery("select * from smarthome.preprocess");
	    				    
	    				    while(trs1.next())
	    				    {
	    				    	
	    				    	String appseq ="";
	    				    	
	    				    	Vector v = new Vector();
    				    		
    				    		v.add(trs1.getString("date"));
	    				    	
	    				    	v.add(trs1.getString("st"));
	    				    	v.add(trs1.getString("et"));
	    				    	
	    				    	
	    				    	
	    				   ResultSetMetaData rset = trs1.getMetaData();
	    				    	
	    				    	totcount = rset.getColumnCount();
	    				    	
	    				    	int stacount = 0;
	    				    	
	    				    	for(int i=4; i<=totcount; i++)
	    				    	{
	    				    		
	    				    	
	    				    		stacount++;
	    				    		
	    				    		double value = Double.parseDouble(trs1.getString(i));
	    				    		
	    				    		if(value>0)
	    				    		{
	    				    			appseq += String.valueOf(stacount)+" ";
	    				    			
	    				    		}
	    				    		
	    				    	}
	    				    	
	    				   
	    				  //  	System.out.println(" Sequence of Appliances "+appseq);
	    				    	
	    				    	v.add(appseq);
	    				    	
	    				    	
	    				    	tablemod1.addRow(v); 
	    				    	
	    				    	
	    				    	stmt.executeUpdate("insert into smarthome.activity values('"+v.get(0)+"','"+v.get(1)+"','"+v.get(2)+"','"+v.get(3)+"','')");
	    				    	
	    				    	
	    				    	System.out.println(" Appliance "+v);
	    				    	
	    				    	
	    				    	
	    				    	
	    				    }
	    				    
	    				    
	    				    ResultSet trs2 = stmt1.executeQuery("select * from smarthome.activity");
	    				    
	    				    while(trs2.next())
	    				    {
	    				    	
	    				    	String activity = trs2.getString("starttime");
	    				    	String stime = trs2.getString("starttime");
	    				    	
	    				    	
	    				    	
	    				    	
	    				    	if(activity.equals("6:00")||activity.equals("7:00")||activity.equals("8:00")||activity.equals("9:00")||activity.equals("10:00")||activity.equals("11:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activity set schedule='M' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    		
	    				    	
	    				    	
	    				    	if(activity.equals("12:00")||activity.equals("13:00")||activity.equals("14:00")||activity.equals("15:00")||activity.equals("16:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activity set schedule='A' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    	
	    				    	
	    				    	
	    				    	if(activity.equals("17:00")||activity.equals("18:00")||activity.equals("19:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activity set schedule='E' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    	
	    				    	if(activity.equals("20:00")||activity.equals("21:00")||activity.equals("22:00")||activity.equals("23:00")||activity.equals("0:00")||activity.equals("1:00")||activity.equals("2:00")||activity.equals("3:00")||activity.equals("4:00")||activity.equals("5:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activity set schedule='N' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    	
	    				    	
	    				    }
	    				    
	    					progress.setIndeterminate(false);
        					
        					progress.setString("Appliance Identified...");
        	    		   	
        	    		   	
	     				
 				}
 				
 				catch(Exception ex)
 				{
 					ex.printStackTrace();
 				}
	     	}
	     		
	     	}
	     			
	      			); 
	     	 
	     	
	     	
	     	button4.addActionListener(new ActionListener()
	     	
	     	{
	     		public void actionPerformed(ActionEvent ae)
	     		{
	     			
	     			
	     			progress.setString("Upload Datasets...");
        			progress.setIndeterminate(true);
						
        				
				try
				{
					
					ResultSet trs=stmt.executeQuery("select distinct date from smarthome.activity");
					
					Vector va = new Vector();
				
					while(trs.next())
					{
						va.add(trs.getString("date"));
						
					}
					
					System.out.println("date count:"+va);
					
					
					String session[] ={"M","A","E","N"};
					
			//		ResultSet trs1=stmt.executeQuery("select * ");	
					
					for(int i=0;i<va.size();i++)
					{
					
						
						for(int s=0;s<session.length;s++)
						
						{
							
					ResultSet trs1 = stmt.executeQuery("select * from smarthome.activity where date='"+va.get(i)+"' and schedule='"+session[s]+"'");
					
					
					Vector macvec = new Vector();
					
					
					while(trs1.next())
					{
						
						String sche = trs1.getString("activity");
							
						String schelen[] = sche.split(" ");
						
					//	System.out.println("splitting");
					
						for(int j=0;j<schelen.length;j++)
						{
							
							System.out.println("schelen"+schelen[j]);
							
						for(int k=1;k<=totcount-3;k++)
						{
							
						String scmat = String.valueOf(k);
						
							
							if(schelen[j].equals(scmat))
							{
							
							
								if(!macvec.contains(schelen[j]))
								{
								
								macvec.add(scmat);
								
								}
								
							}
							
						}
						
						
						}
						
						
					}
					
					
					System.out.println(" Vector :"+macvec);
					
					String groche ="";
					for(int m=0;m<macvec.size();m++)
					{
					
						
						groche += macvec.get(m)+" ";
						
						
						
						
					}
					
					
					stmt1.executeUpdate("insert into grouped values('"+session[s]+"','"+va.get(i)+"','"+groche+"')");
					
					
					}
					
					}	
					
					
					
					
					JPanel tableHold = new JPanel(); 
					tableHold.setName("Grouping");
					tableHold.setLayout(null); 
					
					
					DefaultTableModel tablemod = new DefaultTableModel();
					JTable table = new JTable(tablemod); 
					table.setEnabled(false);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					
					JScrollPane jsp = new JScrollPane(table); 
					jsp.setName("jsp");
					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"preprocess dataset",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
					jsp.setBounds(5,5,dim.width-220,dim.height-170);
					jsp.setBackground(new Color(86,3,25));
					
					tableHold.add(jsp);
					
					proPanel.add(tableHold.getName(),tableHold);
					
					
					table.setBackground(Color.decode("#F5F5F5"));
				    table.setFont(new Font("Lucida Sans", 1, 12));
				    table.setForeground(Color.decode("#002E63"));
					
					
					
					
					ResultSet rst=stmt.executeQuery("select * from smarthome.grouped");
                    ResultSetMetaData meta=rst.getMetaData();
                    for(int i=1;i<=meta.getColumnCount();i++)
                    {
                     Object column=(Object)meta.getColumnName(i);
                     tablemod.addColumn(column);
                    }
            		
                    
                    while(rst.next())
                    {
                    	Vector v=new Vector();
                    	v.add(rst.getString(1));v.add(rst.getString(2));v.add(rst.getString(3));
                    	tablemod.addRow(v); 
                    }
            		
            		
            		
            	
            		
            		
            		progress.setIndeterminate(false);
					
					progress.setString("Upload completed...");
					
					
					
					
					
					
							
							
				}
					
					
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
	     			
	     			
	     			
	     		}
	     	}
	     			
	     			);
	     	
	     	
	     	
	     	button5.addActionListener(new ActionListener()
	     	{
	     		public void actionPerformed(ActionEvent ae)
	     		{
	     			
	     			
	     			try
	     			{
	     				
	     		
	     			
	     			ResultSet trs=stmt.executeQuery("select distinct date from smarthome.activity");
					
					Vector va = new Vector();
				
					while(trs.next())
					{
						va.add(trs.getString("date"));
						
					}
					
				//	System.out.println("date count:"+va);
					
					
					String session[] ={"M","A","E","N"};
					
					
					
					for(int i=0;i<va.size();i++)
					{
					
						
						for(int s=0;s<session.length;s++)
						
						{
							
					ResultSet trs1 = stmt.executeQuery("select * from smarthome.activity where date='"+va.get(i)+"' and schedule='"+session[s]+"'");
					
					
					
					
					
					
					
					
					while(trs1.next())
					{
						
						Vector findacappl = new Vector();
						
						String getAppl = trs1.getString("activity");
						
						String dat = trs1.getString("date");
						String sttime = trs1.getString("starttime");
						String endtime = trs1.getString("endtime");
						
						
						
						String appl[] = getAppl.split(" ");
						
						Vector vvv = new Vector();
						
						for(String ss:appl)
						{
							
							
							vvv.add(ss);
							
								
							
						}
						
						System.out.println(" appl vector "+vvv);
						
						
						
						if(vvv.contains("1") && vvv.contains("4") && vvv.contains("7"))
						{
							findacappl.add("Excer&TV");
							
							System.out.println("Excer&TV");
						}
						
						else
						{
							if(vvv.contains("1") || vvv.contains("4"))
							{
								findacappl.add("Relaxing");
								System.out.println("Relaxing");
							}
						}
						
						
						
						if(vvv.contains("14"))
						{
							findacappl.add("PrepareTea");
							System.out.println("PrepareTea");
						}
						
						
						if(vvv.contains("8") && vvv.contains("10") && session[s].equals("M"))
						{
							findacappl.add("Breakfast");
							System.out.println("Breakfast");
							
						}
						
						
						if(vvv.contains("8") && vvv.contains("10") && session[s].equals("A"))
						{
							findacappl.add("Lunch");
							System.out.println("Lunch");
							
						}
						
						if(vvv.contains("8") && vvv.contains("10") && session[s].equals("N"))
						{
							findacappl.add("Dinner");
							System.out.println("Dinner");
							
						}
						
						
						if(vvv.contains("3"))
						{
							findacappl.add("WashingClothes");
							System.out.println("WashingClothes");
						}
						
						
						if(vvv.contains("11") && vvv.contains("9") && vvv.contains("15"))
						{
							
							findacappl.add("Bathing");
							System.out.println("Bathing");
							
						}
						
						
						
						if(vvv.contains("6") && vvv.contains("2"))
						{
							findacappl.add("uselaptop");
							System.out.println("uselaptop");
						}
						
						else
						{
							
							if(vvv.contains("6"))
							{
								findacappl.add("Sleeping");
								System.out.println("Sleeping");
							}
							
							else
							{
								if(vvv.contains("2"))
								{
									findacappl.add("uselaptop");
									System.out.println("uselaptop");
								}
							}
							
						}
						
						String totappl="";
						
						for(int j=0;j<findacappl.size();j++)
						{
							
							totappl += findacappl.get(j)+" ";
								
						}
						
						System.out.println(" Cheking "+totappl);
						
						stmt1.executeUpdate("insert into activityprediction values('"+dat+"','"+sttime+"','"+endtime+"','"+totappl+"','"+session[s]+"')");
						
						
						
					}
					
					
					
						}
						
					}
					
	     			}
	     			catch(Exception ex)
	     			{
	     				ex.printStackTrace();
	     			}
	     			
	     			
	     			
	     			
	     			try{
	     				

					
	     				
	     				ResultSet trs=stmt.executeQuery("select distinct date from smarthome.activityprediction");
	     				
	     				

						
						
						Vector va1 = new Vector();
					
						while(trs.next())
						{
							va1.add(trs.getString("date"));
							
						}
						
					//	System.out.println("date count:"+va);
						
						System.out.println(" I am crossing this area");
						
						String session1[] ={"M","A","E","N"};
						
						
						
						for(int i=0;i<va1.size();i++)
						{
						
							
							for(int s=0;s<session1.length;s++)
							
							{
								
						ResultSet trs2 = stmt.executeQuery("select * from smarthome.activityprediction where date='"+va1.get(i)+"' and session='"+session1[s]+"'");
						
						String collappli ="";
						
						while(trs2.next())
						{
							
							
							collappli += trs2.getString("prediction");
							
							
							
						}
						
				//		System.out.println("Prediction "+collappli);
						
						String collapplarr[] = collappli.split(" ");
						
						HashSet<String> hset  = new HashSet<String>();
						
						for(int c=0;c<collapplarr.length;c++)
						{
							
							hset.add(collapplarr[c]);
							
						}
						
						System.out.println(" cluster appliance "+hset);
						
						
						Iterator<String> itr = hset.iterator();
						
						String totactivity="";
						
						while(itr.hasNext())
						{
							totactivity += itr.next()+" ";
						}
						
						
						
						stmt.executeUpdate("insert into activitygrouped values('"+session1[s]+"','"+va1.get(i)+"','"+totactivity+"')");
						
	     			}
							
							
						}
						
						
						
						
						JPanel tableHold = new JPanel(); 
						tableHold.setName("prediction");
						tableHold.setLayout(null); 
						
						
						DefaultTableModel tablemod = new DefaultTableModel();
						JTable table = new JTable(tablemod); 
						table.setEnabled(false);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						
						JScrollPane jsp = new JScrollPane(table); 
						jsp.setName("jsp");
						jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"prediction dataset",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
						jsp.setBounds(5,5,dim.width-220,dim.height-170);
						jsp.setBackground(new Color(86,3,25));
						
						tableHold.add(jsp);
						
						proPanel.add(tableHold.getName(),tableHold);
						
						
						table.setBackground(Color.decode("#F5F5F5"));
					    table.setFont(new Font("Lucida Sans", 1, 12));
					    table.setForeground(Color.decode("#002E63"));
						
						
						
						
						ResultSet rst=stmt.executeQuery("select * from smarthome.activitygrouped");
	                    ResultSetMetaData meta=rst.getMetaData();
	                    for(int i=1;i<=meta.getColumnCount();i++)
	                    {
	                     Object column=(Object)meta.getColumnName(i);
	                     tablemod.addColumn(column);
	                    }
	            		
	                    
	                    while(rst.next())
	                    {
	                    	Vector v=new Vector();
	                    	v.add(rst.getString(1));v.add(rst.getString(2));v.add(rst.getString(3));
	                    	tablemod.addRow(v); 
	                    }
	                    
	                    
	                    
	                    ResultSet rst1 =stmt.executeQuery("select * from smarthome.activitygrouped");
	                    
	                    
	                    Set<String> totprediction = new HashSet<String>();
	                    
	                    
	                    
	                    
	                    while(rst1.next())
	                    {
	                    	
	                    	String precoll = rst1.getString("groupactivity");
	                    	
	                    	String coll[]  = precoll.split(" ");
	                    	
	                    	for(int i=0;i<coll.length;i++)
	                    	{
	                    		
	                    		totprediction.add(coll[i]);
	                    		
	                    		
	                    	}
	                    	
	                    	
	                    	System.out.println(" Prediction colection :"+totprediction);
	                    	
	                    	
	                    }
	                    
	                    
	                    
	                    
	                 String arr[] = new String[totprediction.size()];
	                 
	                 totprediction.toArray(arr);
	                  
	                 
	                 
	                 System.out.println("Tot Preiction "+arr.length);
	                  
	                	 for(int j=0; j<arr.length; j++)
	                	 {
	                	  
	                	
	                	 String temp = arr[j];
	                		 
	                 stmt1.executeUpdate("insert into finalprediction values('"+temp+"')");
	                  
	                	 }
	                  
	                    	
	                    
	                    
	                    
	                    
	                    
	            		
				
						
	     			}
	     			catch(Exception ex)
	     			{
	     				
	     			}
	     			
	     			
	     			
	     		}
	     	}
	     			
	     			
	     			);
	     	
	     	 
		
	     	
	     	
	     	button6.addActionListener(new ActionListener()
	     	{
	     		public void actionPerformed(ActionEvent ae)
	     		{
	     			
	     		
	     			try
	     			{
	     				
	     				
	     				datatest =  select_File();
	     				 
	   
	     				
	     			//	Thread t = new Thread()
	     			//	{
	     					
	     					
	     			//	public void run()
	     			//	{
	     					
	     				
	     				try{
	     					
	     				
	     					
	     					
	     			
	     					
	     					
	     					
	    					
	    					
	    				
	    					
	    					if(datatest!=null){
	    						
	    						
	    						progress.setString("Upload Test Datasets...");
		            			progress.setIndeterminate(true);
	    						
	    						
           	    				FileInputStream input=new FileInputStream(datatest);
                        		byte[] b=new byte[input.available()];
                        		input.read(b);
                        		input.close();
                        		
                        		String content=new String (b);
                        		
                        		System.out.println("check "+content);
                        		
                        		String acon[]=content.split("\n");
                        		
                        	//	System.out.println(acon[1]);
                        		
                        	//	s1 = con1.createStatement();
                        		
                        		System.out.println(" First data "+acon[0]);
                        		
                        		String var[] = acon[0].split(",");
                        		
                        	//	stmt = con1.createStatement();
                        		
                        		
                        		
                        		
                        	
                        		
                        		for(int i=0;i<acon.length;i++)
                        		{
                        			String val[] = acon[i].split(",");
                        	//		String nrval = val[1].replaceAll(";"," ");
                        			
                        	//		System.out.println("nrval check :"+nrval);
                        			
                        			
                        			stmt.executeUpdate("insert into inputtest values('"+val[0]+"','"+val[1]+"','"+val[2]+"','"+val[3]+"','"+val[4]+"','"+val[5]+"','"+val[6]+"','"+val[7]+"','"+val[8]+"','"+val[9]+"','"+val[10]+"','"+val[11]+"','"+val[12]+"','"+val[13]+"','"+val[14]+"','"+val[15]+"','"+val[16]+"','"+val[17]+"')");
                        			
                        		//	va.add(val[i]);
                        			
                        		}
                        		
                        		
                        		
                        		JPanel tableHold = new JPanel(); 
    	    					tableHold.setName("TestInput");
    	    					tableHold.setLayout(null); 
    	    					
    	    					
    	    					DefaultTableModel tablemod = new DefaultTableModel();
    	    					JTable table = new JTable(tablemod); 
    	    					table.setEnabled(false);
    	    					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	    					
    	    					JScrollPane jsp = new JScrollPane(table); 
    	    					jsp.setName("jsp");
    	    					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Uploaded DataSet",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
    	    					jsp.setBounds(5,5,dim.width-220,dim.height-170);
    	    					jsp.setBackground(new Color(86,3,25));
    	    					
    	    					tableHold.add(jsp);
    	    					
    	    					proPanel.add(tableHold.getName(),tableHold);
    	    					
    	    			//		ctl.show(proPanel,tableHold.getName());
                        		
                        		
                        		
                        		
                    			ResultSet rst=stmt.executeQuery("select * from smarthome.inputtest");
                                ResultSetMetaData meta=rst.getMetaData();
                                for(int i=1;i<=meta.getColumnCount();i++)
                                {
                                 Object column=(Object)meta.getColumnName(i);
                                 tablemod.addColumn(column);
                                }
                        		
                                
                                while(rst.next())
                                {
                                	Vector v=new Vector();
                                	v.add(rst.getString(1));v.add(rst.getString(2));v.add(rst.getString(3));v.add(rst.getString(4));v.add(rst.getString(5));v.add(rst.getString(6));v.add(rst.getString(7));v.add(rst.getString(8));
                                	v.add(rst.getString(9));v.add(rst.getString(10));v.add(rst.getString(11));v.add(rst.getString(12));v.add(rst.getString(13));v.add(rst.getString(14));v.add(rst.getString(15));v.add(rst.getString(16));
                                	v.add(rst.getString(17));v.add(rst.getString(18));
                                	tablemod.addRow(v); 
                                }
                        		
                        		
                        		
                        	
                        		
                        		
                        	//	progress.setIndeterminate(false);
            					
            				//	progress.setString("Test data Upload completed...");
	     				
	     				
	     				
	     				
	    					}
	    					
	     				}
	     			
	     			catch(Exception ex)
	     			{
	     				ex.printStackTrace();
	     			}
	     			
	     			
	     			
	 //    		}
	     				
	     				
	  //   				};
	     //				t.start();
	     				
	     			
	     				
	     				
	     				
	     				////////////////////////////////  Preprocess  /////////////////////////////////////////
	     				
	     				
	     				
	     				
	     			//	Thread t1 = new Thread()
	     			//	{
	     					
	     			//		public void run()
	     			//		{
	     						
	     					try{
	     						
	     						
	     					//	progress.setString("Upload Datasets...");
		            		//	progress.setIndeterminate(true);
	     						
	     						
	     						
	     						
	     						ResultSet trs=stmt2.executeQuery("select * from smarthome.inputtest");
		        	    		   	ResultSetMetaData metadata=trs.getMetaData();
		        	    		   	
		        	    		   	System.out.println(" Count"+metadata.getColumnCount());
		        	    		   	
		        	    		   	
		        	    		   	
		        	    		   	
		        	    		    while(trs.next())
	  	        	    			{
	  	        	    				 boolean flag=false;
	  	         	    		   	     for(int i=1; i<=metadata.getColumnCount(); i++)
	  	         	    		   	    {
	  	         	    		   	    	if((trs.getString(i))==null || (trs.getString(i)).isEmpty()){
	  	         	    		   	    		
	  	         	    		   	   
	  	         	    		   	    		flag=true;
	  	         	    		   	    	 break;
	  	         	    		   	    	 }

	  	         	    		   	    	
	  	         	    		   	    }
	  	         	    		   	     
	  	         	    		   	 if(flag == false)
	         	    		   	     {
	         	    		   	    	 String item1 = trs.getString(1);
	         	    		   	    	 String item2 = trs.getString(2);
	         	    		   	    	 String item3 = trs.getString(3);
	         	    		   	    	 String item4 = trs.getString(4);
	         	    		   	    	 String item5 = trs.getString(5);
	         	    		   	    	 String item6 = trs.getString(6);
	         	    		   	    	 String item7 = trs.getString(7);
	         	    		   	    	 String item8 = trs.getString(8);
	         	    		   	    	 String item9 = trs.getString(9);
	         	    		   	    	 String item10 = trs.getString(10);
	         	    		   	    	 String item11 = trs.getString(11);
	         	    		   	    	 String item12 = trs.getString(12);
	         	    		   	    	 String item13 = trs.getString(13);
	         	    		   	    	 String item14 = trs.getString(14);
	         	    		   	    	 String item15 = trs.getString(15);
	         	    		   	    	 String item16 = trs.getString(16);
	         	    		   	    	 String item17 = trs.getString(17);
	         	    		   	    	 String item18 = trs.getString(18);
	         	    		   	    	 
	         	    		   	    	 
	         	    		   	    	System.out.println("Checking testing");
			        	    		   	
	         	    		   	    	 
	         	    		   	    	 
	         	    		   	    	stmt1.executeUpdate("insert into smarthome.preprocesstest values('"+item1+"','"+item2+"','"+item3+"','"+item4+"','"+item5+"','"+item6+"','"+item7+"','"+item8+"','"+item9+"','"+item10+"','"+item11+"','"+item12+"','"+item13+"','"+item14+"','"+item15+"','"+item16+"','"+item17+"','"+item18+"')");
	         	    		   	     }
	  									
	  								}
	  	        	    		  
		        	    		   	
		        	    		   	
		        	    		   	
		        	    		   	
		        	    		   	
	     						
	     					
	     					JPanel tableHold = new JPanel(); 
	    					tableHold.setName("Test Preprocess");
	    					tableHold.setLayout(null); 
	    					
	    					
	    					DefaultTableModel tablemod = new DefaultTableModel();
	    					JTable table = new JTable(tablemod); 
	    					table.setEnabled(false);
	    					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    					
	    					JScrollPane jsp = new JScrollPane(table); 
	    					jsp.setName("jsp");
	    					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Test preprocess dataset",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    					jsp.setBounds(5,5,dim.width-220,dim.height-170);
	    					jsp.setBackground(new Color(86,3,25));
	    					
	    					tableHold.add(jsp);
	    					
	    					proPanel.add(tableHold.getName(),tableHold);
	    					
	    				//	ctl.show(proPanel,tableHold.getName());
	    					
	    					
	    						ResultSet rst=stmt.executeQuery("select * from smarthome.preprocesstest");
	                            ResultSetMetaData meta=rst.getMetaData();
	                            for(int i=1;i<=meta.getColumnCount();i++)
	                            {
	                             Object column=(Object)meta.getColumnName(i);
	                             tablemod.addColumn(column);
	                             
	                            }
	                            
	                            System.out.println(" Checking vector");
	                            
	                            while(rst.next())
	                            {
	                            	Vector v3=new Vector();
	                            	v3.add(rst.getString(1));v3.add(rst.getString(2));v3.add(rst.getString(3));v3.add(rst.getString(4));v3.add(rst.getString(5));v3.add(rst.getString(6));v3.add(rst.getString(7));v3.add(rst.getString(8));
                                	v3.add(rst.getString(9));v3.add(rst.getString(10));v3.add(rst.getString(11));v3.add(rst.getString(12));v3.add(rst.getString(13));v3.add(rst.getString(14));v3.add(rst.getString(15));v3.add(rst.getString(16));
                                	v3.add(rst.getString(17));v3.add(rst.getString(18));
	                            	tablemod.addRow(v3); 
	                            }
	        	    			
	               	    	
	                            System.out.println(" Checking vector after");
	                           
	                            
	                         //   JOptionPane.showMessageDialog(null,"Pre-Processed successfully","Message",1);
	    					
	                      //      progress.setIndeterminate(false);
            					
            			//		progress.setString("Upload completed...");
	    					
	    					
	     					}
	    					
	    					catch(Exception ex)
	    					{
	    						ex.printStackTrace();
	    					}
	     					
	     			//	}
	     					
	     					
	     			//	};
	     			//	t1.start();
	     			 
	     				
	     					
	     					
	     	//////////////  Activity Test  ///////////////////////////////////////
	     					
	     				
	     				try
	     				{
	     					
	     					
	     					JPanel tableHold1 = new JPanel(); 
	    					tableHold1.setName("Activity Test");
	    					tableHold1.setLayout(null); 
	    					
	    					
	    					DefaultTableModel tablemod1 = new DefaultTableModel();
	    					JTable table1 = new JTable(tablemod1); 
	    					table1.setEnabled(false);
	    					table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    				//	table1.setRowHeight(15);
	    					
	    					JScrollPane jsp1 = new JScrollPane(table1); 
	    					jsp1.setName("jsp");
	    					jsp1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Test Activity",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    					jsp1.setBounds(5,5,dim.width-220,dim.height-170);
	    					jsp1.setBackground(new Color(86,3,25));
	    					
	    					tableHold1.add(jsp1);
	    					
	    					proPanel.add(tableHold1.getName(),tableHold1);
	    					
	    					tablemod1.addColumn("Date");
	    					tablemod1.addColumn("Staring Time");
	    					tablemod1.addColumn("Ending Time");
	    					tablemod1.addColumn("Activity Appliance");
	    					
	    					
	    					
	    					table1.setBackground(Color.decode("#F5F5F5"));
	    				    table1.setFont(new Font("Lucida Sans", 1, 12));
	    				    table1.setForeground(Color.decode("#002E63"));
	    					
	    					  
	    				    ResultSet trs1=stmt1.executeQuery("select * from smarthome.preprocesstest");
	    				    
	    				    while(trs1.next())
	    				    {
	    				    	
	    				    	String appseq ="";
	    				    	
	    				    	Vector v = new Vector();
    				    		
    				    		v.add(trs1.getString("date"));
	    				    	
	    				    	v.add(trs1.getString("st"));
	    				    	v.add(trs1.getString("et"));
	    				    	
	    				    	
	    				    	
	    				   ResultSetMetaData rset = trs1.getMetaData();
	    				    	
	    				    	totcount = rset.getColumnCount();
	    				    	
	    				    	int stacount = 0;
	    				    	
	    				    	for(int i=4; i<=totcount; i++)
	    				    	{
	    				    		
	    				    	
	    				    		stacount++;
	    				    		
	    				    		double value = Double.parseDouble(trs1.getString(i));
	    				    		
	    				    		if(value>0)
	    				    		{
	    				    			appseq += String.valueOf(stacount)+" ";
	    				    			
	    				    		}
	    				    		
	    				    	}
	    				    	
	    				   
	    				  //  	System.out.println(" Sequence of Appliances "+appseq);
	    				    	
	    				    	v.add(appseq);
	    				    	
	    				    	
	    				    	tablemod1.addRow(v); 
	    				    	
	    				    	
	    				    	stmt.executeUpdate("insert into smarthome.activitytest values('"+v.get(0)+"','"+v.get(1)+"','"+v.get(2)+"','"+v.get(3)+"','')");
	    				    	
	    				    	
	    				    	System.out.println(" Appliance "+v);
	    				    	
	    				    	
	    				    	
	    				    	
	    				    }
	    				    
	    				    
	    				    ResultSet trs2 = stmt1.executeQuery("select * from smarthome.activitytest");
	    				    
	    				    while(trs2.next())
	    				    {
	    				    	
	    				    	String activity = trs2.getString("starttime");
	    				    	String stime = trs2.getString("starttime");
	    				    	
	    				    	
	    				    	
	    				    	
	    				    	if(activity.equals("6:00")||activity.equals("7:00")||activity.equals("8:00")||activity.equals("9:00")||activity.equals("10:00")||activity.equals("11:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activitytest set schedule='M' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    		
	    				    	
	    				    	
	    				    	if(activity.equals("12:00")||activity.equals("13:00")||activity.equals("14:00")||activity.equals("15:00")||activity.equals("16:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activitytest set schedule='A' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    	
	    				    	
	    				    	
	    				    	if(activity.equals("17:00")||activity.equals("18:00")||activity.equals("19:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activitytest set schedule='E' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    	
	    				    	if(activity.equals("20:00")||activity.equals("21:00")||activity.equals("22:00")||activity.equals("23:00")||activity.equals("0:00")||activity.equals("1:00")||activity.equals("2:00")||activity.equals("3:00")||activity.equals("4:00")||activity.equals("5:00"))
	    				    		
	    				    	{
	    				    		
	    				   // 		String value ="M";
	    				    		stmt.executeUpdate("update smarthome.activitytest set schedule='N' where starttime='"+stime+"'");
	    				    		
	    				    		System.out.println(" Activity :"+activity);
	    				    	}
	    				    	
	    				    	
	    				    }
	     					
	     					
	     				}
	     				
	     				catch(Exception ex)
	     				{
	     					ex.printStackTrace();
	     				}
	     				
	     				
	     				
	     				
	    /////////////// Grouping ////////////////////////////////////
	     				
	     				
	     				try
	     				{
	     					
	     					
	     					
	     					
	     					ResultSet trs=stmt.executeQuery("select distinct date from smarthome.activitytest");
	    					
	    					Vector va = new Vector();
	    				
	    					while(trs.next())
	    					{
	    						va.add(trs.getString("date"));
	    						
	    					}
	    					
	    					System.out.println("date count:"+va);
	    					
	    					
	    					String session[] ={"M","A","E","N"};
	    					
	    			//		ResultSet trs1=stmt.executeQuery("select * ");	
	    					
	    					for(int i=0;i<va.size();i++)
	    					{
	    					
	    						
	    						for(int s=0;s<session.length;s++)
	    						
	    						{
	    							
	    					ResultSet trs1 = stmt.executeQuery("select * from smarthome.activitytest where date='"+va.get(i)+"' and schedule='"+session[s]+"'");
	    					
	    					
	    					Vector macvec = new Vector();
	    					
	    					
	    					while(trs1.next())
	    					{
	    						
	    						String sche = trs1.getString("activity");
	    							
	    						String schelen[] = sche.split(" ");
	    						
	    					//	System.out.println("splitting");
	    					
	    						for(int j=0;j<schelen.length;j++)
	    						{
	    							
	    							System.out.println("schelen"+schelen[j]);
	    							
	    						for(int k=1;k<=totcount-3;k++)
	    						{
	    							
	    						String scmat = String.valueOf(k);
	    						
	    							
	    							if(schelen[j].equals(scmat))
	    							{
	    							
	    							
	    								if(!macvec.contains(schelen[j]))
	    								{
	    								
	    								macvec.add(scmat);
	    								
	    								}
	    								
	    							}
	    							
	    						}
	    						
	    						
	    						}
	    						
	    						
	    					}
	    					
	    					
	    					System.out.println(" Vectortest :"+macvec);
	    					
	    					String groche ="";
	    					for(int m=0;m<macvec.size();m++)
	    					{
	    					
	    						
	    						groche += macvec.get(m)+" ";
	    						
	    						
	    						
	    						
	    					}
	    					
	    					
	    					stmt1.executeUpdate("insert into groupedtest values('"+session[s]+"','"+va.get(i)+"','"+groche+"')");
	    					
	    					
	    					}
	    					
	    					}	
	    					
	    					
	    					
	    					
	    					JPanel tableHold = new JPanel(); 
	    					tableHold.setName("Test Group");
	    					tableHold.setLayout(null); 
	    					
	    					
	    					DefaultTableModel tablemod = new DefaultTableModel();
	    					JTable table = new JTable(tablemod); 
	    					table.setEnabled(false);
	    					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    					
	    					JScrollPane jsp = new JScrollPane(table); 
	    					jsp.setName("jsp");
	    					jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Group dataset",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    					jsp.setBounds(5,5,dim.width-220,dim.height-170);
	    					jsp.setBackground(new Color(86,3,25));
	    					
	    					tableHold.add(jsp);
	    					
	    					proPanel.add(tableHold.getName(),tableHold);
	    					
	    					
	    					table.setBackground(Color.decode("#F5F5F5"));
	    				    table.setFont(new Font("Lucida Sans", 1, 12));
	    				    table.setForeground(Color.decode("#002E63"));
	    					
	    					
	    					
	    					
	    					ResultSet rst=stmt.executeQuery("select * from smarthome.groupedtest");
	                        ResultSetMetaData meta=rst.getMetaData();
	                        for(int i=1;i<=meta.getColumnCount();i++)
	                        {
	                         Object column=(Object)meta.getColumnName(i);
	                         tablemod.addColumn(column);
	                        }
	                		
	                        
	                        while(rst.next())
	                        {
	                        	Vector v=new Vector();
	                        	v.add(rst.getString(1));v.add(rst.getString(2));v.add(rst.getString(3));
	                        	tablemod.addRow(v); 
	                        }
	                		
	                		
	                		
	                	
	                		
	                		
	                	//	progress.setIndeterminate(false);
	    					
	    				//	progress.setString("Upload completed...");
	    					
	    					
	    							
	    				
	     					
	     					
	     					
	     					
	     					
	     				}
	     				catch(Exception ex)
	     				{
	     					ex.printStackTrace();
	     				}
	     				
	     				
	     				
	     				
	     				
	     				////////////////////////  Prediction  /////////////////////////////////////////////
	     				
	     				
	     				try
	     				{
	     					
	     					
	     					
	     					ResultSet trs=stmt.executeQuery("select distinct date from smarthome.activitytest");
	    					
	    					Vector va = new Vector();
	    				
	    					while(trs.next())
	    					{
	    						va.add(trs.getString("date"));
	    						
	    					}
	    					
	    				//	System.out.println("date count:"+va);
	    					
	    					
	    					String session[] ={"M","A","E","N"};
	    					
	    					
	    					
	    					for(int i=0;i<va.size();i++)
	    					{
	    					
	    						
	    						for(int s=0;s<session.length;s++)
	    						
	    						{
	    							
	    					ResultSet trs1 = stmt.executeQuery("select * from smarthome.activitytest where date='"+va.get(i)+"' and schedule='"+session[s]+"'");
	    					
	    					
	    					
	    					
	    					
	    					
	    					
	    					
	    					while(trs1.next())
	    					{
	    						
	    						Vector findacappl = new Vector();
	    						
	    						String getAppl = trs1.getString("activity");
	    						
	    						String dat = trs1.getString("date");
	    						String sttime = trs1.getString("starttime");
	    						String endtime = trs1.getString("endtime");
	    						
	    						
	    						
	    						String appl[] = getAppl.split(" ");
	    						
	    						Vector vvv = new Vector();
	    						
	    						for(String ss:appl)
	    						{
	    							
	    							
	    							vvv.add(ss);
	    							
	    								
	    							
	    						}
	    						
	    						System.out.println(" appl vector "+vvv);
	    						
	    						
	    						
	    						if(vvv.contains("1") && vvv.contains("4") && vvv.contains("7"))
	    						{
	    							findacappl.add("Excer&TV");
	    							
	    							System.out.println("Excer&TV");
	    						}
	    						
	    						else
	    						{
	    							if(vvv.contains("1") || vvv.contains("4"))
	    							{
	    								findacappl.add("Relaxing");
	    								System.out.println("Relaxing");
	    							}
	    						}
	    						
	    						
	    						
	    						if(vvv.contains("14"))
	    						{
	    							findacappl.add("PrepareTea");
	    							System.out.println("PrepareTea");
	    						}
	    						
	    						
	    						if(vvv.contains("8") && vvv.contains("10") && session[s].equals("M"))
	    						{
	    							findacappl.add("Breakfast");
	    							System.out.println("Breakfast");
	    							
	    						}
	    						
	    						
	    						if(vvv.contains("8") && vvv.contains("10") && session[s].equals("A"))
	    						{
	    							findacappl.add("Lunch");
	    							System.out.println("Lunch");
	    							
	    						}
	    						
	    						if(vvv.contains("8") && vvv.contains("10") && session[s].equals("N"))
	    						{
	    							findacappl.add("Dinner");
	    							System.out.println("Dinner");
	    							
	    						}
	    						
	    						
	    						if(vvv.contains("3"))
	    						{
	    							findacappl.add("WashingClothes");
	    							System.out.println("WashingClothes");
	    						}
	    						
	    						
	    						if(vvv.contains("11") && vvv.contains("9") && vvv.contains("15"))
	    						{
	    							
	    							findacappl.add("Bathing");
	    							System.out.println("Bathing");
	    							
	    						}
	    						
	    						
	    						
	    						if(vvv.contains("6") && vvv.contains("2"))
	    						{
	    							findacappl.add("uselaptop");
	    							System.out.println("uselaptop");
	    						}
	    						
	    						else
	    						{
	    							
	    							if(vvv.contains("6"))
	    							{
	    								findacappl.add("Sleeping");
	    								System.out.println("Sleeping");
	    							}
	    							
	    							else
	    							{
	    								if(vvv.contains("2"))
	    								{
	    									findacappl.add("uselaptop");
	    									System.out.println("uselaptop");
	    								}
	    							}
	    							
	    						}
	    						
	    						String totappl="";
	    						
	    						for(int j=0;j<findacappl.size();j++)
	    						{
	    							
	    							totappl += findacappl.get(j)+" ";
	    								
	    						}
	    						
	    						System.out.println(" Cheking "+totappl);
	    						
	    						stmt1.executeUpdate("insert into activitypredictiontest values('"+dat+"','"+sttime+"','"+endtime+"','"+totappl+"','"+session[s]+"')");
	    						
	    						
	    						
	    					}
	    					
	    					
	    					
	    						}
	    						
	    					}
	    					
	    	     			}
	    	     			catch(Exception ex)
	    	     			{
	    	     				ex.printStackTrace();
	    	     			}
	    	     			
	    	     			
	    	     			
	    	     			
	    	     			try{
	    	     				

	    					
	    	     				
	    	     				ResultSet trs=stmt.executeQuery("select distinct date from smarthome.activitypredictiontest");
	    	     				
	    	     				

	    						
	    						
	    						Vector va1 = new Vector();
	    					
	    						while(trs.next())
	    						{
	    							va1.add(trs.getString("date"));
	    							
	    						}
	    						
	    					//	System.out.println("date count:"+va);
	    						
	    						System.out.println(" I am crossing this area");
	    						
	    						String session1[] ={"M","A","E","N"};
	    						
	    						
	    						
	    						for(int i=0;i<va1.size();i++)
	    						{
	    						
	    							
	    							for(int s=0;s<session1.length;s++)
	    							
	    							{
	    								
	    						ResultSet trs2 = stmt.executeQuery("select * from smarthome.activitypredictiontest where date='"+va1.get(i)+"' and session='"+session1[s]+"'");
	    						
	    						String collappli ="";
	    						
	    						while(trs2.next())
	    						{
	    							
	    							
	    							collappli += trs2.getString("prediction");
	    							
	    							
	    							
	    						}
	    						
	    				//		System.out.println("Prediction "+collappli);
	    						
	    						String collapplarr[] = collappli.split(" ");
	    						
	    						HashSet<String> hset  = new HashSet<String>();
	    						
	    						for(int c=0;c<collapplarr.length;c++)
	    						{
	    							
	    							hset.add(collapplarr[c]);
	    							
	    						}
	    						
	    						System.out.println(" cluster appliance "+hset);
	    						
	    						
	    						Iterator<String> itr = hset.iterator();
	    						
	    						String totactivity="";
	    						
	    						while(itr.hasNext())
	    						{
	    							totactivity += itr.next()+" ";
	    						}
	    						
	    						
	    						
	    						stmt.executeUpdate("insert into activitygroupedtest values('"+session1[s]+"','"+va1.get(i)+"','"+totactivity+"')");
	    						
	    	     			}
	    							
	    							
	    						}
	    						
	    						
	    						
	    						
	    						JPanel tableHold = new JPanel(); 
	    						tableHold.setName("Test Prediction");
	    						tableHold.setLayout(null); 
	    						
	    						
	    						DefaultTableModel tablemod = new DefaultTableModel();
	    						JTable table = new JTable(tablemod); 
	    						table.setEnabled(false);
	    						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    						
	    						JScrollPane jsp = new JScrollPane(table); 
	    						jsp.setName("jsp");
	    						jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Test Prediction",1,2,new Font("Verdana",Font.BOLD,10),Color.white));
	    						jsp.setBounds(5,5,dim.width-220,dim.height-170);
	    						jsp.setBackground(new Color(86,3,25));
	    						
	    						tableHold.add(jsp);
	    						
	    						proPanel.add(tableHold.getName(),tableHold);
	    						
	    						
	    						table.setBackground(Color.decode("#F5F5F5"));
	    					    table.setFont(new Font("Lucida Sans", 1, 12));
	    					    table.setForeground(Color.decode("#002E63"));
	    						
	    						
	    						
	    						
	    						ResultSet rst=stmt.executeQuery("select * from smarthome.activitygroupedtest");
	    	                    ResultSetMetaData meta=rst.getMetaData();
	    	                    for(int i=1;i<=meta.getColumnCount();i++)
	    	                    {
	    	                     Object column=(Object)meta.getColumnName(i);
	    	                     tablemod.addColumn(column);
	    	                    }
	    	            		
	    	                    
	    	                    while(rst.next())
	    	                    {
	    	                    	Vector v=new Vector();
	    	                    	v.add(rst.getString(1));v.add(rst.getString(2));v.add(rst.getString(3));
	    	                    	tablemod.addRow(v); 
	    	                    }
	    	            		
	    				
	    						

	    	                    
	    	                    ResultSet rst1 =stmt.executeQuery("select * from smarthome.activitygroupedtest");
	    	                    
	    	                    
	    	                    Set<String> totprediction = new HashSet<String>();
	    	                    
	    	                    
	    	                    
	    	                    
	    	                    while(rst1.next())
	    	                    {
	    	                    	
	    	                    	String precoll = rst1.getString("groupactivity");
	    	                    	
	    	                    	String coll[]  = precoll.split(" ");
	    	                    	
	    	                    	for(int i=0;i<coll.length;i++)
	    	                    	{
	    	                    		
	    	                    		totprediction.add(coll[i]);
	    	                    		
	    	                    		
	    	                    	}
	    	                    	
	    	                    	
	    	                    	System.out.println(" Prediction colection :"+totprediction);
	    	                    	
	    	                    	
	    	                    }
	    	                    
	    	                    
	    	                    
	    	                    
	    	                 String arr[] = new String[totprediction.size()];
	    	                 
	    	                 totprediction.toArray(arr);
	    	                  
	    	                 
	    	                 
	    	                 System.out.println("Tot Preiction "+arr.length);
	    	                  
	    	                	 for(int j=0; j<arr.length; j++)
	    	                	 {
	    	                	  
	    	                	
	    	                	 String temp = arr[j];
	    	                		 
	    	                 stmt1.executeUpdate("insert into finalpredictiontest values('"+temp+"')");
	    	                  
	    	                	 }
	    	                  
	    	                    	
	    	                    
	    	                    
	    	                    
	     					
	     					
	     				}
	     				
	     				catch(Exception ex)
	     				{
	     					
	     				}
	     				
	    	     			
	    	     			
	    	     			
	     				
	     				
	     				///////////////////////////////////////////////////////////////////////////////////
	     				
	     				
	     				
	    	     			progress.setIndeterminate(false);
        					
            				progress.setString("Testing Prediction completed...");
	    	     			
	    	     			
	    	     			
	    	     			
	     				
	     				
	     				
	     				///////////////////////////////////////////////////////////////////////////////////
	     				
	     				
	     				
	     				
	     			}catch(Exception ex)
	     			{
	     				ex.printStackTrace();
	     			}
	     		
	     	
	     		
	     		}
	     		});
	     	
	     	
	     	
	     	
	     	
	     	button7.addActionListener(new ActionListener()
	     			
	     			{
	     		public void actionPerformed(ActionEvent ae)
	     		
	     		
	     		{
	     			
	     			try
	     			{
	     			
	     			ResultSet tt = stmt.executeQuery("select * from finalprediction");
	     			
	     			Vector vv = new Vector();
	     			
	     			while(tt.next())
	     			{
	     				
	     				String str = tt.getString("activity");
	     				
	     				vv.add(str);
	     				
	     			}
	     			
	     			
	     			
	     			int fincount = vv.size();
	     			
	     			
	     			System.out.println("Final count"+vv.size());
	     			
	     			
	     			ResultSet tt1 = stmt.executeQuery("select * from finalpredictiontest");
	     			
	     			Vector vv1 = new Vector();
	     			
	     			while(tt1.next())
	     			{
	     				
	     				String str = tt1.getString("activity");
	     				
	     				vv1.add(str);
	     				
	     			}
	     			
	     			
	     			int fincounttest = vv1.size();
	     			
	     			
	     			int emer = fincount-fincounttest;
	     			
	     			
	     			
	     			if(emer>=5)
	     			{
	     				///emergency
	     				
	     				 JFrame frame = new JFrame ( "Information Banner" );
	     			      ScrollingBanner panel = new ScrollingBanner ( 400, 400, "They Need Emergency Support");
	     			      frame.getContentPane().add ( panel );
	     			      frame.setSize ( panel.width, panel.height );
	     			      frame.setVisible ( true );
	     			}
	     			
	     			
	     			else if(emer>=2 && emer<=4)
	     			{
	     				
	     				 JFrame frame = new JFrame ( "Information Banner" );
	     			      ScrollingBanner panel = new ScrollingBanner ( 400, 400, "They Need Support");
	     			      frame.getContentPane().add ( panel );
	     			      frame.setSize ( panel.width, panel.height );
	     			      frame.setVisible ( true );
	     			   //   frame.addWindowListener ( new WindowAdapter() {
	     			   //       public void windowClosing ( WindowEvent evt ) {
	     			    //          System.exit ( 0 );
	     			   //       }
	     			   //   } );
	     				
	     			}
	     			
	     			else if(!vv1.contains("Breakfast"))
	     					{
	     				
	     				
	     				JFrame frame = new JFrame ( "Information Banner" );
	     			      ScrollingBanner panel = new ScrollingBanner ( 400, 400, "Forgot Breakfast");
	     			      frame.getContentPane().add ( panel );
	     			      frame.setSize ( panel.width, panel.height );
	     			      frame.setVisible ( true );
	     				
	     				
	     					}
	     			
	     			
	     			else if(!vv1.contains("Excer&TV"))
 					{
 				
 				
 				JFrame frame = new JFrame ( "Information Banner" );
 			      ScrollingBanner panel = new ScrollingBanner ( 400, 400, "Do Excercise");
 			      frame.getContentPane().add ( panel );
 			      frame.setSize ( panel.width, panel.height );
 			      frame.setVisible ( true );
 				
 				
 					}
	     			
	     			
	     			
	     			else
	     			{
	     				
	     				
	     				JFrame frame = new JFrame ( "Information Banner" );
	     			      ScrollingBanner panel = new ScrollingBanner ( 400, 400, "Behaviour is Normal");
	     			      frame.getContentPane().add ( panel );
	     			      frame.setSize ( panel.width, panel.height );
	     			      frame.setVisible ( true );
	     				
	     			}
	     			
	     			
	     			
	     			}
	     			
	     			catch(Exception ex)
	     			{
	     				ex.printStackTrace();
	     			}
	     			
	     			
	     		}
	     			}
	     			
	     			
	     			
	     			
	     			
	     			
	     			
	     			);
	     	
	     	
	     	
		
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	public static void main(String args[])
	{
		
		MainGUI ma = new MainGUI();
		
		
	}
	
	
	public File select_File()
  	{
  		File data=null;
  		
  		try
  		{
  			chooser = new JFileChooser();
  			chooser.setCurrentDirectory(new File(""+System.getProperty("user.dir")+""));
  			int value = chooser.showDialog(new JFrame(), "Select Dataset File");
  			
  		//	frame = chooser.getSelectedFile().getName();
  			path=chooser.getSelectedFile().getAbsolutePath();
  			
  			if(value==0)
  			{
  				data = chooser.getSelectedFile();
  				System.out.println("File name:" +data.getName());
  			}
  			else
  			{
  				JOptionPane.showMessageDialog(null,"Select Valid File","Error Message",1);
  			}
  		}
  		catch(Exception ex)
  		{
  			ex.printStackTrace();
  		}
  		
  		
  	return data;

}
	

}
