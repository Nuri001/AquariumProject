package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import q3.*;


import javax.swing.*;


public class AquaFrame extends JFrame {

	AquaPanel panel;
	MenuBar menuBar;
	

	AquaFrame(){
		panel=new AquaPanel();
		MyActionListener listener=MyActionListener.getInstance(panel);
		 
		menuBar=new MenuBar(listener);
		
		 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("my Aquarium");
		
		this.getContentPane().setBackground(Color.blue);
		this.setResizable(false);
		this.add(panel);
		
		this.setJMenuBar(menuBar);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
		
		
	
	public static void main(String[] args) {
		
		new AquaFrame();
	
	}

}
