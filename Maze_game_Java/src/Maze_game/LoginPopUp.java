package Maze_game;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPopUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginPopUp frame = new LoginPopUp();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginPopUp(int x) {
		//Login
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Existing User? Login");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(175, 27, 226, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(238, 89, 226, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 166, 226, 41);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textField_1);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(34, 89, 187, 41);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(41, 162, 187, 41);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(278, 235, 143, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String passWord = textField_1.getText();
				System.out.println(userName+"\n"+passWord);
				int index = User.searchUser(userName,passWord);
				if(index != -1)
				{
					new MainMenu(index).setVisible(true);;
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Login Credentials! ", "Failure", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("New User ? Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPopUp().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(238, 322, 226, 33);
		contentPane.add(btnNewButton_1);
	}
	public LoginPopUp() {
		//New User Registrations
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User? Register");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(175, 27, 226, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(238, 89, 226, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(238, 158, 226, 41);
		contentPane.add(textField_1);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(34, 158, 187, 41);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(34, 222, 187, 41);
		contentPane.add(lblPassword);
		
		
		
		JButton btnNewButton_1 = new JButton("Existing User? Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPopUp(0).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(238, 355, 226, 33);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(238, 226, 226, 41);
		contentPane.add(textField_2);
		
		JLabel lblNickName = new JLabel("Nick Name : ");
		lblNickName.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickName.setForeground(Color.BLACK);
		lblNickName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNickName.setBounds(34, 89, 187, 41);
		contentPane.add(lblNickName);
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passWord = textField_2.getText();
				String nickName = textField.getText();
				String userName = textField_1.getText();
				System.out.println(nickName);
				System.out.println(userName);
				System.out.println(passWord);
				if(User.isValid(MainMenuPrimary.userList, userName))
				{
					MainMenuPrimary.add(new User(userName,passWord,nickName));
					System.out.println(MainMenuPrimary.listSize());
					new MainMenu(MainMenuPrimary.listSize()-1).setVisible(true);;
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "UserName already exists, Try login!! ", "Failure", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(277, 293, 143, 41);
		contentPane.add(btnNewButton);
		
	}
	public LoginPopUp(String pp) {
		//Admin Login
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(175, 27, 226, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(238, 89, 226, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 166, 226, 41);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textField_1);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(34, 89, 187, 41);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(41, 162, 187, 41);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = textField.getText();
				String pass = textField_1.getText();
				if(MainMenuPrimary.admin.verifyLogin(Name, pass))
				{
					MainMenuPrimary.admin.createWindow();
					dispose();
				}	
				else
					JOptionPane.showMessageDialog(null, "Incorrect Login Credentials!! ", "Failure", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(278, 235, 143, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenuPrimary().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(238, 322, 167, 33);
		contentPane.add(btnNewButton_1);
		
	}
}
