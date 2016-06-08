package prova.plugin.handlers;


import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;

import model.Check;
import model.Context;
import model.Do;
import model.Evl;

public class ProjectManagment {
	public static void Save(Evl evl,String path) throws JAXBException{
		/*// create JAXB context and instantiate marshaller
	    //JAXBContext context = JAXBContext.newInstance(Evl.class);
	    JAXBContext context = JAXBContext.newInstance(new Class[] {Evl.class,Context.class,model.Container.class,Check.class,model.Fix.class,Do.class,model.Operation.class,model.Fix.class,model.Fbool.class,model.Fint.class,model.Guard.class,model.Threshold.class,model.Title.class,model.Message.class,model.Critique.class,model.Constraint.class});
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 // Write to File
	    m.marshal(evl, new File(path));*/
		Gson gson = new Gson();
		System.out.println(gson.toJson(evl));

	}
	public static Evl Open(String path) throws JAXBException, FileNotFoundException{
			Evl evl = null;
			JAXBContext context = JAXBContext.newInstance(Evl.class);
			Unmarshaller um = context.createUnmarshaller();
		    evl = (Evl) um.unmarshal(new FileReader(path));
			
			return evl;
		    
	}
}
