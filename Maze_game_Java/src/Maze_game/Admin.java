package Maze_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Admin extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Admin single_instance = null; 
	static AdminWindow myAdmin;
	private Admin()
	{
		super();
		userName = "admin";
		passWord = "admin";
	}
	public static Admin getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Admin(); 
  
        return single_instance; 
    } 
	private Admin(String userName,String passWord)
	{
		super(userName,passWord);
		userName = "admin";
		passWord = "admin";
	}
	boolean verifyLogin(String user,String pass)
	{
		if(this.userName.equals(user) && this.passWord.equals(pass))
			return true;
		return false;
	}
	@Override
	String getpassWord() {
		// TODO Auto-generated method stub
		return passWord;
	}
	void createWindow()
	{
		myAdmin = new AdminWindow();
		myAdmin.setVisible(true);
	}

private class AdminWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<String> mapList = new ArrayList<String>();
    int level = 0;
    boolean levelsExistAlready = false;

	public AdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 568);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add maze");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MazeMapMaker new_map = new MazeMapMaker();
				new_map.setVisible(true);
				dispose();
//				new_menu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(57, 101, 167, 70);
		contentPane.add(btnNewButton);
		
		JButton btnPlay = new JButton("Delete Maze");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TO-DO
				getMapList();
				getLevelChoice();
				if(level!=-1)
				{
					File file = new File("Level "+level+".map");
					File time_file = new File("Time "+level+".txt");
			          
			        if(file.delete() && time_file.delete()) 
			        { 
//			            System.out.println("File deleted successfully"); 
			            JOptionPane.showMessageDialog(null, "File deleted successfully!! ", "Success", JOptionPane.INFORMATION_MESSAGE);
			        } 
			        else
			        { 
//			            System.out.println("Failed to delete the file"); 
			            JOptionPane.showMessageDialog(null, "Failed to delete the file!! ", "Failure", JOptionPane.INFORMATION_MESSAGE);
			        } 
				}
				
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setForeground(Color.GREEN);
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(57, 212, 167, 70);
		contentPane.add(btnPlay);
		
		JButton btnNewButton_2_1 = new JButton("Exit");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenuPrimary new_main = new MainMenuPrimary();
				new_main.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1.setForeground(Color.GREEN);
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(57, 438, 167, 70);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("Maze Runner");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(299, 10, 302, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminWindow.class.getResource("/Maze_game/MazePicture.png")));
		lblNewLabel_1.setBounds(322, 90, 441, 431);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Instructions");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Instructions("").setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1_1.setForeground(Color.GREEN);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1_1.setBackground(Color.WHITE);
		btnNewButton_2_1_1.setBounds(57, 328, 167, 70);
		contentPane.add(btnNewButton_2_1_1);
	}
	public void getMapList(){
    	for(int i = 0; i < 99; i++){
    		File map = new File("./Level "+i+".map");
    		if(map.exists()){
    			System.out.println("Level "+i+" exists");
    			mapList.add("Level "+i+".map");
    			levelsExistAlready = true;
    		}
    	}
    }
	public void getLevelChoice(){
    	if(levelsExistAlready){
	    	String maps[] = new String[99];
	    	mapList.toArray(maps);
//	    	maps[mapList.size()] = "New level";
	    	String choice = (String)JOptionPane.showInputDialog(null, "Which level would you like to play?", "Maze Level Selector", JOptionPane.QUESTION_MESSAGE, null, maps, maps[0]);
	    	System.out.println(choice);
	    	if(choice != null && !choice.equals("New level")){
	    		level = Integer.parseInt((choice.replace("Level ", "").replace(".map", "")));
	    	}else if(choice == null){
	    		level = -1;
	    	}else{
	    		level = mapList.size();
	    	}
    	}
    }
    
}

}
