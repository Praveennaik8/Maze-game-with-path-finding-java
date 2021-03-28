package Maze_game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SpecialComboBox comboBox;
	ArrayList<String> mapList = new ArrayList<String>();
	ArrayList<String> timeList = new ArrayList<String>();

	public MainMenu(int index) {
		System.out.println(index);
		System.out.println(MainMenuPrimary.listSize());
		getMapList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new SpecialComboBox();
		String[] mapListextra = mapList.toArray(new String[mapList.size()]);
		for(int i = 0;i<mapListextra.length;i++)
		{
			if(i<=MainMenuPrimary.get(index).currentLevel)
			{
				comboBox.addItem(mapListextra[i]);
			}
			else
			{
				comboBox.addItem(mapListextra[i],false);
			}
			
		}
		
		comboBox.setBounds(57, 116, 167, 38);
		contentPane.add(comboBox);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = comboBox.getSelectedItem().toString();
				String numericPart = string.substring(string.indexOf(" ")+1, string.indexOf(".")); 
				int number = Integer.parseInt(numericPart); 
				new Maze(string,index,number,"Time "+number+".txt");
				dispose();
				MainMenuPrimary.onDisable();
			}
		});
		btnPlay.setForeground(Color.GREEN);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(57, 196, 167, 70);
		contentPane.add(btnPlay);
		
		JButton btnNewButton_1_1 = new JButton("Instructions");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Instructions(index).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.GREEN);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(57, 316, 167, 70);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Exit");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuPrimary.onDisable();
				new MainMenuPrimary().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setForeground(Color.GREEN);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(57, 427, 167, 70);
		contentPane.add(btnNewButton_1_2);
		
		
		
		JLabel lblNewLabel = new JLabel("Select Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(57, 84, 167, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Maze Runner");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(294, 12, 302, 70);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MainMenu.class.getResource("/Maze_game/MazePicture.png")));
		lblNewLabel_1_1.setBounds(321, 92, 441, 431);
		contentPane.add(lblNewLabel_1_1);
		//
		JLabel lblNewLabel_2 = new JLabel("Hello "+MainMenuPrimary.get(index).nickName);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 24, 198, 22);
		contentPane.add(lblNewLabel_2);
	}
//	public JComboBox getComboBox() {
//		
//		return comboBox;
//	}
	static boolean levelsExistAlready = false ;

    public void getMapList(){
    	
    	for(int i = 0; i < 99; i++){
    		File map = new File("./Level "+i+".map");
    		File time = new File("./Time "+i+".txt");
    		if(map.exists() && time.isFile())
    		{
    			System.out.println("Level "+i+" exists");
    			System.out.println("Time "+i+" exists");
    			mapList.add("Level "+i+".map");
    			timeList.add("./Time "+i+".txt");
    			levelsExistAlready = true;
    		}
    	}
    }
}
