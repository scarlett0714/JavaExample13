package tptty.example01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicsDrawEx extends JFrame {

	Container contentPane;
	GraphicsDrawEx(){
		setTitle("draw 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(350,450);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(20, 20, 100, 100); //(시작x, y, 끝x, y)
			g.drawOval(20, 20, 80, 80); //(시작x, y, 너비, 높이)인 사각형에 내접하는 (타)원
			g.drawRect(20, 20, 80, 80); //(시작x, y, 너비, 높이)인 사각형
			g.drawRoundRect(20, 20, 120, 80, 40, 60); //(시작x, y, 너비, 높이, 둥글게 수평반지름, 둥글게 수직반지름)인 사각형
			g.drawArc(20, 100, 80, 80, 90, 270); //(시작x, y, 너비, 높이, 원호 시작각도, 원호 각도)인 원호
			//각도가 + :반시계방향, - :시계방향
			int[] x = {80,40,80,120};
			int[] y = {40,120,200,120};
			g.drawPolygon(x,y,4); //좌표 짝짓기 (80,40) (40,120) ... -> 점들을 연결하여 폐다각형 그리기
			
			//내부칠하기 : 메소드명을 draw대신 fill로 변경
		}
		
	}
	
	public static void main(String[] args) {
		new GraphicsDrawEx();

	}

}
