package model2;

import java.util.ArrayList;
import java.util.List;

public class Fix {
	
	private Title title;
	private List<Do> doList;
	private Container parent;
	
	public Fix(Title title, List<Do> doList,Container parent) {
		super();
		this.title = title;
		this.doList = doList;
		this.parent=parent;
	}
	public Fix(Container parent){
		this.title=null;
		this.doList = new ArrayList<Do>();
		this.parent = parent;
	}
	public Fix(){
		
	}
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	public void removeTitle(){
		this.title=null;
	}
	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		this.parent = parent;
	}

	public List<Do> getDoList() {
		return doList;
	}

	public void setDoList(List<Do> doList) {
		this.doList = doList;
	}
	public void addDo(Do d){
		this.doList.add(d);
		
	}
	public void removeDo(Do d){
		for(Do d2 : this.getDoList()){
			if(d2.equals(d)){
				this.doList.remove(d2);
			}
		}
	}
	public String toString(){
		
		String res = "fix {\n";
		if(title!=null)
			res+="title : \""+title+"\" \n";
		
		for(Do d : this.getDoList()){
			res+="do {\n";
			for(String s : d.getFunctions()){
				res+=s+"\n";
			}
			res+="}\n";
		}
		
		res+="}\n";
		return res;
	}
	
}
