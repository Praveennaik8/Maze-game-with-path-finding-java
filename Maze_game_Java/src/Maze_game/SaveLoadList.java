package Maze_game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SaveLoadList {
	
    public static void save(ArrayList<User> obj,String path) throws Exception {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
//            oos.writeObject(obj);
//            oos.flush();
//        }
    	FileOutputStream outStream = new FileOutputStream(path);
    	ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
    	objectOutStream.writeInt(obj.size()); // Save size first
    	for(User r:obj)
    	    objectOutStream.writeObject(r);
    	objectOutStream.close();
    }

    public static ArrayList<User> load(String path) throws Exception {
//        Object result;
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
//            result = ois.readObject();
//        }
//        return result;
    	FileInputStream inStream = new FileInputStream(path);
    	ObjectInputStream objectInStream = new ObjectInputStream(inStream);
    	int count = objectInStream.readInt(); // Get the number of regions
    	ArrayList<User> rl = new ArrayList<User>();
    	for (int c=0; c < count; c++)
    	    rl.add((User) objectInStream.readObject());
    	objectInStream.close();
    	return rl;
    }
}