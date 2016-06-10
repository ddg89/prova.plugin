package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fix {
	
	private Title title;
	private List<Do> doList;
	
	public Fix(Title title, List<Do> doList) {
		//super();
		this.title = title;
		this.doList = doList;
	}
	public Fix(){
		this.title=null;
		this.doList = new ArrayList<Do>();
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	@XmlElementWrapper
	@XmlElement
	public List<Do> getDoList() {
		return doList;
	}
	public void setDoList(List<Do> doList) {
		this.doList = doList;
	}
	public String toString(){
		
		String res = "\t\t\tfix {\n";
		if(title!=null)
			res+="\t\t\t\ttitle : \""+title+"\" \n";
		
		for(Do d : this.getDoList()){
			res+="\t\t\t\tdo {\n";
			for(String s : d.getFunctions()){
				res+="\t\t\t\t\t"+s+"\n";
			}
			res+="\t\t\t\t}\n";
		}
		
		res+="\t\t\t}\n";
		return res;
	}
	
}
