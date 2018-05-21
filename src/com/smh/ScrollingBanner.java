package com.smh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ScrollingBanner extends Applet implements Runnable
{
  protected Thread banner;      // animation thread
  protected String text;        // text to be displayed
  protected Font font;          // font used to display text
  protected int width;          // width of viewing area in pixels
  protected int height;         // height of viewing area in pixels
  protected int x, y;           // current position of text
  protected int delay;          // interval between frames in millisec
  protected int offset;         // distance moved between two frames
  protected Dimension size;     // size of viewing area
  protected Image image, pic;        // off-screen image
  protected Graphics offScreen; // off-screen graphics
  
  public ScrollingBanner( int aWidth, int aHeight, String text)
  {
    // Set the width and heigth and size
    width = aWidth;
    height = aHeight;
    setSize ( width, height );
    
    // Set the text
    this.text = text;
    
    // Set the font
    font = new Font ( "Sans-serif", Font.BOLD, 24 );
    
    // Set the time interval between frames in millisec
    delay = 100;
    
    //image
    
   // pic = getImage(getDocumentBase(),"server.jpeg");
  
    
    // Set the intial values for x and y
    x = width / 2;
    y = height / 2;
    
    // Set the offset
    offset = 5;
    
    // Create and start the thread
    banner = new Thread ( this );
    banner.start();
  }
  
  
  
  
  public void paintComponent ( Graphics g )
  {  
      // Get the size of the viewing area
      size = this.getSize();
      
      // Create the off-screen image buffer if it is the first time
      if ( image == null )
      {
          image = createImage ( size.width, size.height );
          offScreen = image.getGraphics();
      }
      
      // Get the font metrics to determine the length of the text 
      offScreen.setFont ( font );
      FontMetrics fm = g.getFontMetrics();
      int length = fm.stringWidth ( text );
      
      // Adjust the position of the text from the previous frame
      x = x - offset;
      
      // If the text is completely off to the left end move the
      // position of the banner to the right edge
      if ( x < -length )
        x = size.width;
        
      // Set the color and paint the background
      offScreen.setColor ( Color.white);
      offScreen.fillRect ( 0, 0, size.width, size.height );
      
  //    offScreen.drawImage(pic, 20, 100, this);
     
      
      // Set the pen color and draw the text
      offScreen.setColor ( Color.green );
      offScreen.drawString ( text, x, y );
      
      // Copy the off-screen image to the screen
      g.drawImage ( image, 0, 0, this );     
  }
  
  public void update ( Graphics g )
  {
      paintComponent ( g );
  }
  
  public void run ()
  {
     while ( Thread.currentThread() == banner )
     {
         repaint ();
         try
         {
             Thread.sleep ( delay );
         }
         catch ( InterruptedException e )
         {
             System.out.println ( "Exception: " + e.getMessage());
         }        
     }
  }

  public static void main ( String[] args )
  {
      JFrame frame = new JFrame ( "Scrolling Banner" );
      ScrollingBanner panel = new ScrollingBanner ( 700, 700, "Emergency");
      frame.getContentPane().add ( panel );
      frame.setSize ( panel.width, panel.height );
      frame.setVisible ( true );
      frame.addWindowListener ( new WindowAdapter() {
          public void windowClosing ( WindowEvent evt ) {
              System.exit ( 0 );
          }
      } );
  }
}
