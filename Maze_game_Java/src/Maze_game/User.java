package Maze_game;

import java.util.ArrayList;

public class User extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int currentLevel = 0;
	String nickName = new String("Newbie^");
	MainMenu newUserMenu;
	User(String userName,String passWord,String nickName)
	{
		super(userName,passWord);
		this.nickName = nickName;
		
	}
	
	@Override
	String getpassWord() {
		// TODO Auto-generated method stub
		return passWord;
	}
	int getCurrentLevel()
	{
		return currentLevel;
	}
	static int searchUser(String userName,String passWord)
	{
		for(int i = 0;i<MainMenuPrimary.listSize();i++)
		{
			if(MainMenuPrimary.get(i).userName.equals(userName)&& MainMenuPrimary.get(i).passWord.equals(passWord))
			{
				return i;
			}
		}
		return -1;
		
	}
	static boolean isValid(ArrayList<User> userList,String userName)
	{
		System.out.println(userList.size());
		for(int i = 0;i < userList.size();i++)
		{
			try
			{
				if(userList.get(i).userName.equals(userName))
					return false;
			}
			finally
			{
				System.out.println(i);
			}
				
			
			
		}
		return true;
	}
}