package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuBar extends JMenuBar{
	
	JMenu fileMenu;
	JMenu backgroundMenu;
	JMenu helpMenu;
	JMenuItem exitMI;
	JMenuItem lightBluMI;
	JMenuItem darkBluMI;
	JMenuItem deepBlueMI;
	JMenuItem noneMI;
	JMenuItem imgMI;
	JMenuItem helpMI;

	MenuBar(ActionListener listener){
	
		this.setBackground(new Color(240,248,255));
		fileMenu=new JMenu("File");
		backgroundMenu=new JMenu("Background");
		helpMenu=new JMenu("Help");
		exitMI=new JMenuItem("Exit");
		lightBluMI=new JMenuItem("Light Blue");
		darkBluMI=new JMenuItem("Dark Blue");
		deepBlueMI=new JMenuItem("Deep Blue");
		noneMI=new JMenuItem("None");
		helpMI=new JMenuItem("Help");
		imgMI=new JMenuItem("Image");
		
		exitMI.addActionListener(e-> System.exit(0));
		lightBluMI.addActionListener(listener );
		noneMI.addActionListener(listener );
		darkBluMI.addActionListener(listener );
		deepBlueMI.addActionListener(listener );
		imgMI.addActionListener(listener );
		helpMI.addActionListener(e->JOptionPane.showMessageDialog(null,"Aquarum project using gui & threda","message",JOptionPane.INFORMATION_MESSAGE) );
		
		backgroundMenu.add(deepBlueMI);
		backgroundMenu.add(lightBluMI);
		backgroundMenu.add(darkBluMI);
		backgroundMenu.add(imgMI);
		backgroundMenu.add(noneMI);
		fileMenu.add(exitMI);
		helpMenu.add(helpMI);
		this.add(fileMenu);
		this.add(backgroundMenu);
		this.add(helpMenu);
		
	}
	

}
