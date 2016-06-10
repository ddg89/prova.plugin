package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="invariant")
public class Container {
	protected String type;
	protected String name;
	protected Check check;
	protected Message message;
	private List<Fix> fixList;
	
	public Container (String label, String name, Check check, List<Fix> fixList,Message message)  {
			this.name = name;
			this.check = check;
			this.fixList = fixList;
			this.message=message;
		
	}
	public Container( String critiqueName) {
		this.name=critiqueName;
		this.check = null;
		this.message = null;
		this.fixList = new ArrayList<Fix>();
	}
	public Container() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@XmlElementWrapper
	@XmlElement(name="fix")
	public List<Fix> getFixList() {
		return fixList;
	}
	public void setFixList(List<Fix> fixList) {
		this.fixList = fixList;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}