package Maze_game;

import java.awt.Color;
import javax.swing.Timer ;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Maze extends JFrame{
    /**
     *
     */
	
    private static final long serialVersionUID = 1L;
    public static int rows = 20;
    public static int columns = 20;
    public static int panelSize = 25;
    public static int map[][] = new int[columns][rows];
    public static int endLevelLoc;
    
    Player p;
    Tile[][] tiles = new Tile[columns][rows];
    int seconds = 40;
    private Timer timer;
    private long startTime;
    boolean cancelKey = false;
    public static class Cell {
        public int row;     
        public int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;         
        }

        @Override
        public String toString() {
            return "{" + row + ", " + col + "}";
        }
    }
    public Maze(String str,int index,int level,String time){
    	JButton btnNewButton_2_1 = new JButton("Exit");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				new MainMenu(index).setVisible(true);
				dispose();
				
			}
		});
		JButton btnNewButton_2_2 = new JButton("Solution");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				solution();
			}
		});
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1.setForeground(Color.GREEN);
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(550, 50, 167, 70);
		contentPane.add(btnNewButton_2_1);
		
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_2.setForeground(Color.GREEN);
		btnNewButton_2_2.setBackground(Color.WHITE);
		btnNewButton_2_2.setBounds(550, 180, 167, 70);
		contentPane.add(btnNewButton_2_2);
		
		JLabel label = new JLabel();
		label.setForeground(Color.BLUE);
		label.setBackground(new Color(255, 175, 175));
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(550, 280, 302, 70);
		contentPane.add(label);
		
		
		contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();
		contentPane.requestFocus();
		this.setFocusable(true);
		this.requestFocus();
		
        loadMap(str,time);
//        this.setResizable(false);
        this.setSize((columns*panelSize)+250, (rows*panelSize)+70);
        this.setTitle("Maze");
        this.setLayout(null);
        
//        this.add(new TestPane());
        
        this.addKeyListener(new KeyListener(){
        	
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(!cancelKey)
				{
					revalidate();
					repaint();
//					Player px = new Player(1);
//					px.x = p.x;
//					px.y = p.y;
//			    	px.setVisible(true);
			    	tiles[p.y][p.x].setBackground(Color.YELLOW);
					
					//Player movement
					if(key == KeyEvent.VK_W){
						p.moveUp();
					}
					if(key == KeyEvent.VK_A){
						p.moveLeft();
					}
					if(key == KeyEvent.VK_S){
						p.moveDown();
					}
					if(key == KeyEvent.VK_D){
						p.moveRight();
					}
					
					if(p.x == columns-1 && p.y == endLevelLoc){
						timer.stop();
						JOptionPane.showMessageDialog(null, "Congratulations, you've beaten the level!", "End Game", JOptionPane.INFORMATION_MESSAGE);
						MainMenuPrimary.incrementLevel(index, level);
						MainMenuPrimary.onDisable();
						solution();
						System.out.println("level : "+level);
						
//						dispose();
//						new MainMenu();
					}
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
//			this.add(px);
        	
        });
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                //System.out.println((columns*panelSize)+50+"-"+((rows*panelSize)+70));
                System.exit(0);
            }
        });
        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long endTime = (startTime + seconds*1000);
                long timeLeft = endTime - System.currentTimeMillis();
                
                if (timeLeft < 0) {
                    timer.stop();
                    label.setText("Time Up");
                    JOptionPane.showMessageDialog(null, "Your Time is up, You have lost!! ", "End Game", JOptionPane.INFORMATION_MESSAGE);
                    cancelFocus();
                }
                else if(timeLeft < 15000L)
                {
                	label.setForeground(Color.RED);
                	label.setText("Remaining Time :"+Long.toString(timeLeft / 1000));
                }
                else {
                    label.setText("Remaining Time :"+Long.toString(timeLeft / 1000));
                }
                repaint();
            }
        });
        this.setLocationRelativeTo(null);
        
        //Create player
    	p = new Player(1);
    	p.setVisible(true);
    	this.add(p);
    	
        //Color map
        for(int y = 0; y < columns; y++){
            for(int x = 0; x < rows; x++){
            	
                tiles[y][x]= new Tile(x, y);
                tiles[y][x].setSize(panelSize, panelSize);
                tiles[y][x].setLocation((x*panelSize)+23, (y*panelSize)+25);
                if(map[x][y] == 0){
                	 tiles[y][x].setBackground(Color.BLACK);
                }else{
                	 tiles[y][x].setBackground(Color.WHITE);
                	 tiles[y][x].setWall(false);
                    if(x == 0){
                    	p.setLocation((x*panelSize)+23, (y*panelSize)+25);
                    	p.y = y;
                    }
                    if(x == columns-1){
                    	endLevelLoc = y;
                    }
                }
                
                tiles[y][x].setVisible(true);
                this.add( tiles[y][x]);
            }
        }
        this.setVisible(true);
        startTime = System.currentTimeMillis();
        timer.restart();
    }
    
