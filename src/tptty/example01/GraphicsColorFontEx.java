package tptty.example01;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GraphicsColorFontEx extends JFrame {

	Container contentPane;
	GraphicsColorFontEx(){
		setTitle("Color, Font 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(350,450);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//한번 색상이 변경되면 다른 색상으로 바뀌기 전까지 색상 유지
			g.setColor(Color.BLUE); //색상 디폴트 : BLACK
			g.drawString("I Love Java.~~", 30, 30);
			
			g.setColor(new Color(255,0,0)); //빨간색
			g.setFont(new Font("Arial", Font.ITALIC, 30)); //폰트적용
			g.drawString("How much?", 30, 60);
			
			g.setColor(new Color(0x00ff00ff)); //색상변경
			for(int i=1;i<=5;i++) {
				g.setFont(new Font("Jokerman", Font.ITALIC, i*10));
				g.drawString("This much!!", 30, 60+i*60);
			}
		}
		
	}
	public static void main(String[] args) {
		new GraphicsColorFontEx();

	}

}
