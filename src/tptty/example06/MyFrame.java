package tptty.example06;

import java.awt.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	Container frame = this.getContentPane();
	
	public MyFrame() {
		this("202110547 황윤선");
	}

	public MyFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
		MyLabel label = new MyLabel();
		frame.add(label, BorderLayout.NORTH);
		
		
	}

}

@SuppressWarnings("serial")
class MyLabel extends JLabel implements Runnable{
	//기존 클래스와는 별도로 시간을 갱신하는 Label
	
	SimpleDateFormat time = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	//위와 같은 형태로 데이터 출력
	
	MyLabel(){
		this.setFont(new Font("궁서체", Font.BOLD, 24));
		this.setOpaque(true);
		this.setBackground(Color.GREEN);
		this.setHorizontalAlignment(CENTER); //글자가 들어오면 CENTER에 정렬
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		while (true) {
			
			this.setText(time.format(Calendar.getInstance().getTime())); // 시간정보가져온 것을 위의 데이터포맷에 맞추기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
