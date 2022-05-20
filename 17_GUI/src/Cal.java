import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cal {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cal window = new Cal();
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
	public Cal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("±¼¸²", Font.BOLD, 60));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("0");
		textField.setBounds(25, 23, 471, 88);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		ActionListener numberListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String addNum = ((JButton) e.getSource()).getText();
				text += addNum;
				long value = 0;
				try {
					value = Long.parseLong(text);
				} catch (Exception e2) {
					
				}
				textField.setText("" + value);
			}
		};
		
		
		
		JButton btnButtonClear = new JButton("C");
		btnButtonClear.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButtonClear.setBounds(25, 156, 105, 107);
		frame.getContentPane().add(btnButtonClear);
		
		JButton btnButton0 = new JButton("0");
		btnButton0.addActionListener(numberListener);
		btnButton0.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton0.setBounds(142, 156, 105, 107);
		frame.getContentPane().add(btnButton0);
		
		JButton btnNewButton_2 = new JButton("=");
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnNewButton_2.setBounds(259, 156, 105, 107);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnButtonPlus = new JButton("+");
		btnButtonPlus.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButtonPlus.setBounds(376, 156, 105, 107);
		frame.getContentPane().add(btnButtonPlus);
		
		JButton btnButton7 = new JButton("7");
		btnButton7.addActionListener(numberListener);
		btnButton7.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton7.setBounds(25, 282, 105, 107);
		frame.getContentPane().add(btnButton7);
		
		JButton btnButton8 = new JButton("8");
		btnButton8.addActionListener(numberListener);
		btnButton8.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton8.setBounds(142, 282, 105, 107);
		frame.getContentPane().add(btnButton8);
		
		JButton btnButton9 = new JButton("9");
		btnButton9.addActionListener(numberListener);
		btnButton9.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton9.setBounds(259, 282, 105, 107);
		frame.getContentPane().add(btnButton9);
		
		JButton btnButtonMinus = new JButton("-");
		btnButtonMinus.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButtonMinus.setBounds(376, 282, 105, 107);
		frame.getContentPane().add(btnButtonMinus);
		
		JButton btnButton4 = new JButton("4");
		btnButton4.addActionListener(numberListener);
		btnButton4.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton4.setBounds(25, 403, 105, 107);
		frame.getContentPane().add(btnButton4);
		
		JButton btnButton5 = new JButton("5");
		btnButton5.addActionListener(numberListener);
		btnButton5.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton5.setBounds(142, 403, 105, 107);
		frame.getContentPane().add(btnButton5);
		
		JButton btnButton6 = new JButton("6");
		btnButton6.addActionListener(numberListener);
		btnButton6.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton6.setBounds(259, 403, 105, 107);
		frame.getContentPane().add(btnButton6);
		
		JButton btnButtonMulti = new JButton("X");
		btnButtonMulti.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButtonMulti.setBounds(376, 403, 105, 107);
		frame.getContentPane().add(btnButtonMulti);
		
		JButton btnButton1 = new JButton("1");
		btnButton1.addActionListener(numberListener);
		btnButton1.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton1.setBounds(25, 520, 105, 107);
		frame.getContentPane().add(btnButton1);
		
		JButton btnButton2 = new JButton("2");
		btnButton2.addActionListener(numberListener);
		btnButton2.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton2.setBounds(142, 520, 105, 107);
		frame.getContentPane().add(btnButton2);
		
		JButton btnButton3 = new JButton("3");
		btnButton3.addActionListener(numberListener);
		btnButton3.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButton3.setBounds(259, 520, 105, 107);
		frame.getContentPane().add(btnButton3);
		
		JButton btnButtondivid = new JButton("/");
		btnButtondivid.setFont(new Font("SansSerif", Font.BOLD, 60));
		btnButtondivid.setBounds(376, 520, 105, 107);
		frame.getContentPane().add(btnButtondivid);
	}
}
