import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameGUI {
	
	private String names[] = {"ÇÏ¹Î¼ö", "±è¼®¿ø","±èÇö¹Î","À±Ã¤¿µ","ÀÌ»ó¿ø","ÀÌÇØ¼º","±¸±âÇõ",
									   "°­ÇõÈÆ","°­¼Ò¿¬","À¯³ªÀº"};
	
	private JFrame frame;
	private JLabel lblScore;
	private JLabel lblTime;
	private JLabel lblStart;
	int score = 0;
	int second = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI window = new GameGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1094, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		lblScore = new JLabel("0");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblScore.setBounds(464, 653, 163, 34);
		frame.getContentPane().add(lblScore);
		
		lblTime = new JLabel("0");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblTime.setBounds(903, 653, 163, 34);
		frame.getContentPane().add(lblTime);
		
		lblStart = new JLabel("Start");
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblStart.setBounds(741, 653, 163, 34);
		frame.getContentPane().add(lblStart);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	Random random = new Random(0);
	boolean isRun = true;
	
	List<JButton> btnList = new ArrayList<>();
	
	MouseListener mouseListner = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if(isRun == false) {
				return;
			}
			JButton btn = (JButton) e.getSource();
			btn.setVisible(false);
			btnList.remove(btn);
			frame.remove(btn);

			String neme = btn.getText();
			if(neme.equals("ÀÌÇØ¼º") == true) {
				score += 2;
			}
			if(neme.equals("ÇÏ¹Î¼ö") == true) {
				score -= 3;
			}
			score++;
			lblScore.setText(""+score);
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	};
	
	
	Thread thread1 = new Thread(new Runnable() {
		@Override
		public void run() {
			int count = 0;
			while(isRun) {
				synchronized (btnList) {
					int rVal = random.nextInt(3);
					int x = random.nextInt(1000);
					String name = names[count++ % names.length];
					if(rVal == 0) {
						JButton btnNewButton = new JButton(name);
						btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
						btnNewButton.setBounds(x, 0, 190, 143);
						btnNewButton.addMouseListener(mouseListner);
						frame.getContentPane().add(btnNewButton);
						btnList.add(btnNewButton);
					}
					
					if(rVal == 1) {
						JButton btnNewButton_1 = new JButton(name);
						btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 17));
						btnNewButton_1.setBounds(x, 0, 145, 92);
						frame.getContentPane().add(btnNewButton_1);
						btnNewButton_1.addMouseListener(mouseListner);
						btnList.add(btnNewButton_1);
					}
					
					if(rVal == 2) {
						JButton btnNewButton_1_1 = new JButton(name);
						btnNewButton_1_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
						btnNewButton_1_1.setBounds(x, 0, 94, 53);
						btnNewButton_1_1.addMouseListener(mouseListner);
						frame.getContentPane().add(btnNewButton_1_1);
						btnList.add(btnNewButton_1_1);
					}
					
	//				frame.repaint();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	});
	
	Thread thread2 = new Thread(new Runnable() {
		@Override
		public void run() {
			int count = 0;
			int ranValue1 = random.nextInt() % 5;
			int ranValue2 = random.nextInt() % 5;
			while(isRun) {
				try {
					if(count % 10 == 0) {
						ranValue1 = random.nextInt() % 5;
					}
					if(count % 5 == 0) {
						ranValue2 = random.nextInt(5);
					}
					for(JButton btn : btnList) {
						Rectangle bound = btn.getBounds();
						bound.x +=  random.nextInt(30) * ranValue1;
						if(bound.x < 0) {
							bound.x = 0;
						}
						if(bound.x > 1050) {
							bound.x = 1050;
						}
						bound.y +=  random.nextInt(40) + ranValue2;
						btn.setBounds(bound);
						if(bound.y  > 750) {
							frame.remove(btn);
							btnList.remove(btn);
						}
					}
					Thread.sleep(30);
				} catch (Exception e) {
				}
				frame.repaint();
			}
		}
	});
	
	
	Thread thread3 = new Thread(new Runnable() {
		@Override
		public void run() {
			while(isRun) {
				try {
					Thread.sleep(1000);
					++second;
					lblTime.setText(""+second);
					if(second > 60) {
						isRun = false;
					}
					lblStart.setText("END!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
}
