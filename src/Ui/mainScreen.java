package Ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class mainScreen extends JFrame implements ActionListener{
	public mainScreen() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated constructor stub
		this.setSize(200, 200);
		this.setLayout(null);
		JButton buttonOpen = new JButton("Open File");
		buttonOpen.setBounds(40, 50, 100, 50);
		buttonOpen.addActionListener(this);
		this.add(buttonOpen);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Open File"){
			this.dispose();
			try {
				try {
					new fileSelectorScreen();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
