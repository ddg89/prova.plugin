package model;

import javax.xml.bind.annotation.XmlElement;

public class Title {
	private String text;
	private Fix parent;
	public Title(String text, Fix parent) {
		super();
		this.text = text;
		this.parent = parent;
	}
	public Title(Fix parent) {
		super();
		
		this.parent = parent;
	}
	public Title(){
		
	}
	public String getText() {
		return text;
	}
	@XmlElement
	public void setText(String text) {
		this.text = text;
	}
	public Fix getParent() {
		return parent;
	}
	@XmlElement
	public void setParent(Fix parent) {
		this.parent = parent;
	}
	public String toString(){
		return this.text;
	}
}
