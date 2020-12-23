import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;


public class LibraryFrontPage extends JFrame {

	private JPanel contentPane;
	private JPanel panelnewbook = new JPanel();
	private JTextField textField_book_number;
	private JTextField book_name;
	private JTextField textField_Author_name;
	private JTextField textField_Book_quantity;
	private JTextField textField_book_amount;
	private JPanel viewbook = new JPanel();
	private JPanel issuebook = new JPanel();
	private JPanel viewissuebook = new JPanel();
	private JPanel retrunbook = new JPanel();
	private JPanel newStudent = new JPanel();
	private JPanel student = new JPanel();
	private JTextField textField;
	private JTextField textField_Book_Number_Issue;
	private JTextField textField_BookIssue_stu_id;
	private JTextField textField_Book_Issue_stu_name;
	private JTextField textField_Book_Name_Issue;
	private JTextField textField_Issue_date;
	private JTextField textField_Issue_end;
	private JTable issue_view;
	private JTextField textField_7;
	private JTextField textField_Retrun_book_id;
	private JTextField textField_Retrun_Stu_ID;
	private JTextField textField_Retrun_issue_Date;
	private JTextField textField_stu_name;
	private JTextField textField_stu_father;
	private JTextField textField_stu_NO;
	private JTextField textField_14;
	private JTable student_view;
	private LocalDate dateset;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryFrontPage frame = new LibraryFrontPage();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	DefaultTableModel model=new DefaultTableModel();
	private JTable Book_view;
	
	public void getData() {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * From book_details");
			while(rs.next()) {
				model.addRow(new Object[] {rs.getInt(7),rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)});
			}
			
