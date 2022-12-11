package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	////Singleton ActionListener
	private AquaPanel panel;
	
	  private static MyActionListener myActionListener_instance = null;
	  private MyActionListener(AquaPanel panel) {
		  this.panel=panel;
	  }
	  
	  public static MyActionListener getInstance(AquaPanel panel)
	    {
	        if (myActionListener_instance == null)
	        	myActionListener_instance = new MyActionListener(panel);
	  
	        return myActionListener_instance;
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		
		
		switch(command){
		case "Light Blue":
			panel.changeBackground(1);
			break;
		case "Deep Blue":
			panel.changeBackground(2);
			break;	
		case "Dark Blue":
			panel.changeBackground(3);
			break;
		case "Image":
			panel.changeBackground(4);
			break;
			
			
		case "None":
			panel.changeBackground(0);
			break;
			
		case "Add Animal":
			panel.openAddAnimalDaialog();
			break;	
			
		case "Food":
			panel.addFood();
			break;	
		
		
		}
		
		
	}

}
