package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Context {
	private String name;
	private Container container;
	
	public Context(String name, Container c) {
		super();
		this.name = name;
		this.container = c;
		
	}

	public Context(String contextName) {
		this.name=contextName;
		
	}
	public Context(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Container getContainer() {
		if(this.container==null)
			return null;
		return  this.container;
	}
	public void setContainer(Container c) {
		this.container = c;
		
	}
	public String toString(){
		String res="";
		res+="context "+this.getName()+"{\n";
		
			if (container!=null)
				res+=this.getContainer().toString();
				
		
		
		res+="}\n";
		return res;
	}
}