			con.close();
			
		}catch(Exception e3) {
			System.out.println(e3);
		}
	}
	
	
	// Book Issue Record...
	
	DefaultTableModel model1=new DefaultTableModel();
	public void issuebookrecord() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select * From issue_books");
			
			while (rs.next()) {
				
				model1.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)});
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Student Record ...
		
	DefaultTableModel model2=new DefaultTableModel();
	private Object DbMode;
	private JTable book_view;
	public void studentrecord() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select * From student_information");
			//student_view.setModel(((Object) DbMode).resultSetToTableModel(rs));
			while (rs.next()) {
				
				model2.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)});
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public LibraryFrontPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon img7=new ImageIcon("/icon.png");
		Image i7 =img7.getImage();
		Image new_image7 = i7.getScaledInstance(435, 298, Image.SCALE_SMOOTH);
		
		img7 = new ImageIcon(new_image7);
		viewbook.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		
		
		
		viewbook.setBounds(211, 72, 692, 497);
		contentPane.add(viewbook);
		
		
		viewbook.setBounds(211, 73, 692, 486);
		contentPane.add(viewbook);
		viewbook.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				book_view.setRowSorter(tr);
				String search=textField.getText();
				tr.setRowFilter(RowFilter.regexFilter(search, null));
			}
		});
		textField.setBounds(10, 29, 235, 43);
		viewbook.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 107, 644, 348);
		viewbook.add(scrollPane);
		
		 model.addColumn("Book ID");
		 model.addColumn("Book Number");
		 model.addColumn("Book Name"); 
		 model.addColumn("Author Name");
		 model.addColumn("Quanitity Books"); 
		 model.addColumn("Amount Book");
		 model.addColumn("Add date");
		
		
		model1.addColumn("Issue_ID");
		model1.addColumn("Book_Number");
		model1.addColumn("Book_Name");
		model1.addColumn("Student_ID");
		model1.addColumn("Student_Name");
		model1.addColumn("Issue_date");
		model1.addColumn("Issue_End");
		
		model2.addColumn("Issue ID");
		model2.addColumn("Book Number");
		model2.addColumn("Book Name");
		model2.addColumn("Student ID");
		model2.addColumn("Student Name");
		model2.addColumn("Issue date");
		model2.addColumn("Issue End");
		
		book_view = new JTable(model);
		scrollPane.setViewportView(book_view);
		
		
		
		issuebook.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		
		
		issuebook.setBounds(211, 73, 692, 486);
		contentPane.add(issuebook);
		issuebook.setLayout(null);
		
		textField_Book_Number_Issue = new JTextField();
		textField_Book_Number_Issue.setBounds(87, 66, 251, 48);
		issuebook.add(textField_Book_Number_Issue);
		textField_Book_Number_Issue.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Book Number");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(87, 34, 153, 34);
		issuebook.add(lblNewLabel_13);
		
		textField_BookIssue_stu_id = new JTextField();
		textField_BookIssue_stu_id.setBounds(87, 171, 251, 48);
		issuebook.add(textField_BookIssue_stu_id);
		textField_BookIssue_stu_id.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Sudent ID");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(87, 140, 153, 34);
		issuebook.add(lblNewLabel_14);
		
		textField_Book_Issue_stu_name = new JTextField();
		textField_Book_Issue_stu_name.setBounds(366, 171, 232, 48);
		issuebook.add(textField_Book_Issue_stu_name);
		textField_Book_Issue_stu_name.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Student Name");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_15.setBounds(366, 140, 123, 34);
		issuebook.add(lblNewLabel_15);
		
		textField_Book_Name_Issue = new JTextField();
		textField_Book_Name_Issue.setBounds(366, 66, 251, 48);
		issuebook.add(textField_Book_Name_Issue);
		textField_Book_Name_Issue.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Book Name");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(366, 34, 136, 34);
		issuebook.add(lblNewLabel_16);
		
		JButton btnNewButton_3 = new JButton("Issue ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
					PreparedStatement ptmt=conn.prepareStatement("insert into issue_books(Book_Number,Book_Name,Student_ID,Student_Name,Issue_date,Issue_End)values(?,?,?,?,?,?)");
					ptmt.setString(1, textField_Book_Number_Issue.getText());
					ptmt.setString(2, textField_Book_Name_Issue.getText());
					ptmt.setString(3, textField_BookIssue_stu_id.getText());
					ptmt.setString(4, textField_Book_Issue_stu_name.getText());
					LocalDate myObj = LocalDate.now();
					dateset = myObj;
					//textField_Issue_date.setText(String.valueOf(dateset));
					ptmt.setString(5, String.valueOf(dateset));
					ptmt.setString(6, textField_Issue_end.getText());
					
					ptmt.executeUpdate();
					conn.close();
					textField_Book_Number_Issue.setText("");
					textField_Book_Name_Issue.setText("");
					textField_BookIssue_stu_id.setText("");
					textField_Book_Issue_stu_name.setText("");
					textField_Issue_end.setText("");
					issuebookrecord();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_3.setBounds(149, 393, 178, 39);
		issuebook.add(btnNewButton_3);
		
		JLabel lblNewLabel_17 = new JLabel("Issue Date");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_17.setBounds(87, 249, 162, 21);
		issuebook.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Issue End");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_18.setBounds(366, 249, 172, 21);
		issuebook.add(lblNewLabel_18);
		
		textField_Issue_date = new JTextField();
		textField_Issue_date.setBounds(87, 272, 153, 37);
		issuebook.add(textField_Issue_date);
		textField_Issue_date.setColumns(10);
		
		textField_Issue_end = new JTextField();
		textField_Issue_end.setBounds(366, 275, 136, 34);
		issuebook.add(textField_Issue_end);
		textField_Issue_end.setColumns(10);
		panelnewbook.setBackground(SystemColor.inactiveCaption);
		
		
		panelnewbook.setBounds(211, 72, 692, 497);
		contentPane.add(panelnewbook);
		panelnewbook.setLayout(null);
		
		textField_book_number = new JTextField();
		textField_book_number.setBounds(76, 94, 188, 29);
		panelnewbook.add(textField_book_number);
		textField_book_number.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Book Number ");
		lblNewLabel_8.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(76, 65, 147, 29);
		panelnewbook.add(lblNewLabel_8);
		
		book_name = new JTextField();
		book_name.setBounds(287, 94, 188, 29);
		panelnewbook.add(book_name);
		book_name.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Book Name");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(287, 74, 113, 20);
		panelnewbook.add(lblNewLabel_9);
		
		textField_Author_name = new JTextField();
		textField_Author_name.setBounds(496, 94, 172, 29);
		panelnewbook.add(textField_Author_name);
		textField_Author_name.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Author");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(496, 74, 113, 20);
		panelnewbook.add(lblNewLabel_10);
		
		textField_Book_quantity = new JTextField();
		textField_Book_quantity.setBounds(76, 186, 188, 29);
		panelnewbook.add(textField_Book_quantity);
		textField_Book_quantity.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Quantity");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(76, 155, 162, 29);
		panelnewbook.add(lblNewLabel_11);
		
		textField_book_amount = new JTextField();
		textField_book_amount.setBounds(322, 186, 147, 29);
		panelnewbook.add(textField_book_amount);
		textField_book_amount.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Amount");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(322, 155, 124, 29);
		panelnewbook.add(lblNewLabel_12);
		
		JButton btnNewButton_2 = new JButton("ADD ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/librarysystem";
				String userName = "root";
				String userPassword = "";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection conn=DriverManager.getConnection(url,userName,userPassword);
					PreparedStatement ptmt=conn.prepareStatement("insert into book_details(Book_Name,Author_Name,Quanitity_Books,Amount_Book,Add_date,Book_Number)Values(?,?,?,?,?,?)");
					ptmt.setString(1,book_name.getText());
					ptmt.setString(2, textField_Author_name.getText());
					ptmt.setInt(3, Integer.valueOf(textField_Book_quantity.getText()));
					ptmt.setString(4, textField_book_amount.getText());
					LocalDate myObj = LocalDate.now();
					dateset = myObj;
					ptmt.setString(5, String.valueOf(dateset));
					ptmt.setString(6, textField_book_number.getText());
					
					
					ptmt.executeUpdate();
					conn.close();
					getData();
					book_name.setText("");
					textField_Author_name.setText("");
					textField_Book_quantity.setText("");
					textField_book_amount.setText("");
					textField_book_number.setText("");
					
					
							
							
				//JOptionPane.showConfirmDialog(null, "Successfully Connection");
					
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(121, 251, 143, 39);
		panelnewbook.add(btnNewButton_2);
		student.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		
		student.setBounds(211, 73, 692, 486);
		contentPane.add(student);
		student.setLayout(null);
		
		textField_14 = new JTextField();
		textField_14.setBounds(131, 11, 167, 29);
		student.add(textField_14);
		textField_14.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 89, 672, 371);
		student.add(scrollPane_1);
		
		
		
		student_view = new JTable(model2);
		scrollPane_1.setViewportView(student_view);
		newStudent.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		
		newStudent.setBounds(211, 73, 692, 486);
		contentPane.add(newStudent);
		newStudent.setLayout(null);
		
		textField_stu_name = new JTextField();
		textField_stu_name.setBounds(61, 83, 249, 29);
		newStudent.add(textField_stu_name);
		textField_stu_name.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Student Name");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_22.setBounds(61, 54, 125, 29);
		newStudent.add(lblNewLabel_22);
		
		textField_stu_father = new JTextField();
		textField_stu_father.setBounds(61, 150, 249, 29);
		newStudent.add(textField_stu_father);
		textField_stu_father.setColumns(10);
		
		JLabel lblNewLabel_23 = new JLabel("Father Name");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_23.setBounds(61, 123, 125, 29);
		newStudent.add(lblNewLabel_23);
		
		textField_stu_NO = new JTextField();
		textField_stu_NO.setBounds(61, 211, 249, 29);
		newStudent.add(textField_stu_NO);
		textField_stu_NO.setColumns(10);
		
		JLabel lblNewLabel_24 = new JLabel("Mobile Number");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_24.setBounds(61, 190, 125, 21);
		newStudent.add(lblNewLabel_24);
		
		JTextArea textArea_stu_address = new JTextArea();
		textArea_stu_address.setBounds(61, 280, 249, 76);
		newStudent.add(textArea_stu_address);
		
		JLabel lblNewLabel_25 = new JLabel("Address");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_25.setBounds(61, 251, 125, 29);
		newStudent.add(lblNewLabel_25);
		
		JButton btnNewButton_5 = new JButton("Submit");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
					PreparedStatement ptmt=conn.prepareStatement("insert into student_information(Stu_Name,Stu_Father_Name,Stu_Mobile_Number,Stu_Address) values(?,?,?,?)");
					ptmt.setString(1, textField_stu_name.getText());
					ptmt.setString(2, textField_stu_father.getText());
					ptmt.setInt(3, Integer.valueOf(textField_stu_NO.getText()));
					ptmt.setString(4, textArea_stu_address.getText());
					
					ptmt.executeUpdate();
					conn.close();
					
					textField_stu_name.setText("");
					textField_stu_father.setText("");
					textField_stu_NO.setText("");
					textArea_stu_address.setText("");
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(61, 390, 144, 34);
		newStudent.add(btnNewButton_5);
		retrunbook.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		
		retrunbook.setBounds(211, 73, 692, 486);
		contentPane.add(retrunbook);
		retrunbook.setLayout(null);
		
		textField_Retrun_book_id = new JTextField();
		textField_Retrun_book_id.setBounds(78, 87, 164, 36);
		retrunbook.add(textField_Retrun_book_id);
		textField_Retrun_book_id.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Book ID");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_19.setBounds(78, 62, 112, 26);
		retrunbook.add(lblNewLabel_19);
		
		textField_Retrun_Stu_ID = new JTextField();
		textField_Retrun_Stu_ID.setBounds(78, 165, 164, 36);
		retrunbook.add(textField_Retrun_Stu_ID);
		textField_Retrun_Stu_ID.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Student ID");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_20.setBounds(78, 140, 76, 26);
		retrunbook.add(lblNewLabel_20);
		
		textField_Retrun_issue_Date = new JTextField();
		textField_Retrun_issue_Date.setBounds(78, 240, 164, 36);
		retrunbook.add(textField_Retrun_issue_Date);
		textField_Retrun_issue_Date.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Issue Date");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_21.setBounds(78, 212, 112, 26);
		retrunbook.add(lblNewLabel_21);
		
		JLabel returnDate = new JLabel("");
		returnDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		returnDate.setBounds(357, 237, 144, 39);
		retrunbook.add(returnDate);
		
		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
					PreparedStatement ptmt=conn.prepareStatement("insert into retrun_book(Book_Number,Student_ID,Issue_date,End_issue_date) values(?,?,?,?)");
					ptmt.setString(1, textField_Retrun_book_id.getText());
					ptmt.setInt(2, Integer.valueOf(textField_Retrun_Stu_ID.getText()));
					ptmt.setString(3, textField_Retrun_issue_Date.getText());
					ptmt.setString(4, returnDate.getText());
					
					ptmt.executeUpdate();
					conn.close();
					
					textField_Retrun_book_id.setText("");
					textField_Retrun_Stu_ID.setText("");
					textField_Retrun_issue_Date.setText("");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(101, 337, 117, 39);
		retrunbook.add(btnNewButton_4);
		viewissuebook.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		
		viewissuebook.setBounds(213, 73, 690, 487);
		contentPane.add(viewissuebook);
		viewissuebook.setLayout(null);
		
		issuebookrecord();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 97, 670, 362);
		viewissuebook.add(scrollPane_2);
		issue_view = new JTable(model1);
		scrollPane_2.setViewportView(issue_view);
		
		textField_7 = new JTextField();
		textField_7.setBounds(152, 28, 130, 31);
		viewissuebook.add(textField_7);
		textField_7.setColumns(10);
		
		getData();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 903, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 11, 559, 50);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 67, 903, 466);
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(127, 255, 212));
		panel_1.setBounds(0, 72, 212, 497);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Add New Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelnewbook.setVisible(true);
				viewbook.setVisible(false);
				issuebook.setVisible(false);
				viewissuebook.setVisible(false);
				retrunbook.setVisible(false);
				newStudent.setVisible(false);
				student.setVisible(false);
				System.out.println("Panel 1");
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnNewButton.setBounds(76, 11, 126, 48);
		panel_1.add(btnNewButton);
		
		ImageIcon img=new ImageIcon("/add-books-read-literature-512.png");
		Image i =img.getImage();
		Image new_image = i.getScaledInstance(68, 48, Image.SCALE_SMOOTH);
		
		img = new ImageIcon(new_image);
		
		JLabel lblNewLabel_1 = new JLabel("",img,JLabel.CENTER);
		//lblNewLabel_1.setIcon(new ImageIcon("E:\\add-books-read-literature-512.png"));
		lblNewLabel_1.setBounds(10, 11, 68, 48);
		panel_1.add(lblNewLabel_1);
		
		JButton btnViewBooks = new JButton("View Book");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelnewbook.setVisible(false);
				viewbook.setVisible(true);
				issuebook.setVisible(false);
				viewissuebook.setVisible(false);
				retrunbook.setVisible(false);
				newStudent.setVisible(false);
				student.setVisible(false);
				
				
			}
		});
		btnViewBooks.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnViewBooks.setBounds(76, 70, 126, 48);
		panel_1.add(btnViewBooks);
		
		ImageIcon img1=new ImageIcon("/books.png");
		Image i1 =img1.getImage();
		Image new_image1 = i1.getScaledInstance(75, 55, Image.SCALE_SMOOTH);
		
		img1 = new ImageIcon(new_image1);
		
		JLabel lblNewLabel_2 = new JLabel("",img1,JLabel.CENTER);
		lblNewLabel_2.setBounds(10, 70, 68, 48);
		panel_1.add(lblNewLabel_2);
		
		JButton btnIssueBooks = new JButton("Issue Book");
		btnIssueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelnewbook.setVisible(false);
				viewbook.setVisible(false);
				issuebook.setVisible(true);
				viewissuebook.setVisible(false);
				retrunbook.setVisible(false);
				newStudent.setVisible(false);
				student.setVisible(false);
				System.out.println("Panel 3");
				LocalDate myObj = LocalDate.now();
				dateset = myObj;
				textField_Issue_date.setText(String.valueOf(dateset));
			
			}
		});
		btnIssueBooks.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnIssueBooks.setBounds(76, 129, 126, 48);
		panel_1.add(btnIssueBooks);
		
		
		ImageIcon img2=new ImageIcon("/issu.png");
		Image i2 =img2.getImage();
		Image new_image2 = i2.getScaledInstance(75, 55, Image.SCALE_SMOOTH);
		
		img2 = new ImageIcon(new_image2);
		
		JLabel lblNewLabel_3 = new JLabel("",img2,JLabel.CENTER);
		lblNewLabel_3.setBounds(10, 129, 68, 48);
		panel_1.add(lblNewLabel_3);
		
		JButton btnViewIssueBook = new JButton("View Issue Book");
		btnViewIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelnewbook.setVisible(false);
				viewbook.setVisible(false);
				issuebook.setVisible(false);
				viewissuebook.setVisible(true);
				retrunbook.setVisible(false);
				newStudent.setVisible(false);
				student.setVisible(false);
				System.out.println("Panel 4");
			}
		});
		btnViewIssueBook.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnViewIssueBook.setBounds(76, 188, 126, 48);
		panel_1.add(btnViewIssueBook);
		
		ImageIcon img3=new ImageIcon("/viewissue.png");
		Image i3 =img3.getImage();
		Image new_image3 = i3.getScaledInstance(75, 55, Image.SCALE_SMOOTH);
		
		img3 = new ImageIcon(new_image3);
		
		JLabel lblNewLabel_4 = new JLabel("",img3,JLabel.CENTER);
		lblNewLabel_4.setBounds(10, 188, 68, 49);
		panel_1.add(lblNewLabel_4);
		
		JButton btnReturnBooks = new JButton("Return Books");
		btnReturnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				panelnewbook.setVisible(false);
				viewbook.setVisible(false);
				issuebook.setVisible(false);
				viewissuebook.setVisible(false);
				retrunbook.setVisible(true);
				newStudent.setVisible(false);
				student.setVisible(false);
				System.out.println("Panel 5");
				LocalDate myObj = LocalDate.now();
				dateset = myObj;
				returnDate.setText(String.valueOf(dateset));
			
			}
		});
		btnReturnBooks.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnReturnBooks.setBounds(76, 247, 126, 48);
		panel_1.add(btnReturnBooks);
		
		
		ImageIcon img4=new ImageIcon("/retrun.png");
		Image i4 =img4.getImage();
		Image new_image4 = i4.getScaledInstance(75, 55, Image.SCALE_SMOOTH);
		
		img4 = new ImageIcon(new_image4);
		
		JLabel lblNewLabel_5 = new JLabel("",img4,JLabel.CENTER);
		lblNewLabel_5.setBounds(10, 248, 68, 48);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewStudents = new JButton("New Students");
		btnNewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				panelnewbook.setVisible(false);
				viewbook.setVisible(false);
				issuebook.setVisible(false);
				viewissuebook.setVisible(false);
				retrunbook.setVisible(false);
				newStudent.setVisible(true);
				student.setVisible(false);
				System.out.println("Panel 6");
				
				System.out.print(dateset);
				
			
			}
		});
		btnNewStudents.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnNewStudents.setBounds(76, 306, 126, 48);
		panel_1.add(btnNewStudents);
		
		ImageIcon img5=new ImageIcon("/newstudent.png");
		Image i5 =img5.getImage();
		Image new_image5 = i5.getScaledInstance(75, 55, Image.SCALE_SMOOTH);
		
		img5 = new ImageIcon(new_image5);
		
		JLabel lblNewLabel_6 = new JLabel("",img5,JLabel.CENTER);
		lblNewLabel_6.setBounds(10, 307, 68, 47);
		panel_1.add(lblNewLabel_6);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelnewbook.setVisible(false);
				viewbook.setVisible(false);
				issuebook.setVisible(false);
				viewissuebook.setVisible(false);
				retrunbook.setVisible(false);
				newStudent.setVisible(false);
				student.setVisible(true);
				studentrecord();
			}
		});
		btnStudents.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		btnStudents.setBounds(76, 365, 126, 48);
		panel_1.add(btnStudents);
		
		ImageIcon img6=new ImageIcon("/students.png");
		Image i6 =img6.getImage();
		Image new_image6 = i6.getScaledInstance(75, 55, Image.SCALE_SMOOTH);
		
		img6 = new ImageIcon(new_image6);
		
		JLabel lblNewLabel_7 = new JLabel("",img6,JLabel.CENTER);
		lblNewLabel_7.setBounds(10, 365, 68, 48);
		panel_1.add(lblNewLabel_7);
		
		
		ImageIcon img8=new ImageIcon("/logout.png");
		Image i8 =img8.getImage();
		Image new_image8 = i8.getScaledInstance(75, 45, Image.SCALE_SMOOTH);
		
		img8 = new ImageIcon(new_image8);
		
		JButton btnNewButton_1 = new JButton("Logout",img8);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);			
				LoginPage frame = new LoginPage();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.setBounds(10, 436, 192, 36);
		panel_1.add(btnNewButton_1);
		
		
		/*
		 * panel_2.setBounds(211, 72, 692, 497); contentPane.add(panel_2);
		 */
	}
}
