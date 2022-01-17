package tptty.example02;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	Container frame = this.getContentPane();
	MyPanel panel;
	public MyFrame() {
		this("202110547 황윤선");
	}

	public MyFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
		panel = new MyPanel();
		frame.add(panel, BorderLayout.CENTER);
		
	}
	
	

}
