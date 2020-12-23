import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3.setText("");
			}
		});
		textField.setBounds(114, 137, 318, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_4.setText("");
			}
		});
		passwordField.setBounds(114, 260, 318, 40);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(114, 98, 251, 40);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(114, 221, 251, 40);
		contentPane.add(lblPassword);
		
		btnNewButton = new JButton("Login Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText();
				String pass=passwordField.getText();
				if ("admin".equals(user)) {
					if ("12345".equals(pass)) {
						disable();
						LibraryFrontPage frame = new LibraryFrontPage();
						frame.setVisible(true);
						System.out.println("Welcome to page");
					}else {
						lblNewLabel_4.setText("Password Wrong.....");
						textField.setText("");
					}
				}else {
					lblNewLabel_3.setText("User Name Wrong......");
					passwordField.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(159, 336, 226, 40);
		contentPane.add(btnNewButton);
		
		ImageIcon img=new ImageIcon("/user.jpg");
		Image i =img.getImage();
		Image new_image = i.getScaledInstance( 69, 64, Image.SCALE_SMOOTH);
		
		img = new ImageIcon(new_image);
		
		lblNewLabel_1 = new JLabel("",img,JLabel.CENTER);
		lblNewLabel_1.setBounds(41, 113, 69, 64);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon img1=new ImageIcon("/pass.jpg");
		Image i1 =img1.getImage();
		Image new_image1 = i1.getScaledInstance( 69, 64, Image.SCALE_SMOOTH);
		
		img1 = new ImageIcon(new_image1);
		
		lblNewLabel_2 = new JLabel("",img1,JLabel.CENTER);
		lblNewLabel_2.setBounds(41, 236, 69, 64);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(114, 177, 236, 22);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(114, 303, 236, 22);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Welcome To Library Management ");
		lblNewLabel_5.setForeground(Color.CYAN);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setBounds(59, 11, 409, 64);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(new Color(204, 255, 204));
		lblNewLabel_6.setForeground(new Color(204, 255, 204));
		lblNewLabel_6.setBounds(0, 0, 530, 424);
		contentPane.add(lblNewLabel_6);
	}
}
