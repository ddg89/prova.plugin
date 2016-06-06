package prova.plugin.handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import model.Evl;

public class ProjectManagment {
	public static Gson Save(Evl evl){
		Gson gson = new Gson();
		
		/*try {
		      File file = new File("C:\test.dav");
		      FileWriter fw = new FileWriter(file);
		      fw.write(gson.toJson(evl));
		      fw.flush();
		      fw.close();
		    }
		    catch(IOException e) { 
		      e.printStackTrace();
		    }*/
		try (FileWriter file = new FileWriter("C:/Users/Davide/Desktop/file1.dav")) {
			file.write(gson.toJson(evl));
			System.out.println("Successfully Copied JSON Object to File...");
		}catch(IOException e) { 
		      e.printStackTrace();
		}
		return gson;
	}
	public static Evl Open(Gson gson){
		Evl evl = null;
		return evl;
	}
}
