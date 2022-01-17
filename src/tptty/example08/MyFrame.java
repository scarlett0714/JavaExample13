package tptty.example08;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	Container frame = this.getContentPane();
	GamePanel panel = new GamePanel();
	MusicThread mp3th;
	
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
		frame.add(panel, BorderLayout.CENTER);
		panel.setFocusable(true); //panel은 원래 keyevent를 받을 수 없음 -> 받을 수 있게 변경
		panel.requestFocus(); //패널에 focus를 가진상태
		
		
		
		mp3th = new MusicThread();
		mp3th.start();
		
	}
	
	class MusicThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true) {
				try {
					FileInputStream fis = new FileInputStream("bgm/01.mp3");
					Player player = new Player(fis);
					player.play();
				} catch (FileNotFoundException | JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	class GamePanel extends JPanel{
		
		String[] img = {"images/Down.png", "images/Left.png", "images/Right.png", "images/Up.png", "images/char1.png"};
		ImageIcon[] icons = new ImageIcon[img.length];
		
		JLabel avatar;
		JLabel monster;
		
		final int AVATAR_MOVE = 10;
		final int MONSTER_MOVE = 5;
		Point pos = new Point(50,50);
		Point mpos = new Point(250,50);
		
		public GamePanel() {
			for(int i=0;i<icons.length;i++) {
				icons[i] = new ImageIcon(img[i]);
			}
			avatar = new JLabel(icons[0]);
			this.setLayout(null); //this : panel
			this.setBackground(Color.WHITE);
			
			//layout이 없으므로 위치와 사이즈 지정
			avatar.setLocation(pos);
			avatar.setSize(icons[0].getIconWidth(), icons[0].getIconHeight());
			this.addKeyListener(new MyKeyListener());
			this.add(avatar);
			
			monster = new JLabel(icons[img.length-1]);
			monster.setLocation(mpos);
			monster.setSize(icons[img.length-1].getIconWidth(), icons[img.length-1].getIconHeight());
			this.add(monster);
			
			MonsterThread monsterth = new MonsterThread();
			monsterth.start();
			
		}
		
		class MonsterThread extends Thread{
			private boolean flag = false;
			void finish() {
				flag = true;
			}
			

			@Override
			public void run() {
				super.run();
				while(true) {
					if(avatar.getX() < monster.getX()) {
						mpos.x -= MONSTER_MOVE;
					}else
						mpos.x += MONSTER_MOVE;
					if(avatar.getY() < monster.getY()) {
						mpos.y -= MONSTER_MOVE;
					}else
						mpos.y += MONSTER_MOVE;
					
					monster.setLocation(mpos);
					monster.repaint();
					try {
						Thread.sleep(500);
						if(mpos.x == pos.x & mpos.y == mpos.y) {
							JOptionPane.showMessageDialog(frame, "몬스터에게 잡혔습니다. 게임종료합니다.");
							finish();
							if(flag==true) {
							break;}
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
		class MyKeyListener extends KeyAdapter {

			@Override
			public void keyPressed(KeyEvent e) {
				
				super.keyPressed(e);
				switch(e.getKeyCode()){
					case KeyEvent.VK_DOWN:
						pos.y = pos.y +AVATAR_MOVE;
						avatar.setIcon(icons[0]);
						break;
					case KeyEvent.VK_LEFT:
						pos.x = pos.x -AVATAR_MOVE;
						avatar.setIcon(icons[1]);
						break;
					case KeyEvent.VK_RIGHT:
						pos.x = pos.x +AVATAR_MOVE;
						avatar.setIcon(icons[2]);
						break;
					case KeyEvent.VK_UP:
						pos.y = pos.y -AVATAR_MOVE;
						avatar.setIcon(icons[3]);
						break;
						
				}
				avatar.setLocation(pos);
				avatar.repaint();
			}
			
		}
		
	}
}
