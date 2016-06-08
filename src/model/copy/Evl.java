package model.copy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "model")
public class Evl{
	@XmlElementWrapper(name = "contexts")
	@XmlElement(name = "context")
	List<Context> contextList;

	public Evl(List<Context> contextList) {
		super();
		this.contextList = contextList;
	}

	public Evl() {
		this.contextList = new ArrayList<Context>();
	}

	public List<Context> getContextList() {
		return contextList;
	}
	public void setContextList(List<Context> contextList) {
		this.contextList = contextList;
	}
	public String toString(){
		String res="";
		for(Context c : this.getContextList()){
			res+=c.toString();
		}
		return res;
	}

}
