package Maze_game;

import java.awt.Color;

import javax.swing.JPanel;


public class Player extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int x, y;
	
    public Player(int x) {
    	if( x == 1)
    	{
    		this.setBackground(Color.getHSBColor(1f, 1f, 1));
    		this.setSize(Maze.panelSize, Maze.panelSize);
    	}
    	else
    	{
    		this.setBackground(Color.getHSBColor(0.5f, 0.5f, 1));
    		this.setSize(Maze.panelSize, Maze.panelSize);
    	}
    }

    public void moveLeft() {
    	if(x > 0 && Maze.map[x-1][y] == 1){
	    	this.setLocation(this.getX()-25, this.getY());
	    	x--;
    	}
    }

    public void moveRight() {
    	if(x < Maze.columns-1 && Maze.map[x+1][y] == 1){
	    	this.setLocation(this.getX()+25, this.getY());
	    	x++;
    	}
    }

    public void moveUp() {
    	if(y > 0 && Maze.map[x][y-1] == 1){
	    	this.setLocation(this.getX(), this.getY()-25);
	    	y--;
    	}
    }

    public void moveDown() {
    	if(y < Maze.rows-1 && Maze.map[x][y+1] == 1){
	    	this.setLocation(this.getX(), this.getY()+25);
	    	y++;
    	}
    }
}
