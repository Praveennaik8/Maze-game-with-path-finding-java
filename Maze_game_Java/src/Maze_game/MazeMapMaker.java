package Maze_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MazeMapMaker extends JFrame{
	/**
     *
     */
    private static final long serialVersionUID = 1L;
    static int rows = 20;
    static int columns = 20;
    int panelSize = 25;
    static int map[][] = new int[columns][rows];
    ArrayList<String> mapList = new ArrayList<String>();
    int level = 0;
    boolean levelsExistAlready = false;
    JTextField textField;
    
    public MazeMapMaker(){
    	
    	getMapList();
    	getLevelChoice();
    	if(level != -1){
    		textField = new JTextField();
	        loadMap();
	        this.setResizable(false);
	        this.setSize((columns*panelSize)+250, (rows*panelSize)+70);
	        this.setTitle("Maze Map Maker");
	        this.setLayout(null);
	        JPanel contentPane = new JPanel();
			contentPane.setBackground(Color.CYAN);
			contentPane.setForeground(Color.CYAN);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textField.setToolTipText("Enter time limit in seconds");
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Tahoma", Font.BOLD, 16));
			textField.setBounds(550, 50, 167, 70);
			contentPane.add(textField);
			textField.setColumns(10);
			
			
			JButton btnNewButton_2_2 = new JButton("Save");
			btnNewButton_2_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int time = 40;
					try
					{
						time = Integer.parseInt(textField.getText());
					}
					catch(Exception e1)
					{
						//TO
						JOptionPane.showMessageDialog(null, "Invalid TIme , Default to 40 sec ", "Invalid", JOptionPane.INFORMATION_MESSAGE);
					}
					saveMap(time);
				}
			});
			btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNewButton_2_2.setForeground(Color.GREEN);
			btnNewButton_2_2.setBackground(Color.WHITE);
			btnNewButton_2_2.setBounds(550, 180, 167, 70);
			contentPane.add(btnNewButton_2_2);
			
			JButton btnNewButton_2_3 = new JButton("Discard Changes");
			btnNewButton_2_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					MainMenuPrimary.admin.createWindow();
					
				}
			});
			btnNewButton_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_2_3.setForeground(Color.GREEN);
			btnNewButton_2_3.setBackground(Color.WHITE);
			btnNewButton_2_3.setBounds(550, 310, 167, 70);
			
			contentPane.add(btnNewButton_2_3);
	        this.addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e) {
//	            	saveMap();
//	                new MainMenu(index);
	            }
	        });
	        
	        this.setLocationRelativeTo(null);
	        
	        for(int y = 0; y < columns; y++){
	            for(int x = 0; x < rows; x++){
	            	MapMakerTile tile = new MapMakerTile(x, y);
	                tile.setSize(panelSize-1, panelSize-1);
	                tile.setLocation((x*panelSize)+23, (y*panelSize)+25);
	                if(map[x][y] == 0){
	                    tile.setBackground(Color.BLACK);
	                }else{
	                    tile.setBackground(Color.GRAY);
	                }
	                
	                tile.setVisible(true);
	                
	                this.add(tile);
	            }
	        }
	        this.setVisible(true);
    	}else{
//    		new MainMenu(index);
    	}
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
	    	maps[mapList.size()] = "New level";
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
    
    public void saveMap(int time){
        try{
       
	        Writer wr = new FileWriter("Time "+level+".txt");
	        wr.write(time + "");
	        wr.close();
	        PrintWriter writer = new PrintWriter("Level "+level+".map", "UTF-8");
	        for(int y = 0; y < columns; y++){
	            for(int x = 0; x < rows; x++){
	                writer.print(map[x][y]);
	            }
	            writer.print("\r\n");
	        }
	        writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void loadMap(){
    	Scanner s;
		try {
			s = new Scanner(new File(".\\Time "+level+".txt"));
			int seconds = s.nextInt();
	        s.close();
	        textField.setText(seconds+"");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
			System.out.println("Unable to load time file(if exists), creating new time file.");
			try {
				File myObj = new File("Time "+level+".txt");
			      if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			      } else {
			        System.out.println("File already exists.");
			      }
		    } 
			catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
		    }
			Writer wr;
			try {
				wr = new FileWriter("Time "+level+".txt");
				wr.write(40 + "");
		        wr.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
        
        try{
        	
            
            BufferedReader br = new BufferedReader(new FileReader("Level "+level+".map"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String mapStr = sb.toString();
            br.close();
            int counter = 0;
            for(int y = 0; y < columns; y++){
                for(int x = 0; x < rows; x++){
                    String mapChar = mapStr.substring(counter, counter+1);
                    if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){//If it's a number
                        //System.out.print(mapChar);
                        map[x][y] = Integer.parseInt(mapChar);
                    }else{//If it is a line break
                        x--;
                        //System.out.print(mapChar);
                    }
                    counter++;
                }
            }
        }catch(Exception e){
            System.out.println("Unable to load existing map(if exists), creating new map.");
            for(int y = 0; y < columns; y++){
                for(int x = 0; x < rows; x++){
                    map[x][y] = 0;
                }
            }
        }
    }
}
