package tptty.example02;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyPanel extends JPanel { //이미지를 출력하는 패널

	ImageIcon imageIcon = new ImageIcon("images/Back.jpg");
	Image image = imageIcon.getImage();
	
	int xpos = 100;
	int ypos = 100;
	
	
	
	public MyPanel() {
		super();
		this.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				xpos = e.getX();
				ypos = e.getY();
				repaint();
			}
			
		});
	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setClip(xpos,ypos,100,100);
		
		//g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 0, 0, image.getWidth(null), image.getHeight(null), this);
		//g.drawImage(image, 25, 25, this.getWidth()-25, this.getHeight()-25, 0, 0, image.getWidth(null), image.getHeight(null), this);
		g.drawImage(image, 25, 25, this.getWidth()-25, this.getHeight()-25, 100, 100, image.getWidth(null)-200, image.getHeight(null)-200, this);
	}
	
	
	

}
