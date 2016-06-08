package model.copy;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Container {
	protected String type;
	protected String name;
	protected Check check;
	protected Message message;
	@XmlElementWrapper(name = "fixies")
	@XmlElement(name = "fix")
	private List<Fix> fixList;
	private Context parent;
	
	public Container (String label, String name, Check check, List<Fix> fixList,Message message,Context parent)  {
			this.name = name;
			this.check = check;
			this.fixList = fixList;
			this.message=message;
			this.parent=parent;
		
	}
	public Container( String critiqueName, Context parent) {
		this.name=critiqueName;
		this.parent=parent;
		this.check = null;
		this.message = null;
		this.fixList = new ArrayList<Fix>();
	}
	public Container() {
		
	}

	public Context getParent() {
		return parent;
	}
	public void setParent(Context parent) {
		this.parent = parent;
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
