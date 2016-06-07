package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Container {
	protected String type;
	protected String name;
	protected Check check;
	protected Message message;
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
	@XmlElement
	public void setParent(Context parent) {
		this.parent = parent;
	}
	public void removeCheck(){
		this.check=null;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public Check getCheck() {
		return check;
	}
	@XmlElement
	public void setCheck(Check check) {
		this.check = check;
	}
	public Message getMessage() {
		return message;
	}
	@XmlElement
	public void setMessage(Message message) {
		this.message = message;
	}
	public void removeMessage(){
		this.message=null;
	}


	public List<Fix> getFixList() {
		return fixList;
	}
	public void addFix(Fix f){
		this.fixList.add(f);
	}
	public void removeFix(Fix f){
		this.fixList.remove(f);
	}
	
	@XmlElementWrapper(name = "FixList")
	@XmlElement(name = "Fix")
	public void setFixList(List<Fix> fixList) {
		this.fixList = fixList;
	}
	public void addDotoFix(Fix fix , Do d){
		for(Fix f : this.getFixList()){
			if(f.equals(fix)){
				f.addDo(d);
			}
		}
	}
	public void removeTitleFromFix(Fix fix ){
		for(Fix f : this.getFixList()){
			if (f.equals(fix)) {
				f.removeTitle();
			}
		}
	}
	public void removeDoFromFix(Fix fix , Do d){
		for(Fix f : this.getFixList()){
			for(Do d2 : f.getDoList()){
				if(d2.equals(d)){
					f.removeDo(d2);
				}
			}
		}
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public void addOperationToCheck(Operation op , Check check){
		if (this.getCheck().equals(check)) {
			this.check.addOperation(op);
		}
	}
	public void removeOperationFromCheck(Operation op , Check check){
		if (this.getCheck().equals(check)) {
			this.check.removeOperation(op);
		}
	}
	
}
