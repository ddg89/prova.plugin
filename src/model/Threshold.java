package model;

import javax.xml.bind.annotation.XmlElement;

public class Threshold {
	String text;
	public Threshold(String text){
		this.text=text;
	}
	public Threshold() {
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return text;
	}
	public String getText() {
		return text;
	}
	@XmlElement
	public void setText(String text) {
		this.text = text;
	}
}
