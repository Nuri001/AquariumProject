package gui;

import java.awt.Color;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import q3.Fish;


public class AddAnimalDialog extends JDialog implements ActionListener{
	JComboBox colorCombox;
	JComboBox animalCombox;
	JComboBox hSpeedCombox;
	JComboBox vSpeedCombox;
	JComboBox sizeCombox;
	
	JButton addAnimalButton=new JButton("Add Animal");
	JButton cancelButton=new JButton("cancel");
	
	AquaPanel panel;
	String animal;
	String color;
	int hSpeed;
	int vSpeed;
	int size;
	AddAnimalDialog(JFrame parent,AquaPanel panel){
		super(parent,"Add animal daialog");
		this.panel=panel;
		this.setSize(500,300);
		this.setLayout(null);

		this.setResizable(false);
		
		String[] animals= {"Fish","Jellyfish"};
		String[] colors= {"Black","Red","Blue","Yellow"};
		ArrayList<String> sizes = new ArrayList<String>();
		for(int i=20;i<=320;i+=10) {
			sizes.add(String.valueOf(i));		}
		
		ArrayList<String> speeds = new ArrayList<String>();
		for(int i=1;i<=20;i++) {
			speeds.add(String.valueOf(i));		}
		
		animalCombox=new JComboBox(animals);
		
		colorCombox=new JComboBox(colors);

		sizeCombox=new JComboBox(sizes.toArray());
	
		hSpeedCombox=new JComboBox(speeds.toArray());

		vSpeedCombox=new JComboBox(speeds.toArray());
	
		
		addAnimalButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		JLabel typeLabel=new JLabel("type:");
		JLabel colorLabel=new JLabel("color:");
		JLabel sizeLabel=new JLabel("size:");
		JLabel hspeedLabel=new JLabel("hspeed:");
		JLabel vspeedLabel=new JLabel("vspeed:");
		
		typeLabel.setBounds(180, 10, 50,20);
		colorLabel.setBounds(180, 40, 50,20);
		sizeLabel.setBounds(180, 70, 50,20);
		hspeedLabel.setBounds(180, 100, 50,20);
		vspeedLabel.setBounds(180, 130, 50,20);
		
		animalCombox.setBounds(230, 10, 50,20);
		colorCombox.setBounds(230, 40, 70,20);
		sizeCombox.setBounds(230, 70, 50,20);
		hSpeedCombox.setBounds(230, 100, 50,20);
		vSpeedCombox.setBounds(230, 130, 50,20);
		
		addAnimalButton.setBounds(200, 160, 100,20);
		cancelButton.setBounds(200, 190, 100,20);
		
		this.add(typeLabel);
		this.add(colorLabel);
		this.add(sizeLabel);
		this.add(hspeedLabel);
		this.add(vspeedLabel);
		this.add(animalCombox);
		this.add(colorCombox);
		this.add(sizeCombox);
		this.add(hSpeedCombox);
		this.add(vSpeedCombox);
		this.add(addAnimalButton);
		this.add(cancelButton);


		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelButton) {
			
		dispose();
			
		}
		
		if(e.getSource()==addAnimalButton) {
			animal=animalCombox.getSelectedItem().toString();
			color=colorCombox.getSelectedItem().toString();
			hSpeed=Integer.valueOf(hSpeedCombox.getSelectedItem().toString());
			vSpeed=Integer.valueOf(vSpeedCombox.getSelectedItem().toString());
			size=Integer.valueOf(sizeCombox.getSelectedItem().toString());
			panel.addAnimal(animal, color, size, vSpeed, hSpeed);

			dispose();
			}
		
	}

	

}
