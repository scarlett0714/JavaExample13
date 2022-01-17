package tptty.example01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawImageEx1 extends JFrame {
	Container contentPane;
	GraphicsDrawImageEx1(){
		setTitle("drawImage 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300,400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		ImageIcon imageIcon = new ImageIcon("images/hong.jpg");
		Image image = imageIcon.getImage();
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setClip(50,20,150,150); //클리핑 영역 제한
			
			//g.drawImage(image, 20, 20, this);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			//this : 패널 크기를 가져옴
			//g.drawImage(image, 20, 20, 250, 100, 100, 50, 200, 200, this);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("SanSerif", Font.ITALIC, 40));
			g.drawString("Go gator!!",60, 150); //클리핑 영역밖을 벗어나면 글씨가 짤림
		}
		
		
	}

	public static void main(String[] args) {
		new GraphicsDrawImageEx1();

	}

}
