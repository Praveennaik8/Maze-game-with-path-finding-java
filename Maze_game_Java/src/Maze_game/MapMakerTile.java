package Maze_game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MapMakerTile extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int x, y;
    
    public MapMakerTile(int x, int y){
        this.x = x;
        this.y = y;
        
        addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e) {
                    	if(e.getButton() == MouseEvent.BUTTON1){
	                        setBackground(Color.GRAY);
	                        MazeMapMaker.map[x][y] = 1;
                    	}
                    	if(e.getButton() == MouseEvent.BUTTON3){
	                        setBackground(Color.BLACK);
	                        MazeMapMaker.map[x][y] = 0;
                    	}
                    }
                });
    }
}
