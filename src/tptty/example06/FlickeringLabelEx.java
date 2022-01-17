package tptty.example06;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FlickeringLabelEx extends JFrame {
	
	public FlickeringLabelEx() {
		setTitle("FlickeringLabelEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//깜박이는 레이블 생성
		FlikeringLabel fLabel = new FlikeringLabel("깜박", 500);
		
		//깜박이지 않는 레이블 생성
		JLabel label = new JLabel("안깜박");
		
		//깜박이는 레이블 생성
		FlikeringLabel fLAbel2 = new FlikeringLabel("여기도 깜박", 300);
		
		c.add(fLabel);
		c.add(label);
		c.add(fLAbel2);
		
		setSize(300,150);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new FlickeringLabelEx();
		

	}

}
