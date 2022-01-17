package tptty.example10;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TabAndThreadEx extends JFrame {
	MyLabel bar = new MyLabel(100); // 100사이즈의 바 생성

	TabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);
		c.add(bar);

		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				bar.fill();
			}

		});
		setSize(350, 200);
		setVisible(true);

		c.requestFocus();
		ConsumerThread th = new ConsumerThread(bar);
		th.start();

	}

	public static void main(String[] args) {
		new TabAndThreadEx("아무키나 빨리 눌러 바 채우기");

	}

}

@SuppressWarnings("serial")
class MyLabel extends JLabel {
	// 공유메모리
	int barSize = 0; // 아무키나 눌렀을 때 증감하는 바의 크기
	int maxBarSize;

	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) (this.getWidth())) / maxBarSize * barSize);
		if (width == 0)
			return;
		g.fillRect(0, 0, width, this.getHeight());
	}

	// 임계 영역
	synchronized void fill() {
		if (barSize == maxBarSize) {
			try {
				wait(); // 더이상 증가할 수 없으므로 wait
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();
		notify(); //wait상태에 있는 스레드를 꺠움
	}

	synchronized void consume() {
		if (barSize == 0) {
			try {
				wait(); //더 이상 줄어들 바가 없으니 wait
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint();
		notify();
	}

}

class ConsumerThread extends Thread {
	MyLabel bar;

	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
				bar.consume();
			} catch (InterruptedException e) {
				return;
			}

		}
	}

}
