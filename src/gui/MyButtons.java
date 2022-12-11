package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyButtons extends JPanel{
	final int PW=1000;
	final int PH=30;
	final int BH=22;
	final int BW=100;
	
	JButton addAnimalButton=new JButton("Add Animal");
	JButton sleepButton=new JButton("Sleep");
	JButton wakeUpButton=new JButton("Wake up");
	JButton resetButton=new JButton("Reset");
	JButton foodButton=new JButton("Food");
	JButton infoButton=new JButton("Info");
	JButton exitButton=new JButton("Exit");
	

	MyButtons(ActionListener listener){
		this.setPreferredSize(new Dimension(PW,PH));
		this.setBackground(new Color(240,248,255));
		
		
		addAnimalButton.setFocusable(false);
		sleepButton.setFocusable(false);
		wakeUpButton.setFocusable(false);
		resetButton.setFocusable(false);
		foodButton.setFocusable(false);
		infoButton.setFocusable(false);
		exitButton.setFocusable(false);
		
		addAnimalButton.setPreferredSize(new Dimension(BW,BH));
		sleepButton.setPreferredSize(new Dimension(BW,BH));
		wakeUpButton.setPreferredSize(new Dimension(BW,BH));
		resetButton.setPreferredSize(new Dimension(BW,BH));
		foodButton.setPreferredSize(new Dimension(BW,BH));
		infoButton.setPreferredSize(new Dimension(BW,BH));
		exitButton.setPreferredSize(new Dimension(BW,BH));
		
		
		addAnimalButton.addActionListener(listener);
		sleepButton.addActionListener(listener);
		wakeUpButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		foodButton.addActionListener(listener);
		infoButton.addActionListener(listener);
		exitButton.addActionListener(e-> System.exit(0));

		
		this.add(addAnimalButton);
		this.add(sleepButton);
		this.add(wakeUpButton);
		this.add(resetButton);
		this.add(foodButton);
		this.add(infoButton);
		this.add(exitButton);
		
		
		
		
	}

}
