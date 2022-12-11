package q3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import gui.AquaPanel;

public class Jellyfish extends Swimmable {
	///********************Fields*****************************///
	private static final int  EAT_DISTANCE=10;
	///********************Constructors*****************************///
	public Jellyfish(AquaPanel panel) {
		super(panel);
	}
	public Jellyfish(int size,Color color,int hSpeed, int vSpeedr, int x,int y,AquaPanel panel) {
		super(size,color,hSpeed,vSpeedr,x,y,panel);
	}
	
	///********************Getters And Setters*****************************///
	public int getEatDistsnce() {
		return EAT_DISTANCE;
	}
	///********************Methods*****************************///
	public void drawAnimal(Graphics g) {
		int numLegs;
		 if(size<40)
		 numLegs = 5;
		 else if(size<80)
		 numLegs = 9;
		 else
		 numLegs = 12;
		 g.setColor(color);
		 g.fillArc(x- size/2, y - size/4, size, size/2, 0, 180);

		 for(int i=0; i<numLegs; i++)
		g.drawLine(x- size/2 + size/numLegs + size*i/(numLegs+1),
		y, x - size/2 + size/numLegs + size*i/(numLegs+1),
		y+size/3);
		
	}



}