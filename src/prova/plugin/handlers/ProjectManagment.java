package prova.plugin.handlers;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import model.Evl;

public class ProjectManagment {
	public static void Save(Evl evl,String path){
		
		try {
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
			encoder.writeObject(evl);
			encoder.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static Evl Open(String path){
		    XMLDecoder dec;
			try {
				dec = new XMLDecoder (new BufferedInputStream(new FileInputStream(path)));
				Evl evl = (Evl)dec.readObject();
			    dec.close();
			    return evl;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		    
	}
}
