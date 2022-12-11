package gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.lang.reflect.Field;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import q3.Fish;
import q3.Food;
import utilities.MyFunctions;
import q3.Jellyfish;
import q3.Swimmable;

public class AquaPanel  extends JPanel  {
	final int PANEL_WIDTH=1000;
	final int PANEL_HIGHT=800;
	final Color LIGHT_BLUE=new Color(135,206,250);
	final Color DEEP_BLUE=new Color(0,191,255);
	final Color DARK_BLUE=new Color(0,0,139);
	final Color NO_COLOR=new Color(136,136,136);
	MyActionListener listener=MyActionListener.getInstance(this);
	Food food=Food.getInstance();
	Image backgroundImage;
	Boolean imagebackground=false;
	Boolean swimming=true;
	MyButtons buttons;
	HashSet<Swimmable> set=new HashSet<Swimmable>();
	int x=500;
	int y=500;
	int numberOfSwimmables=0;
	
	 
	AquaPanel (){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HIGHT));
		this.setBackground(LIGHT_BLUE);
		buttons=new MyButtons(listener);
		backgroundImage=new ImageIcon("img.jpg").getImage();
		 setLayout(new BorderLayout());
	
		
		this.add(buttons,BorderLayout.SOUTH);
		
	
	}
	
	public void eatFood(Swimmable s) {
		if(food.eatFood(s)) {
			Swimmable.food=false;
			for (Swimmable sw : set) {
				sw.cuntinue();
			}
		}

	}
	
	  @Override
	public void paint(Graphics g) {

		super.paint(g); 
		Graphics2D g2D=(Graphics2D) g;
		if(imagebackground) {
		  g2D.drawImage(backgroundImage,0,0,PANEL_WIDTH,PANEL_HIGHT-30,null);
		}
		if(food.getAppears()) {
			food.drawFood(g2D);
		}
		for(Swimmable s: set) {
			//System.out.println(s.toString());
			s.drawAnimal(g);
			
		}

	 }
	  
	public void changeBackground(int num) {
		switch (num) {
		case 0:
			this.setBackground(NO_COLOR);
			imagebackground=false;
			break;
		case 1:
			this.setBackground(LIGHT_BLUE);
			imagebackground=false;
			break;
		case 2:
			this.setBackground(DEEP_BLUE);
			imagebackground=false;
			break;
			
		case 3:
			this.setBackground(DARK_BLUE);
			imagebackground=false;
			break;
		case 4:
			imagebackground=true;
			break;
			
		}
		
		repaint();

	}

   public void openAddAnimalDaialog() {
	   
	   if(numberOfSwimmables>=5) {
			JOptionPane.showMessageDialog(null,"The Aquarum cannot contain more than 5 Swimmabels","message",JOptionPane.ERROR_MESSAGE) ;
			
		}
		else {
			JFrame frame=new JFrame();
			new AddAnimalDialog(frame,this);
		}
	
	
    }

   
   public void addAnimal(String type, String color, int size, int vS, int hS) {
	   System.out.println("new swimamble:-->>");
	   System.out.println("color: "+color);
	   Color c=MyFunctions.stringToColor(color);
	   Swimmable newSwimmable=null;

	   if(type=="Fish") newSwimmable=new Fish(size,c,hS,vS,x+50*numberOfSwimmables,y+50*numberOfSwimmables,this);
		
       if(type=="Jellyfish") newSwimmable=new Jellyfish(size,c,hS,vS,x+50*numberOfSwimmables,y+50*numberOfSwimmables,this);
		
       if(newSwimmable!=null)set.add(newSwimmable);
       newSwimmable.start();
      
      numberOfSwimmables++;
     
	   repaint();
	   
   }
 
   public void swimming() {
	   
	   if(swimming) {
		   for(Swimmable s: set) {
				//System.out.println(s.toString());
				s.swim();
				
			}
		   repaint();
	   }
	   
	   
	   
	   
   }

   public void addFood() {
	   food.setAppears(true);
	   Swimmable.food=true;
	   
	   

	   
   }


	}
	
	
	
	

	
	

	
	
	


