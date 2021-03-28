package Maze_game;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenuPrimary extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Admin admin = Admin.getInstance();
	public static ArrayList<User>userList = new ArrayList<User>();
	static boolean isVisited = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuPrimary frame = new MainMenuPrimary();
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
	public MainMenuPrimary() {
		if(!isVisited)
		{
			loadAllUsers();
			isVisited = true;
			onEnable();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPopUp("Admin").setVisible(true);
				dispose();
//				new_menu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(57, 126, 167, 70);
		contentPane.add(btnNewButton);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPopUp(1).setVisible(true);
				dispose();
				
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setForeground(Color.GREEN);
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(57, 260, 167, 70);
		contentPane.add(btnPlay);
		
		JButton btnNewButton_2_1 = new JButton("Exit");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1.setForeground(Color.GREEN);
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(57, 396, 167, 70);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("Maze Runner");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(255, 175, 175));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(255, 10, 302, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainMenuPrimary.class.getResource("/Maze_game/MazePicture.png")));
		lblNewLabel_1.setBounds(322, 90, 441, 431);
		contentPane.add(lblNewLabel_1);
	}

	private void loadAllUsers() {
		// TODO Auto-generated method stub
//		userList.add(null);
		
	}
	static User get(int index)
	{
		return userList.get(index);
	}
	static void  add(User user)
	{
		userList.add(user);
	}
	static int listSize()
	{
		return userList.size();
	}
	static void incrementLevel(int index,int level)
	{
		if(userList.get(index).currentLevel <= level)
		{
			userList.get(index).currentLevel+=1;
		}
	}
	
//	@SuppressWarnings("unchecked")
	public static void onEnable(){
	    try {
	        userList = (ArrayList<User>) SaveLoadList.load("userList.bin");
	    } catch (Exception ex) {
	        Logger.getLogger(MainMenuPrimary.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	public static void onDisable(){
	    try {
	        SaveLoadList.save(userList,"userList.bin");
	    } catch (Exception ex) {
	        Logger.getLogger(MainMenuPrimary.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	
}

//TO-DO
//1. Delete maze -> check
//2. Save users	