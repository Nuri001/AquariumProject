package q3;

import java.awt.Color;
import java.awt.Graphics;

import gui.AquaPanel;
import gui.MyActionListener;

public class Food {
	////Singleton Class
	  private static Food  food_instance = null;
	  private boolean appears =false;
	  int size;
	  private Food() {
		 size=50;
	  }
	  
	  public static Food  getInstance()
	    {
	        if (food_instance == null)
	        	food_instance = new Food();
	  
	        return food_instance;
	    }
	  
	  
	  public boolean getAppears() {
		  return appears;
	  }
	  public void setAppears(boolean b) {
		  appears=b;
	  }
	  public void drawFood(Graphics g) {
			 g.setColor(Color.orange);
			 g.fillOval(500, 400, size, size);

		}
	  
	  public synchronized boolean eatFood(Swimmable s) {
		  if(appears) {
			s.eatInc();  
			System.out.println(s.toString()+"\n has been eaten");
			size--;
			if(size<=0) {
				appears=false;
				size=50;
				
				return true;
			}
			
		  }
		  
       return false;
	  }

}
