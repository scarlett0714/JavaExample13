//마우스를 이용한 선 그리기(repaint() 이용)
package tptty.example03;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GraphicsDrawLineMouseEx extends JFrame {
	Container contentPane;
	GraphicsDrawLineMouseEx(){
		setTitle("Drawing Ling by Mouse 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		Vector<Point> vs = new Vector<Point>();
		Vector<Point> ve = new Vector<Point>();
		
		Point startP = null;
		Point endP = null;
		
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					startP = e.getPoint();
				}
				
				public void mouseReleased(MouseEvent e) {
					endP = e.getPoint();
					vs.add(startP);
					ve.add(endP);
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for(int i=0;i<vs.size();i++) {
				Point s = vs.elementAt(i);
				Point e = ve.elementAt(i);
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();

	}

}
