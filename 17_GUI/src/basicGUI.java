import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;

public class basicGUI {

	private JFrame frmLoginDemo;
	private JTextField textFieldID;
	private JTextField textFieldPW;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					basicGUI window = new basicGUI();
					window.frmLoginDemo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public basicGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginDemo = new JFrame();
		frmLoginDemo.setResizable(false);
		frmLoginDemo.setTitle("Login Demo");
		frmLoginDemo.setBounds(100, 100, 719, 577);
		frmLoginDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginDemo.getContentPane().setLayout(null);
		
		btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// EventListener 구간, ★ Call Back 구간
				System.out.println("로그인 버튼이 클릭되면 실행되는 구간 = EventListener 불림");
				login();
			}
		});
		btnLogin.setFont(new Font("굴림", Font.BOLD, 25));
		btnLogin.setBounds(483, 118, 125, 82);
		frmLoginDemo.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778 \uB370\uBAA8");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 25, 382, 62);
		frmLoginDemo.getContentPane().add(lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("굴림", Font.BOLD, 23));
		textFieldID.setBounds(164, 118, 290, 36);
		frmLoginDemo.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldPW = new JTextField();
		textFieldPW.setFont(new Font("굴림", Font.BOLD, 23));
		textFieldPW.setColumns(10);
		textFieldPW.setBounds(164, 164, 290, 36);
		frmLoginDemo.getContentPane().add(textFieldPW);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1.setBounds(76, 118, 76, 36);
		frmLoginDemo.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2.setBounds(76, 164, 76, 36);
		frmLoginDemo.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 258, 544, 244);
		frmLoginDemo.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
	}
	
	
	void login() {
		String id = textFieldID.getText();
		String pw = textFieldPW.getText();
		
		if(id.equals("testID1") && pw.equals("1234")){
			//성공
			textArea.append("로그인에 성공하였습니다.\n");
			JOptionPane.showMessageDialog(frmLoginDemo, "로그인 성공");
			
		}else {
			//실패
			textArea.append("로그인에 실패하였습니다. 다시 시도해주세요.\n");
			textFieldPW.setText("");
			JOptionPane.showMessageDialog(frmLoginDemo, "로그인 실패");
			
		}
		
	}
}
