package model.copy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Context {
	private String name;
	private Container container;
	private Evl parent;
	
	public Context(String name, Container c, Evl parent) {
		super();
		this.name = name;
		this.container = c;
		this.parent = parent;
		
	}
	public Context(String name, Constraint c, Evl parent) {
		super();
		this.name = name;
		this.container = c;
		this.parent = parent;
		
	}
	public Context(String contextName, Evl parent) {
		this.parent=parent;
		this.name=contextName;
		
		//this.Container = new Container();
		//this.isSetContainer=false;
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
	public Evl getParent() {
		return parent;
	}
	public void setParent(Evl parent) {
		this.parent = parent;
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
