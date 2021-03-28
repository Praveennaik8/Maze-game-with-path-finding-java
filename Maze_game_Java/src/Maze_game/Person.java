package Maze_game;

import java.io.Serializable;

public abstract class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userName;
	String passWord;
	Person()
	{
		//To-Do
	}
	Person(String userName,String passWord)
	{
		this.userName = userName;
		this.passWord = passWord;
	}
	String getUserName()
	{
		return userName;
	}
	abstract String getpassWord();
}
