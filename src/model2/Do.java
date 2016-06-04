package model2;

import java.util.ArrayList;
import java.util.List;

public class Do {
	private List<String> functions;
	
	private Fix parent; 
	
	public Do() {
		super();
	}
	public Fix getParent() {
		return parent;
	}
	public void setParent(Fix parent) {
		this.parent = parent;
	}
	public Do(Fix parent){
		this.parent=parent;
		functions = new ArrayList<String>();
		
	}
	
	public List<String> getFunctions() {
		return functions;
	}
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	public void addFunction(String f){
		this.functions.add(f);
	}
	public String toString(){
		String res ="";
		for(String s : this.getFunctions()){
			res+=s+"\n";
		}
		return res;
	}

}
