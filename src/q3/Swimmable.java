package q3;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.CyclicBarrier;

import gui.AquaPanel;

public abstract class Swimmable extends Thread {
	///********************Fields*****************************///
	public static boolean food=false;
	final int PANEL_WIDTH=1000;
	final int PANEL_HIGHT=800;
	protected AquaPanel panel;
	protected int size;
	protected Color color;	
	protected int hSpeed; //horizontal speed *x*
	protected int vSpeed; //vertical speed *y*
	protected int x;
	protected int y;
	protected int x_dir; //x direction *1-right -1-left 0->stay*
	protected int y_dir;//y direction *(1)->up (-1)->down 0->stay*
	protected int eatCount;
	
	///********************Constructors*****************************///
	public Swimmable( AquaPanel panel) {
		setSize(100);
		setColor(Color.WHITE);
		sethSpeed(0);
		setvSpeed(0);
		setX(50);
		setY(50);
		setX_dir(1);
		setY_dir(1);
		setEatCount(0);
		this.panel=panel;
	}
	
	public Swimmable(int size,Color color,int hSpeed, int vSpeedr, int x,int y, AquaPanel panel) {
		setSize(size);
		setColor(color);
		sethSpeed(hSpeed);
		setvSpeed(vSpeedr);
		setX(x);
		setY(y);
		setX_dir(1);
		setY_dir(1);
		setEatCount(0);	
		this.panel=panel;
	}
	
	///********************Declaration of methods*****************************///
	abstract public  void drawAnimal(Graphics g);
	abstract public  int getEatDistsnce();
		
	///********************Getters And Setters*****************************///
	public int gethSpeed() {
		return hSpeed;
	}
	public void sethSpeed(int hSpeed) {
		this.hSpeed = hSpeed;
	}
	public int getvSpeed() {
		return vSpeed;
	}
	public void setvSpeed(int vSpeed) {
		this.vSpeed = vSpeed;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getEatCount() {
		return eatCount;
	}
	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX_dir() {
		return x_dir;
	}
	public void setX_dir(int x_dir) {
		this.x_dir = x_dir;
	}
	public int getY_dir() {
		return y_dir;
	}
	public void setY_dir(int y_dir) {
		this.y_dir = y_dir;
	}
	
	///********************Methods*****************************///
	
	@Override
	public String toString() {
		return " Swimabble \nsize:"+ size+"\ncolor:"+color.toString()+"\nspeed: "+hSpeed+","+vSpeed +"\npoint("+x+","+y+")";
	}
	
	public void eatInc() {
		 
		int eatDistance=getEatDistsnce();
		eatCount++;
		if(eatCount>=eatDistance) {
			eatCount=0;
			setSize(size+=1);
		}
		
	}
	
	public void run() {
		while(true) {
			if(food) chaseFood() ;
			else swim();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.repaint();			
		}
		
	}
	public boolean checkPoint() {
		if(x>=495 && x<=505)x_dir=0;
		else if(x<495) x_dir=1;
		else if(x>505) x_dir=-1;
		if(y>=395 && y<=405)y_dir=0;
		else if(y<395) y_dir=1;
		else if(y>405) y_dir=-1;
		if(x_dir==0&& y_dir==0) return true;
		else return false;
	}
	
	public void cuntinue() {
		x_dir=1;
		y_dir=1;
	}
	
	public void chaseFood() {
		
		if(checkPoint()) {	
			  System.out.println("here there is a swimmer got to the food point");
			  panel.eatFood(this);
			  
			  
		}
		else {
			if(x_dir==1) x+=hSpeed;
			if(x_dir==-1) x-=hSpeed;
			if(y_dir==1) y+=vSpeed;
			if(y_dir==-1) y-=vSpeed;	
			
		}
	}
	
	public void swim()  {
		if(x>PANEL_WIDTH || x<size) x_dir=-1;
		if(y>PANEL_HIGHT-30-size || y<size) y_dir*=-1;
		if(x_dir==1) x+=1;
		if(x_dir==-1) x-=1;
		if(y_dir==1) y+=vSpeed;
		if(y_dir==-1) y-=vSpeed;

	}
	
	

}
