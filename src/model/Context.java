package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Context {
	private String name;
	private List<Container> containers;
	
	public Context(String name, List<Container> c) {
		super();
		this.name = name;
		this.containers = c;
		
	}

	public Context(String contextName) {
		this.name=contextName;
		this.containers = new ArrayList<Container>();
		
	}
	public Context(){
		this.containers = new ArrayList<Container>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElementWrapper
	@XmlElement(name="container")
	public List<Container> getContainers() {
		if(this.containers==null)
			return null;
		return  this.containers;
	}
	public void setContainer(List<Container> c) {
		this.containers = c;
		
	}
	public String toString(){
		String res="";
		res+="context "+this.getName()+"{\n";
			for(Container c : this.getContainers()){
				if (containers!=null){
					res+="\t"+c.toString()+"\n";
				}
			}
		
		res+="}\n";
		return res;
	}
}
