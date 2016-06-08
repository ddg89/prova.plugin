package model.copy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Do {
	@XmlElementWrapper(name = "functionList")
	@XmlElement(name = "function")
	private List<String> functions;
	private Fix parent; 
	
	public Do(Fix parent){
		this.parent=parent;
		functions = new ArrayList<String>();
		
	}
	public Do() {
		super();
	}
	public Fix getParent() {
		return parent;
	}
	public void setParent(Fix parent) {
		this.parent = parent;
	}
	
	public List<String> getFunctions() {
		return functions;
	}
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	public String toString(){
		String res ="";
		for(String s : this.getFunctions()){
			res+=s+"\n";
		}
		return res;
	}

}
