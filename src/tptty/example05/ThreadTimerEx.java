package tptty.example05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel);
//		Runnable 인터페이스를 이용해서 스레드 만들기
//		TimerRunnable runnable = new TimerRunnable(timerLabel);
//		Thread th = new Thread(runnable); //스레드 객체를 만들어야함
		
		//버튼을 추가해 타이머 스레드 강제 종료
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt(); //interrupt발생 -> 스레드의 catch문
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
				
			}
			
		});
		
		c.add(btn);
		setSize(300,170);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		new ThreadTimerEx();

	}

}
