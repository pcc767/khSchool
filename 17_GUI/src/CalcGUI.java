import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcGUI {
	private JFrame frame;
	private JTextField textField;
	private long prevValue = 0;
	private String operator = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					CalcGUI window = new CalcGUI();
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
	public CalcGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 563, 618);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 50));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("0");
		textField.setBounds(17, 16, 514, 105);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		ActionListener numberListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String addStr = ((JButton)e.getSource()).getText();
				text += addStr; 
				long value = 0;
				try {
					value = Long.parseLong(text);
				} catch (Exception e2) {
				}
				textField.setText(""+value);		//문자열 연산.(value값과 ""을 더해 바로 문자열로 변환)
			}
		};
		
		ActionListener operatorListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				operator = ((JButton)e.getSource()).getText();
				try {
					prevValue = Long.parseLong(text);
				} catch (Exception e2) {
					prevValue = 0;
				}
				textField.setText("0");
			}
		};

		ActionListener equalListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				try {
					long currentValue = Long.parseLong(text);
					long result = 0;
					switch (operator) {
					case "+": 
						result = prevValue + currentValue;
						break;
					case "-": 
						result = prevValue - currentValue;
						break;
					case "x": 
						result = prevValue * currentValue;
						break;
					case "/": 
						result = prevValue / currentValue;
						break;
					default:
						result = 0;
						break;
					}
					textField.setText("" + result);
				} catch (Exception e2) {
					textField.setText("0");
				} finally {
					prevValue = 0;
					operator = null;
				}
			}
		};

		ActionListener clearListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
				prevValue = 0;
				operator = null;
			}
		};
		
		JButton btnNumber1 = new JButton("1");
		btnNumber1.addActionListener(numberListener);
		btnNumber1.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber1.setBounds(17, 147, 115, 92);
		frame.getContentPane().add(btnNumber1);
		
		JButton btnNumber2 = new JButton("2");
		btnNumber2.addActionListener(numberListener);
		btnNumber2.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber2.setBounds(144, 147, 115, 92);
		frame.getContentPane().add(btnNumber2);
		
		JButton btnNumber3 = new JButton("3");
		btnNumber3.addActionListener(numberListener);
		btnNumber3.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber3.setBounds(271, 147, 115, 92);
		frame.getContentPane().add(btnNumber3);
		
		JButton btnOperPlus = new JButton("+");
		btnOperPlus.addActionListener(operatorListener);
		btnOperPlus.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnOperPlus.setBounds(416, 147, 115, 92);
		frame.getContentPane().add(btnOperPlus);
		
		JButton btnNumber4 = new JButton("4");
		btnNumber4.addActionListener(numberListener);
		btnNumber4.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber4.setBounds(17, 251, 115, 92);
		frame.getContentPane().add(btnNumber4);
		
		JButton btnNumber5 = new JButton("5");
		btnNumber5.addActionListener(numberListener);
		btnNumber5.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber5.setBounds(144, 251, 115, 92);
		frame.getContentPane().add(btnNumber5);
		
		JButton btnNumber6 = new JButton("6");
		btnNumber6.addActionListener(numberListener);
		btnNumber6.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber6.setBounds(271, 251, 115, 92);
		frame.getContentPane().add(btnNumber6);
		
		JButton btnOperMinus = new JButton("-");
		btnOperMinus.addActionListener(operatorListener);
		btnOperMinus.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnOperMinus.setBounds(416, 251, 115, 92);
		frame.getContentPane().add(btnOperMinus);
		
		JButton btnNumber7 = new JButton("7");
		btnNumber7.addActionListener(numberListener);
		btnNumber7.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber7.setBounds(17, 355, 115, 92);
		frame.getContentPane().add(btnNumber7);
		
		JButton btnNumber8 = new JButton("8");
		btnNumber8.addActionListener(numberListener);
		btnNumber8.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber8.setBounds(144, 355, 115, 92);
		frame.getContentPane().add(btnNumber8);
		
		JButton btnNumber9 = new JButton("9");
		btnNumber9.addActionListener(numberListener);
		btnNumber9.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber9.setBounds(271, 355, 115, 92);
		frame.getContentPane().add(btnNumber9);
		
		JButton btnOperMulti = new JButton("x");
		btnOperMulti.addActionListener(operatorListener);
		btnOperMulti.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnOperMulti.setBounds(416, 355, 115, 92);
		frame.getContentPane().add(btnOperMulti);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(clearListener);
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnClear.setBounds(17, 459, 115, 92);
		frame.getContentPane().add(btnClear);
		
		JButton btnNumber0 = new JButton("0");
		btnNumber0.addActionListener(numberListener);
		btnNumber0.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnNumber0.setBounds(144, 459, 115, 92);
		frame.getContentPane().add(btnNumber0);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(equalListener);
		btnEqual.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnEqual.setBounds(271, 459, 115, 92);
		frame.getContentPane().add(btnEqual);
		
		JButton btnOperDivide = new JButton("/");
		btnOperDivide.addActionListener(operatorListener);
		btnOperDivide.setFont(new Font("SansSerif", Font.BOLD, 50));
		btnOperDivide.setBounds(416, 459, 115, 92);
		frame.getContentPane().add(btnOperDivide);
	}
}
