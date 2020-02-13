package TrafficAnimationProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Random;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a [put your description here]
 *
 * @author BSU CS 121 Instructors
 * @author [put your name here]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = -1000;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.black;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		
		xOffset  = (xOffset + stepSize) % width;
		

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

		
		
		// This draws a green square. Replace it with your own object.
		int squareSide = height / 5;
		int squareY = height / 2 - squareSide / 2;
		Random rgb = new Random();
		
		
		//ground
		g.setColor(Color.green);
		g.fillRect(0, height/2+height/3, width, height);
		Color sky = new Color(0,0,50);
		
		//sky
		g.setColor(sky);
		g.fillRect(0, 0, width, height/2-height/3);
		
		//Stars
		g.setColor(Color.white);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);		
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		g.drawArc(rgb.nextInt(width), rgb.nextInt(height/2-height/3), height/1000, height/1000, 0, 360);
		
		//tractor beam
		int yellowval = rgb.nextInt(255);
		Color yellowbounce = new Color(yellowval,yellowval,0);
		g.setColor(yellowbounce);

		int[] xpoints = new int[]{xOffset+width/9,xOffset+width/11,width/3,width/2};
		int[] ypoints = new int[] {squareY+height/20,squareY+height/20,height/2+height/3,height/2+height/3};
		
		Polygon beam = new Polygon(xpoints,ypoints,4);
		g.fillPolygon(beam);
		
		//cockpit
		g.setColor(Color.blue);
		g.fillArc(xOffset+height/20, squareY-height/10,squareSide,squareSide,0,180);
		
		//craft body		
		g.setColor(Color.green);
		g.fillOval(xOffset-height/7, squareY-height/75, squareSide*3, squareSide/3);

		

		
		Color lights = new Color(rgb.nextInt(255),rgb.nextInt(255),rgb.nextInt(255));
		g.setColor(lights);

		int lightsXoffset = xOffset + height/4;

		// leftmost light
		g.fillOval(lightsXoffset, squareY, squareSide/5,squareSide/5);
		
		lightsXoffset = xOffset + height/8;
		
		//middle light
		g.fillOval(lightsXoffset, squareY, squareSide/5,squareSide/5);
		
		lightsXoffset = xOffset + height/100;
		
		//right light		
		g.fillOval(lightsXoffset, squareY, squareSide/5,squareSide/5);
		
		//avatar
		g.setColor(Color.lightGray);
		g.fillOval((width/2)-(width/9),height/2+height/5,squareSide/3,squareSide/3);
		g.fillRoundRect((width/2)-(width/9), height/2+height/4, squareSide/3, squareSide/2, width/30, height/32);
		g.fillRoundRect((width/2)-(width/9), height/2+height/3, squareSide/7, squareSide/3, width/30, height/32);
		g.fillRoundRect((width/2)-(width/12), height/2+height/3, squareSide/7, squareSide/3, width/30, height/30);
		g.fillRoundRect((width/2)-(width/8), height/2+height/4, squareSide/7, squareSide/3, width/30, height/32);
		g.fillRoundRect((width/2)-(width/15), height/2+height/4, squareSide/7, squareSide/3, width/30, height/32);
		
		//cornstalks
		Color husk = new Color(0,100,0);
		Color corn = new Color(175,175,0);
		int stemXoffset = width/3;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = width/3 + width/2;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);

		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		stemXoffset = stemXoffset - width/20;
		
		g.setColor(husk);
		g.fillRoundRect(stemXoffset, height/2+height/5, squareSide/20, squareSide, width/50, height/50);
		g.fillArc(stemXoffset-width/70,height/2+height/4,width/30,width/20,135,270);
				
		
		g.setColor(corn);
		g.drawLine(stemXoffset+width/250, height/2+height/6, stemXoffset+width/250, height/2+height/5);
		g.drawLine(stemXoffset-width/100, height/2+height/5, stemXoffset+width/50, height/2+height/5);
		g.fillOval(stemXoffset-width/300, height/2+height/4, height/50, height/20);
		
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
