package tptty.example05;

import javax.swing.*;

public class TimerThread extends Thread {
	//public class TimerRunnable implements Runnable : Runnable 인터페이스를 사용해 스레드 구현
	private JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		super.run();
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n)); //n을 문자열로 변경한 후, Label에 넣기
			n++;
			try {Thread.sleep(1000);}catch(InterruptedException e) {return;}
		}
	}
	
}
