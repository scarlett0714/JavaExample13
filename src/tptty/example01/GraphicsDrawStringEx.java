package tptty.example01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawStringEx extends JFrame {

	Container contentPane;
	GraphicsDrawStringEx(){
		setTitle("drawString 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(250,200);
		setVisible(true);
	}
	
	//기존에는 JLabel를 이용해서 문자열 출력
	class MyPanel extends JPanel{

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밌다.~~", 30, 30); //(문자열, x, y) (x,y)가 문자열의 상단이 아니라 하단
			g.drawString("얼마나? 하늘만큼 땅만큼 !!!!", 60, 60);
		}
		
	}
	public static void main(String[] args) {
		new GraphicsDrawStringEx();

	}

}