//    public static void main(String args[]){
//    	new MainMenu(index);
//    }
//    
    public void loadMap(String str,String time){
        try{
        	
        	Scanner s = new Scanner(new File(time));
            this.seconds = s.nextInt();
            s.close();
            
        	
            BufferedReader br = new BufferedReader(new FileReader(str));
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
                        System.out.print(mapChar);
                    }
                    counter++;
                }
            }
            
        }catch(Exception e){
            System.out.println("Unable to load existing map(if exists), creating new map.");
        }
    }
    public void cancelFocus()
    {
    	this.cancelKey = true;
    }
    public void solution()
    {
    	//TO-DO
    	int start_x = 0 ,start_y = 0,end_x = 0,end_y = rows-1;
    	String[][] mapstr = new String[columns][rows];
    	for(int i = 0;i < rows;i++)
    		if(map[0][i]==1)
    			start_x = i;
    	for(int i = 0;i < columns;i++)
    		if(map[rows-1][i]==1)
    			end_x = i;
    	for(int i = 0;i<rows;i++)
    	{
    		for(int j = 0;j<columns;j++)
    		{
    			mapstr[i][j] = new String(Integer.toString(map[j][i]));
    		}
    	}
    	System.out.println(start_x+" "+start_y+" "+end_x+" "+end_y);
    	for(int i = 0;i<columns;i++)
    	{
    		for(int j = 0;j<rows;j++)
    		{
    			System.out.print(mapstr[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println(mapstr);
    	 Stack<Cell> path = new Stack<>();
    	    System.out.println(shortestPath(mapstr, new Cell(start_x, start_y), new Cell(end_x, end_y), path));

    	    while (!path.isEmpty()) {
    	    	Cell temp = path.pop() ;
    	        System.out.print(temp + ", ");
    	        tiles[temp.row][temp.col].setBackground(Color.GREEN); 
    	    }
    	   
    	
    	
    }
    public static int shortestPath(String[][] map, Cell start, Cell end,
    	    Stack < Cell > path) {
    	    // initialize distances array filled with infinity
    	    int[][] distances = new int[map.length][];
    	    for (int i = 0; i < map.length; i++) {
    	        distances[i] = new int[map[i].length];
    	        Arrays.fill(distances[i], Integer.MAX_VALUE);
    	    }

    	    // the start node should get distance 0
    	    int distance = 0;
    	    List < Cell > currentCells = Arrays.asList(start);

    	    while (distances[end.row][end.col] == Integer.MAX_VALUE &&
    	        !currentCells.isEmpty()) {
    	        List < Cell > nextCells = new ArrayList < > ();

    	        // loop over all cells added in previous round
    	        // set their distance 
    	        //    and add their neighbors to the list for next round
    	        for (Cell cell: currentCells) {
    	            if (distances[cell.row][cell.col] == Integer.MAX_VALUE &&
    	                !map[cell.row][cell.col].equals("0")) {
    	                distances[cell.row][cell.col] = distance;
    	                addNeighbors(cell, nextCells, map.length, map[0].length);
    	            }
    	        }

    	        // prepare for next round
    	        currentCells = nextCells;
    	        distance++;
    	    }

    	    // find the path
    	    if (distances[end.row][end.col] < Integer.MAX_VALUE) {
    	        Cell cell = end;
    	        path.push(end);
    	        for (int d = distances[end.row][end.col] - 1; d >= 0; d--) {
    	            cell = getNeighbor(cell, d, distances);
    	            path.push(cell);
    	        }
    	    }

    	    return distances[end.row][end.col];
    }
 // add all valid neighbors of a cell to the list
 // where "valid" means: indices inside the maze
 private static void addNeighbors(Cell cell, List < Cell > list,
     int maxRow, int maxCol) {
     int[][] ds = {
         {
             -1, 0
         },
         {
             1,
             0
         },
         {
             0,
             -1
         },
         {
             0,
             1
         }
     };
     for (int[] d: ds) {
         int row = cell.row + d[0];
         int col = cell.col + d[1];
         if (isValid(row, col, maxRow, maxCol))
             list.add(new Cell(row, col));
     }
 }

 // find the neighbor of a cell having a certain distance from the start        
 private static Cell getNeighbor(Cell cell, int distance, int[][] distances) {
     int[][] ds = {
         {
             -1, 0
         },
         {
             1,
             0
         },
         {
             0,
             -1
         },
         {
             0,
             1
         }
     };
     for (int[] d: ds) {
         int row = cell.row + d[0];
         int col = cell.col + d[1];
         if (isValid(row, col, distances.length, distances[0].length) &&
             distances[row][col] == distance)
             return new Cell(row, col);
     }
     return null;
 }

 // check if coordinates are inside the maze
 private static boolean isValid(int row, int col, int maxRow, int maxCol) {
     return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
 }

    
}
