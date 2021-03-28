package Maze_game;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instructions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Instructions frame = new Instructions();
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
	public Instructions(String pp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrThereShould = new JTextArea();
		txtrThereShould.setEditable(false);
		txtrThereShould.setWrapStyleWord(true);
		txtrThereShould.setLineWrap(true);
		txtrThereShould.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrThereShould.setText("1. There should be only one path from left wall as well as right wall.\r\n2. There should be at least one path from left to right.\r\n \ti.e. There should be at least one solution to each maze.\r\n3. Time given for each level should be in seconds.\r\n4. Time should be given so as to set the difficulty level.\r\n5. That's it You are good to go.");
		txtrThereShould.setBounds(60, 94, 723, 315);
		contentPane.add(txtrThereShould);
		
		JLabel lblNewLabel = new JLabel("Instructions for Admin:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(60, 35, 419, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuPrimary.admin.createWindow();
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.GREEN);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(573, 438, 167, 70);
		contentPane.add(btnNewButton_2_1);
	}
	public Instructions(int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrThereShould = new JTextArea();
		txtrThereShould.setEditable(false);
		txtrThereShould.setWrapStyleWord(true);
		txtrThereShould.setLineWrap(true);
		txtrThereShould.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrThereShould.setText("1. There is one path from left wall as well as right wall.\r\n2. There is at least one path from left to right.\r\n3. Time given for each level should be in seconds.\r\n4. You have to reach the right wall within the time given.\r\n5. You can use following keys:\r\n\tW - UP\r\n\tA - LEFT\r\n\tS - DOWN\r\n\tD - RIGHT\r\n6. If You want to see the solution, Press Solution button at right end.\r\n7. If want to quit the game, Press exit.\r\n8. That's it. GO AND SOLVE SOME MAZES !!");
		txtrThereShould.setBounds(60, 94, 723, 335);
		contentPane.add(txtrThereShould);
		
		JLabel lblNewLabel = new JLabel("Instructions for Users:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(60, 35, 419, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainMenu(index).setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.GREEN);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(573, 438, 167, 70);
		contentPane.add(btnNewButton_2_1);
	}
}
