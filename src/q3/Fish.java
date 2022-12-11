package q3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import gui.AquaPanel;

public class Fish extends Swimmable {
	///********************Fields*****************************///
	private static final int  EAT_DISTANCE=10;
	///********************Constructors*****************************///
	public Fish(AquaPanel panel) {
		super(panel);
	}
	public Fish(int size,Color color,int hSpeed, int vSpeedr, int x,int y,AquaPanel panel) {
		super(size,color,hSpeed,vSpeedr,x,y,panel);
	}
	
	///********************Getters And Setters*****************************///
	public int getEatDistsnce() {
		return EAT_DISTANCE;
	}
	///********************Methods*****************************///
	public void drawAnimal(Graphics g) {
		System.out.println("draw fish");
		System.out.println(size);
		
		Color col=getColor();
		System.out.println(col);
		g.setColor(col);
		 if(x_dir==1) // fish swims to right side
		 {
		// Body of fish
		g.fillOval(x - size, y - size/4, size, size/2);
		// Tail of fish
		int[] x_t={x-size-size/4,x-size-size/4,x-size};
		int [] y_t = {y - size/4, y + size/4, y};
		 Polygon t = new Polygon(x_t,y_t,3);
		g.fillPolygon(t);
		// Eye of fish
		 Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255-
		col.getBlue()));
		g2.fillOval(x-size/5, y-size/10, size/10, size/10);

		// Mouth of fish
		if(size>70)
		 g2.setStroke(new BasicStroke(3));
		else if(size>30)
		 g2.setStroke(new BasicStroke(2));
		else
		 g2.setStroke(new BasicStroke(1));
		 g2.drawLine(x, y, x-size/10, y+size/10);
		 g2.setStroke(new BasicStroke(1));
		 }
		 else {
			// Body of fish
			 g.fillOval(x, y - size/4, size, size/2);
			 // Tail of fish
			 int[] x_t={x+size+size/4,x+size+size/4,x+size};
			 int [] y_t = {y - size/4, y + size/4, y};
			  Polygon t = new Polygon(x_t,y_t,3);
			 g.fillPolygon(t);
			// Eye of fish
			 Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255-
			col.getBlue()));
			g2.fillOval(x+size/10, y-size/10, size/10, size/10);

			// Mouth of fish
			if(size>70)
			 g2.setStroke(new BasicStroke(3));
			else if(size>30)
			 g2.setStroke(new BasicStroke(2));
			else
			 g2.setStroke(new BasicStroke(1));
			 g2.drawLine(x, y, x+size/10, y+size/10);
			 g2.setStroke(new BasicStroke(1)); 
		 }
		
	}



}
