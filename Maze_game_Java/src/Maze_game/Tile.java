package Maze_game;

import javax.swing.JPanel;

public class Tile extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int x, y;
    boolean isWall = true;
    
    public Tile(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setWall(boolean isWall){
        this.isWall = isWall;
    }
}
