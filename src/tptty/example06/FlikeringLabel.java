package tptty.example06;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlikeringLabel extends JLabel implements Runnable{

	private long delay;
	
	
	public FlikeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true); //색상을 변경하기 위해
		Thread th = new Thread(this); //this : Runnable객체
		th.start();
	}


	@Override
	public void run() {
		int n=0;
		while(true) {
			if(n==0) { //n의 값이 바뀌면서 색상변경
				setBackground(Color.YELLOW);
			} else
				setBackground(Color.GREEN);
			if(n==0)
				n=1;
			else
				n=0;
			try {Thread.sleep(delay);
			}catch(InterruptedException e) {
				return;
			}
		}
		
	}

}
