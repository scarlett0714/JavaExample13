package tptty.example01;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class paintJPanelEx extends JFrame {

	Container contentPane;
	paintJPanelEx(){
		setTitle("JPanel Component 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel(); //패널생성 후
		contentPane.add(panel, BorderLayout.CENTER); //패널을 프레임에 부착
		setSize(250,200);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		//JPanel : 1. 컴포넌트를 부착시키는 컨테이너 용도 2. 그림을 그리는 캔버스 용도
		public void paintComponent(Graphics g) { //paintComponent 오버라이딩
			super.paintComponent(g); //기존 부모의 방식으로 펜을 들고 그림
			g.setColor(Color.BLUE); //펜 색깔 지정
			g.drawRect(10, 10, 50, 50); //(x, y, 너비, 높이)
			g.drawRect(50, 50, 50, 50);
			g.drawRect(90, 90, 50, 50);
		}
	}
	
	public static void main(String[] args) {
		new paintJPanelEx();

	}

}
